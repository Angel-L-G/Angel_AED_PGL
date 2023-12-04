import { StyleSheet, Text, View, FlatList } from 'react-native';
import React, { useEffect, useState } from 'react'
import axios from 'axios';
import AsyncStorage from '@react-native-async-storage/async-storage';
import * as rssParser from 'react-native-rss-parser';
import { TouchableHighlight } from 'react-native-gesture-handler';

type Props = {
    navigation: any
}

const Practica31Listar = ({navigation}: Props) => {
    const [noticias, setNoticias] = useState<rssParser.Feed>();
    const [titulos, setTitulos] = useState<Array<String>>([] as Array<String>);

    useEffect(() => {
        async function getCache(uri:string){
            try{
                const response = await axios.get(uri);
                const data = response.data ;
                const responseData = await rssParser.parse(data);

                AsyncStorage.setItem(uri,JSON.stringify(data))
                
                setNoticias(responseData);
            }catch( error){
                const dat = await AsyncStorage.getItem(uri);
                if( dat){
                    const data = JSON.parse(dat);
                }
            }
        }
    
        getCache("https://www.xataka.com/feedburner.xml");
    }, [])
    
    
    return (
        <View>
            <FlatList 
                data={noticias?.items}
                renderItem={({item}) => (
                    <TouchableHighlight onPress={() => navigation.navigate("Practica31Unica",{desc: item.description})}>
                        {item.title}
                    </TouchableHighlight>
                )}
            />
        </View>
    )
}

export default Practica31Listar

const styles = StyleSheet.create({})