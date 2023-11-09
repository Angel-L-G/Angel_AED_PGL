import { Alert, Button, StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'
import usePractica13 from '../hooks/usePractica13';

type Props = {}

const Practica13 = (props: Props) => {
    const {mostrarPrompt, colorPreferido} = usePractica13();

    return (
        <View style={{backgroundColor: colorPreferido, flex: 1}}>
            <Button title="Cambiar a rojo" onPress={mostrarPrompt}/>
            <Text>{colorPreferido}</Text>
        </View>
    )
}

export default Practica13;