import { Alert, StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'

const usePractica12 = () => {
    const [colorPreferido, setColorPreferido] = useState("green");

    function nuevoColor(){
        let red = Math.trunc(Math.random()*255);
        let blue = Math.trunc(Math.random()*255);
        let green = Math.trunc(Math.random()*255);
        const rbg = `rgb(${red},${blue},${green})`;

        return rbg;
    }

    function mostrarAlerta(){

        Alert.alert('Cambio de color',"Siacepta Cambiara el color a rojo", [
            {
                text: 'Cancel',
                onPress: () => console.log('No se cambia el color'),

            },
            {
                text: 'OK',
                onPress: () => setColorPreferido(nuevoColor)
            },
        ]);

    }

    return {
        mostrarAlerta,
        colorPreferido
    }
}

export default usePractica12;