import { View, Text, FlatList, TouchableOpacity } from 'react-native'
import React from 'react'
import styles from '../themes/styles'
import UseUsuario from '../hooks/UseUsuario'

type Props = {}

const ValidarUsuarios = (props: Props) => {
    const {updateUsuario, usuarios} = UseUsuario();

    return (
        <FlatList
            data={usuarios}
            keyExtractor={(item) => item.nombre}
            renderItem={({ item }) => (
                <View style={styles.userContainer}>
                    <Text style={styles.userName}>{item.nombre}</Text>
                    <View style={styles.buttonContainer}>
                        <TouchableOpacity onPress={() => updateUsuario(item.nombre)} style={styles.editButton}>
                            <Text style={styles.buttonText}>Validar</Text>
                        </TouchableOpacity>
                    </View>
                </View>
            )}
        />
    )
}

export default ValidarUsuarios