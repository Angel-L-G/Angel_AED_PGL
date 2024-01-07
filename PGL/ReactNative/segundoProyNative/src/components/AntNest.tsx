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
        "nombre": "Negra",
        "ubicacion": "require('../img/Hormiga-negra.jpg')"
        },
        {
        "nombre": "Cortadora de Hojas",
        "ubicacion": "require('../img/Cotadora-de-hojas.jpg')"
        },
        {
        "nombre": "Roja",
        "ubicacion": "require('../img/hormiga-roja.jpeg')"
        }
    ];

    function getRequire(nombre: string){
        const obtenido = almacenImagenes.find( imagen => imagen.nombre == nombre);
        if( obtenido){
            console.log(1);
            console.log(obtenido.ubicacion);
            return obtenido.ubicacion;
        }else{
            console.log(2);
            return "";
        }
    }

    return (
        <View style={styles.nestViewContainer}>
            {
                (nest.antname == "Negra")?
                    <Image
                        style={styles.nestImage}
                        source={require('../img/Hormiga-negra.jpg')}
                    />
                :(nest.antname == "Roja")?
                        <Image
                            style={styles.nestImage}
                            source={require('../img/hormiga-roja.jpeg')}
                        />
                    :<Image
                        style={styles.nestImage}
                        source={require('../img/Cotadora-de-hojas.jpg')}
                    />
            }
            

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