import { StyleSheet, Text, View, FlatList, TouchableHighlight, TouchableOpacity } from 'react-native';
import React, { useEffect, useState } from 'react'
import axios from 'axios';
import AsyncStorage from '@react-native-async-storage/async-storage';
import * as rssParser from 'react-native-rss-parser';
import { FeedItemRepository, FeedRepository } from '../data/Database';
import { NativeStackScreenProps } from '@react-navigation/native-stack';
import { RootStackParamList } from '../../App';

type Props = NativeStackScreenProps<RootStackParamList, "Practica31Listar">;

type Feed = {
    id: number,
    titulo: string,
    url: string
}

type FeedItem = {
    titulo: string,
    descripcion: string,
    visited: boolean,
    feed: Feed,
}

const Practica31Listar = ({navigation, route}: Props) => {
    const [noticias, setNoticias] = useState<Array<FeedItem>>();
    const feed: Feed  = route.params.feed;

    useEffect(() => {
        async function getNoticias() {
            let a = await FeedItemRepository.find({
                where:{
                    feed: {id: feed.id}
                }
            });

            setNoticias(a);
        }

        getNoticias();
    }, [])
    
    async function changeBoolean(item: FeedItem) {
        item.visited = true;

        FeedItemRepository.save(item);

        navigation.navigate("Practica31Unica",{desc: item.descripcion});
    }
    
    return (
        <View>
            <FlatList 
                data={noticias}
                renderItem={({item}) => (
                    (item.visited)
                    ?
                        <TouchableHighlight onPress={() => changeBoolean(item)}>
                            <Text style={{color: "blue"}}>{item.titulo}</Text>
                        </TouchableHighlight>
                    :
                        <TouchableHighlight onPress={() => changeBoolean(item)}>
                            <Text style={{color: "black"}}>{item.titulo}</Text>
                        </TouchableHighlight>
                )}
            />
        </View>
    )
}

export default Practica31Listar

const styles = StyleSheet.create({})