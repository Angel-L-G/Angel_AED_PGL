import { Alert, StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'
import prompt from 'react-native-prompt-android';

const usePractica13 = () => {
    const [colorPreferido, setColorPreferido] = useState("green");

    function nuevoColor(){
        let red = Math.trunc(Math.random()*255);
        let blue = Math.trunc(Math.random()*255);
        let green = Math.trunc(Math.random()*255);
        const rbg = `rgb(${red},${blue},${green})`;

        return rbg;
    }

    function mostrarPrompt(){
        return (
            prompt(
                'Aqui Titulo',
                "Aqui description del prompr",
                [
                    {
                        text: 'Cancel', onPress: () => console.log("Se Ha Cancelado")
                    },
                    {
                        text: 'Ok', onPress: password => console.log('Ok nueva password: ' + password)
                    },
                ],
                {
                    type: 'secure-text',
                    cancelable: false,
                    placeholder: 'password'
                }
            )
        );
    }

    return {
        mostrarPrompt,
        colorPreferido
    }
}

export default usePractica13;