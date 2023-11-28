import { Button, StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'

type Props = {
    color?: string,
    nombre: string,
    estilo: string
}

const Caja = (props: Props) => {
    const [flex, setFlex] = useState(0);
    const color = props.color?? "green";

    return (
        <View style={{
            ...styles.cajaA,
            backgroundColor: color,
            flex: flex
            }}
        >
            <Button title="Flex + 1" onPress={() => setFlex(flex + 1)}/>
            <Button title="Flex - 1" onPress={() => setFlex(flex - 1)}/>
            <Text>{flex}</Text>
        </View>
    )
}

export default Caja

const styles = StyleSheet.create({
    
    cajaA: {
        margin: 10,
        width: 100,
        height: 100,
        flex: 0,
        alignSelf: 'flex-start'
    },
    cajaB: {
        margin: 10,
        width: 100,
        height: 100,
        flex: 0,
        alignSelf: 'flex-start'
    },
    cajaC: {
        margin: 10,
        width: 100,
        height: 100,
        flex: 0,
        alignSelf: 'flex-start'
    }
})