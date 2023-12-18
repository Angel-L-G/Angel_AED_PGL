import { View, Text, Image, TouchableHighlight } from 'react-native'
import React, { useEffect } from 'react'
import styles from '../themes/styles'

type Props = {
    showModal: Function,
    navigation: any,
    nest: Hormiguero,
}

type Hormiguero = {
    id: number,
    img: string,
    antname: string,
    biome: string,
}

const AntNest = ({navigation, nest, showModal}: Props) => {

    return (
        <View style={styles.nestViewContainer}>
            <Image
                style={styles.nestImage}
                source={require("../img/Hormiga-negra.jpg")}
            />

            <View style={styles.netsButtons}>
                <TouchableHighlight style={styles.button} onPress={() => showModal(nest.id)}>
                    <Text>Detalles</Text>
                </TouchableHighlight>

                <TouchableHighlight style={styles.button} onPress={() => navigation.navigate("Game")}>
                    <Text>Entrar</Text>
                </TouchableHighlight>
            </View>
        </View>
    )
}

export default AntNest