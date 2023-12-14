import { FlatList, StyleSheet, Text, View } from 'react-native'
import React, { useEffect, useState } from 'react'
import { FeedRepository } from '../data/Database'
import { TouchableHighlight, TouchableOpacity } from 'react-native'

type Props = {
    navigation: any
}

type Feed = {
    titulo: string,
    url: string
}

const Practica31ListarFeeds = ({navigation}: Props) => {
    const [feeds, setFeeds] = useState<Array<Feed>>([]);

    useEffect(() => {
        async function getFeeds(){
            
            let a = await FeedRepository.find();

            setFeeds(a);
            
        }

        getFeeds();
    }, [])

    return (
        <View>
            <TouchableOpacity onPress={() => navigation.navigate("Practica31Crear")}>
                <Text>Crear Feed</Text>
            </TouchableOpacity>
            <FlatList 
                data={feeds}
                renderItem={({item}) => (
                    <TouchableHighlight onPress={() => navigation.navigate("Practica31Unica",{url: item.url})}>
                        <Text>{item.titulo}</Text>
                    </TouchableHighlight>
                )}
            />
        </View>
    )
}

export default Practica31ListarFeeds

const styles = StyleSheet.create({})