import { Button, StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'
import Circulo from '../components/Circulo';

type Props = {}


type Direccion = "row" | "column" | "row-reverse" | "column-reverse";

const Practica8 = (props: Props) => {
    const [cantidadCirculos, setCantidadCirculos] = useState<Array<Number>>([]);
    const [direccion, setDireccion] = useState <Direccion>("row");

    function aniadirCirculo() {
        setCantidadCirculos([...cantidadCirculos, 1]);
    }

    return (
        <View>
            <Button title='Agregar Circulo' onPress={aniadirCirculo} />
            <Button title='Wrap. Pulse para cambiar' onPress={() => setDireccion("column")} />
            <Button title='Row. Pulse para cambiar' onPress={() => setDireccion("row")} />
            <View style={{
                ...styles.main,
                flexDirection: direccion
            }}>
                {
                    cantidadCirculos.map((value, index) => {
                        return <Circulo index={index} />
                    })
                }
            </View>

        </View>
    )
}

export default Practica8

const styles = StyleSheet.create({
    main: {
        backgroundColor: "grey",
        flexWrap: 'wrap',
        flexDirection: "column",
        margin: 10,
        marginBottom: 200,
        gap: 5
    }
})