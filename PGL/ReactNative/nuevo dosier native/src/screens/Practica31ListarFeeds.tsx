import { FlatList, StyleSheet, Text, View } from 'react-native'
import React, { useEffect, useState } from 'react'
import { FeedRepository } from '../data/Database'
import { TouchableHighlight, TouchableOpacity } from 'react-native'
import { useFocusEffect } from '@react-navigation/native'

type Props = {
    navigation: any
}

type Feed = {
    titulo: string,
    url: string
}

const Practica31ListarFeeds = ({navigation}: Props) => {
    const [feeds, setFeeds] = useState<Array<Feed>>([]);

    useFocusEffect(() => {
        async function getFeeds(){
            let a = await FeedRepository.find();

            setFeeds(a);
        }

        getFeeds();
    });

    return (
        <View>
            <TouchableOpacity onPress={() => navigation.navigate("Practica31Crear")}>
                <Text>Crear Feed</Text>
            </TouchableOpacity>
            <FlatList 
                data={feeds}
                renderItem={({item}) => (
                    <TouchableHighlight onPress={() => navigation.navigate("Practica31Listar",{feed: item})}>
                        <Text>{item.titulo+"---"+item.url}</Text>
                    </TouchableHighlight>
                )}
            />
        </View>
    )
}

export default Practica31ListarFeeds

const styles = StyleSheet.create({})