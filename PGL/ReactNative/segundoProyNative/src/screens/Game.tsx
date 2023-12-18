import { View, Text } from 'react-native'
import React from 'react'
import styles from '../themes/styles'

type Props = {}

const Game = (props: Props) => {
    return (
        <View style={styles.container}>
            <View style={styles.mainConatiner}>
                <View style={styles.gameTop}>
                    <Text>Casillas</Text>
                </View>
    
                <View style={styles.gameBotom}>
                    <Text>Acciones</Text>
                </View>
            </View>
        </View>
    )
}

export default Game