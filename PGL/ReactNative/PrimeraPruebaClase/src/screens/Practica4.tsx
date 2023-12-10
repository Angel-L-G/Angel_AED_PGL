import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import Caja from '../components/Caja'

type Props = {}

const Practica4 = (props: Props) => {
    return (
        <View style={styles.escenario}>
            <Text>Contenedor Principal</Text>
            <View style={styles.secundario}>
                <Caja estilo="" nombre="cajaA" color='red'/>
                <Caja estilo="" nombre="cajaB" color='yellow'/>
                <Caja estilo="" nombre="cajaC"/>
            </View>
        </View>
    )
}

export default Practica4

const styles = StyleSheet.create({
    escenario: {
        backgroundColor: "gray",
        justifyContent: "center",
        margin: 20,
        padding: 20,
        flex: 1
        
    },

    secundario: {
        flex: 1, borderBlockColor: "black", borderWidth: 1, justifyContent: "center", alignItems: "center"
    }
})