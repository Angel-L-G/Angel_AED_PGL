import { Alert, Button, StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'
import usePractica13 from '../hooks/usePractica13'

type Props = {}

const Practica13 = (props: Props) => {
    const {colorPreferido, mostrarPrompt} = usePractica13();



    return (
        <View style={{...styles.colorFondo, backgroundColor: colorPreferido}}>
            <Button title='Cambiar a rojo' onPress={() => mostrarPrompt()}/>
            <Text>{colorPreferido}</Text>
        </View>
    )
}

export default Practica13

const styles = StyleSheet.create({

    colorFondo: {
        backgroundColor: "blue",
        flex: 1
    }


})