import React, { useState } from 'react'
import { Button, StyleSheet, Text, View } from 'react-native';

type Props = {}

const InicioScreen = (props: Props) => {
    const [contador, setConCador] = useState(0);

    return (
        <View style={styles.contador}>
            <Text>Ejercicio básico. Contador: {contador}</Text>
            <Button title='Pulsame' onPress={() => setConCador(contador + 1)} />
        </View>
    )
}

const styles = StyleSheet.create({
    contador: {
        flex: 1,
        borderWidth: 3,
        borderColor: "black", 
        backgroundColor: "lightgray", 
        margin: 1
    },
});

export default InicioScreen