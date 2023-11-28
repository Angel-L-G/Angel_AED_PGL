import { Alert, Button, StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'
import usePractica12 from '../hooks/usePractica12'

type Props = {}

const Practica12 = (props: Props) => {
    const {colorPreferido, mostrarAlerta} = usePractica12();



    return (
        <View style={{...styles.colorFondo, backgroundColor: colorPreferido}}>
            <Button title='Cambiar a rojo' onPress={() => mostrarAlerta()}/>
            <Text>{colorPreferido}</Text>
        </View>
    )
}

export default Practica12

const styles = StyleSheet.create({

    colorFondo: {
        backgroundColor: "blue",
        flex: 1
    }


})