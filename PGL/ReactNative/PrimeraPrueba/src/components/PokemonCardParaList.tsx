import { View, Text, StyleSheet, Image } from 'react-native'
import React from 'react'
import UsePractica28Card from '../hooks/UsePractica28Card';

type Props = {
    uri: string

}

const PokemonCardParaList = (props: Props) => {
    let {cardData} = UsePractica28Card({uri: props.uri});

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

export default PokemonCardParaList

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