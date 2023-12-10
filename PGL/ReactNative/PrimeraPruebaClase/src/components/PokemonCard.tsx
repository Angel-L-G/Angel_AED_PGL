import { Image, StyleSheet, Text, TouchableOpacity, View } from 'react-native'
import React from 'react'
import UsePractica28Card from '../hooks/UsePractica28Card'
import { NativeStackScreenProps } from '@react-navigation/native-stack'

type Pokemon = {
    img: string,
    nombre: string,
    peso: number,
    tipo: Array<any>,
    img1: string,
    img2: string,
    img3: string
}

type RootStackParamList = {
	Practica28List: undefined,
	PokemonCard: {uri: string},
    Practica28Filter: undefined,

}

/*type Props = {
    uri: string
}*/

type Props = NativeStackScreenProps<RootStackParamList, "PokemonCard">

const PokemonCard = ({route}: Props) => {
    let uri = route.params.uri;
    let {cardData} = UsePractica28Card({uri: uri});

    return (
        <View style={styles.principal}>
            <Image
                style={styles.imgPrincipal}
                source={{
                    uri: cardData.img,
                }}
            />
            <Text style={styles.texto}>{cardData.nombre}</Text>
            <Text style={styles.texto}>{cardData.peso}</Text>
            <Text style={styles.texto}>{cardData.tipo}</Text>
            <View style={{flexDirection: 'row'}}>
                <Image
                    style={styles.imgSecundary}
                    source={{
                        uri: cardData.img1,
                    }}
                />
                <Image
                    style={styles.imgSecundary}
                    source={{
                        uri: cardData.img2,
                    }}
                />
                <Image
                    style={styles.imgSecundary}
                    source={{
                        uri: cardData.img3,
                    }}
                />
            </View>
            
        </View>
    )
}

export default PokemonCard

const styles = StyleSheet.create({
    texto:{
        margin: 15,
        color: "indigo",
        fontWeight: "bold",
    },

    principal: {
        backgroundColor: "darkgrey", 
        alignItems: 'center',
        margin: 30
    },

    imgPrincipal: {
        height: 250, 
        width: 250
    },

    imgSecundary: {
        height: 100, 
        width: 100
    }

})