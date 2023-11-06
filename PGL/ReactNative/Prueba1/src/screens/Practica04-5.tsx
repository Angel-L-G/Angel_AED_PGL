import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import Caja from '../components/Caja'


type Props = {}

const Practica04 = (props: Props) => {
    return (
        <View style={styles.principal}>
            <Text>
                Practica 4
            </Text>
            <View style={styles.secundary}>
                <Caja color="red" />
                <Caja color="green" />
                <Caja />
            </View>
        </View>
    )
}

export default Practica04

const styles = StyleSheet.create({
    principal: {
        flex: 1,
        margin: 5,
        padding: 10,
        backgroundColor: "lightblue"
    },

    secundary: {
        justifyContent: "center",
        flex: 1,
        borderColor: "black",
        borderWidth: 1,
    }
})