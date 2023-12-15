import { StyleSheet, Text, TextInput, TouchableHighlight, View } from 'react-native'
import React, { useState } from 'react'
import { FeedItemRepository, FeedRepository } from '../data/Database'
import axios from 'axios';
import * as rssParser from 'react-native-rss-parser';

type Props = {
    navigation: any,
}

type FormFeed = {
    titulo: string,
    url: string
}

type Feed = {
    id: number,
    titulo: string,
    url: string
}

type FeedItem = {
    titulo: string,
    descripcion: string,
    visited: boolean,
    feed: FormFeed,
}

const Practica31Crear = (props: Props) => {
    const [titulo, setTitulo] = useState("");
    const [url, setUrl] = useState("");

    async function crearFeed() {
        let feed: FormFeed = {
            titulo: titulo,
            url: url,
        }

        const feedVar: Feed = await FeedRepository.save(feed);

        console.log(feedVar);

        getFeedItems(feedVar);

        props.navigation.navigate("Practica31ListarFeeds");
    }

    async function getFeedItems(feed:Feed){
        try{
            const response = await axios.get(feed.url);
            const data = response.data ;
            const responseData = await rssParser.parse(data);

            for (let i = 0; i < responseData.items.length; i++){
                let item: FeedItem = {
                    titulo: responseData.items[i].title,
                    descripcion: responseData.items[i].description,
                    visited: false,
                    feed: feed
                }

                let a = await FeedItemRepository.save(item);
            }
        }catch( error){
            console.log(error);
        }
    }

    return (
        <View>
            <TextInput placeholder="Titulo Feed" onChangeText={(t) => setTitulo(t)}/>
            <TextInput placeholder="URL Feed" onChangeText={(u) => setUrl(u)}/>
            <TouchableHighlight onPress={crearFeed} >
                <Text>Crear</Text>
            </TouchableHighlight>
        </View>
    )
}

export default Practica31Crear