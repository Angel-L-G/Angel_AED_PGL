import { StyleSheet, Text, TextInput, TouchableHighlight, View } from 'react-native'
import React, { useState } from 'react'
import { FeedRepository } from '../data/Database'
import { FeedItem } from '../entities/FeedItem';

type Props = {
    navigation: any,
}

type Feed = {
    id: undefined,
    titulo: string,
    url: string
    FeedItems: Array<FeedItem>
}

const Practica31Crear = (props: Props) => {
    const [titulo, setTitulo] = useState("");
    const [url, setUrl] = useState("");

    async function crearFeed() {
        let feed: Feed = {
            id: undefined,
            titulo: titulo,
            url: url,
            FeedItems: []
        }

        let arr: Array<Feed> = [];
        arr.push(feed);
        await FeedRepository.save(arr);

        props.navigation.navigate("Practica31ListarFeeds");
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