import { StyleSheet, Text, View } from 'react-native'
import React from 'react'

type Props = {
    index: number
}

const Circulo = (props: Props) => {
    return (
        <View style={styles.circulo}>
            <Text>C{props.index + 1}</Text>
        </View>
    )
}

export default Circulo

const styles = StyleSheet.create({
    circulo: {
        width: 80,
        height: 80,
        backgroundColor: "lightblue",
        borderRadius: 100,
        borderWidth: 2,
        justifyContent: "center",
        alignItems: 'center'
    }
})