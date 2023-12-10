import { Alert, StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'


const usePractica13 = () => {
    
    const [colorPreferido, setColorPreferido] = useState("green")
    function nuevoColor(){
        let red = Math.trunc(Math.random()*255);
        let blue = Math.trunc(Math.random()*255);
        let green = Math.trunc(Math.random()*255);
        let color= `rgb(${red},${green},${blue})`;
        return color;

    }
    
    function mostrarPrompt() {
        Alert.alert("Cambio de color", "Si acepta cambiará el color a rojo", [
            {
                text: "Cancel",
                onPress: () => console.log("No se cambia el color"),
                //style: "cancel"
            },
            {text: "OK", onPress: () => setColorPreferido(nuevoColor())}
        ]);
    }

    return {
        colorPreferido,
        mostrarPrompt
    };
}

export default usePractica13