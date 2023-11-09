import { StyleSheet, Text, View, TouchableHighlight } from 'react-native';
import React from 'react'
import usePractica10 from '../hooks/usePractica10';

type Props = {
    txt: string,
    color: string,
}

const BotonCalc = (props: Props) => {
    const {numActual, setNumActual} = usePractica10();

    return (
        <View style={{}}>
            <TouchableHighlight onPress={() => "a"} style={{...styles.boton, backgroundColor: props.color}}>
                <Text>{props.txt}</Text>
            </TouchableHighlight>
        </View>
    )
}

export default BotonCalc

const styles = StyleSheet.create({
    container: {
        flex: 1,
    },

    boton: {
        width: 80,
        height: 80,
        borderRadius: 50,
        textAlign: "center",
        gap: 5,
    },

    texto: {

    }
})