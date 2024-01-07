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

    const almacenImagenes: AlmacenImg[] = [
        {
        "nombre": "Hormiga-negra",
        "ubicacion": "require('../img/Hormiga-negra.jpg')"
        },
        {
        "nombre": "Cotadora-de-hojas",
        "ubicacion": "require('../img/Cotadora-de-hojas.jpg')"
        },
        {
        "nombre": "hormiga-roja",
        "ubicacion": "require('../img/hormiga-roja.jpeg')"
        }
    ];

    function getRequire(nombre: string){
        const obtenido = almacenImagenes.find( imagen => imagen.nombre == nombre);
        if( obtenido){
            return obtenido.ubicacion;
        }else{
            return "";
        }
    }

    return (
        <View style={styles.nestViewContainer}>
            <Image
                style={styles.nestImage}
                source={getRequire(nest.img)}
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