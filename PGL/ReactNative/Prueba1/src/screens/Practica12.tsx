import { Alert, Button, StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'
import usePractica12 from '../hooks/usePractica12'

type Props = {}

const Practica12 = (props: Props) => {
    const {mostrarAlerta, colorPreferido} = usePractica12();

    return (
        <View style={{backgroundColor: colorPreferido, flex: 1}}>
            <Button title="Cambiar a rojo" onPress={mostrarAlerta}/>
            <Text>{colorPreferido}</Text>
        </View>
    )
}

export default Practica12;