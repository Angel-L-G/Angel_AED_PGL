import { View, Text, Image } from 'react-native'
import React from 'react'
import styles from '../themes/styles'
import { Button } from 'react-native-elements'

type Props = {
    hormiguero: Hormiguero,
    closeModal: Function,
}

type Hormiguero = {
    id: number,
    img: string,
    antname: string,
    biome: string,
}

const NestDetails = (props: Props) => {
    return (
        <View style={styles.modalContainer}>
            <Text style={styles.title}>Nombre Hormiguero</Text>

            <Image
                style={styles.nestImage}
                source={require('../img/Hormiga-negra.jpg')}
            />

            <Text style={styles.subTitle}>Informacion:</Text>
            <Text></Text>

            <View>
                <Text></Text>
                <Text style={styles.header3}>Biome: </Text>
                <Text style={styles.textBody}>{props.hormiguero.biome}</Text>
                <Text></Text>
                <Text style={styles.header3}>Tipo De Hormiga: </Text>
                <Text style={styles.textBody}>{props.hormiguero.antname}</Text>
            </View>

            <Text></Text>
            <Text style={styles.header3}>Grafico 1:</Text>
            <Text></Text>
            <Text style={styles.header3}>Grafico 2:</Text>
            <Text></Text>

            <Button title="Cerrar" onPress={() => props.closeModal(false)} />
        </View>
    )
}

export default NestDetails