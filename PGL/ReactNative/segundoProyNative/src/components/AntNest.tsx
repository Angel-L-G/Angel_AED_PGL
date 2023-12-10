import { View, Text, Image, TouchableHighlight } from 'react-native'
import React, { useEffect } from 'react'
import styles from '../themes/styles'

type Props = {
    showModal: Function,
    nest: Hormiguero,
}

type Hormiguero = {
    id: number,
    img: string,
    antname: string,
    biome: string,
}

const AntNest = (props: Props) => {
    let imagen = props.nest.img;

    return (
        <View style={styles.nestViewContainer}>
            <Image
                style={styles.nestImage}
                source={require("../img/Cotadora-de-hojas.jpg")}
            />

            <View style={styles.netsButtons}>
                <TouchableHighlight style={styles.button} onPress={() => props.showModal(props.nest.id)}>
                    <Text>Detalles</Text>
                </TouchableHighlight>

                <TouchableHighlight style={styles.button}>
                    <Text>Entrar</Text>
                </TouchableHighlight>
            </View>
        </View>
    )
}

export default AntNest