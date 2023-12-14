import { StyleSheet, Text, TextInput, TouchableHighlight, View } from 'react-native'
import React, { useState } from 'react'
import { FeedRepository } from '../data/Database'
import { FeedItem } from '../entities/FeedItem';

type Props = {
    navigation: any,
}

type FormFeed = {
    titulo: string,
    url: string
    
}

const Practica31Crear = (props: Props) => {
    const [titulo, setTitulo] = useState("");
    const [url, setUrl] = useState("");

    async function crearFeed() {
        console.log(1);
        let feed: FormFeed = {
            titulo: titulo,
            url: url,
        }

        console.log(feed.titulo+"---"+feed.url);

        console.log(2);

        const feedVar = await FeedRepository.save(feed);

        console.log(feedVar);
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