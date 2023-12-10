import React, { useState } from 'react'
import { Button, Text, View } from 'react-native'

type Props = {}

const Practica2 = (props: Props) => {
    const [contador, setConCador] = useState(0);

    return (
        <View style={{ flex: 1, borderWidth: 3, borderColor: "black", backgroundColor: "lightgray", margin: 1 }}>
            <Text>Ejercicio básico. Contador: {contador}</Text>
            <Button title='Pulsame' onPress={() => setConCador(contador + 1)} />
        </View>
    )
}

export default Practica2