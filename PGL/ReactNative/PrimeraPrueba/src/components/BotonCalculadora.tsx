import { StyleSheet, Text, TouchableHighlight, View } from 'react-native'
import React from 'react'
import usePractica10 from '../hooks/usePractica10'

type Props = {
    texto: string,
    fondo: string,
    letra: string,
    largo?: number
}

const BotonCalculadora = (props: Props) => {
    const {arr, linea, setLinea} = usePractica10();
    let largo = props.largo?? 80;

    return (
        <View style={{ ...styles.boton, backgroundColor: props.fondo, width: largo }}>
            <Text style={{ color: props.letra, fontSize: 30 }}>{props.texto}</Text>
        </View>
    )
}

export default BotonCalculadora

const styles = StyleSheet.create({
    boton: {
        width: 80,
        height: 80,
        backgroundColor: "gray",
        borderRadius: 100,
        borderWidth: 2,
        justifyContent: "center",
        alignItems: 'center',
    }
})