import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import stylesp08 from '../themes/P8Styles'

type Props = {
    num: number,
    color: string
}

const Circulo = (props: Props) => {
    return (
        <View style={stylesp08.caja}>
            <Text>C{props.num+1}</Text>
        </View>
    )
}

export default Circulo