import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import WebView from 'react-native-webview'
import { NativeStackScreenProps, createNativeStackNavigator } from '@react-navigation/native-stack'


export type RootStackParamList = {
    Practica31Listar: undefined,
    Practica31Unica: { desc: string },
}

type Props = NativeStackScreenProps<RootStackParamList, "Practica31Unica">;

const Practica31Unica = ({navigation, route}: Props) => {
    

    return (
        <WebView
            source={{
                html: route.params.desc
            }}
            style={{width: '100%', height: '100%'}}
        />
    )
}

export default Practica31Unica

const styles = StyleSheet.create({})