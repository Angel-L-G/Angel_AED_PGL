import { View, Text, TouchableOpacity, FlatList } from 'react-native'
import React from 'react'
import styles from '../themes/styles';
import UseAlumnos from '../hooks/UseAlumnos';

type Props = {
    navigation: any
}

const ListarAlumnos = ({navigation}: Props) => {
    const {alumnos} = UseAlumnos(navigation);

    function handleEdit(userId:any) {
        navigation.navigate("Actualizar");
    }

    function handleDelete(userId:any ) {
        console.log(`Borrar usuario con ID: ${userId}`);
    }

    return (
        <View style={styles.container}>
            <FlatList
                data={alumnos}
                keyExtractor={(item) => item.dni}
                renderItem={({ item }) => (
                    <View style={styles.userContainer}>
                        <Text style={styles.userName}>{item.nombre}</Text>
                        <View style={styles.buttonContainer}>
                            <TouchableOpacity onPress={() => handleEdit(item.dni)} style={styles.editButton}>
                                <Text style={styles.buttonText}>Editar</Text>
                            </TouchableOpacity>
                            <TouchableOpacity onPress={() => handleDelete(item.dni)} style={styles.deleteButton}>
                                <Text style={styles.buttonText}>Borrar</Text>
                            </TouchableOpacity>
                        </View>
                    </View>
                )}
            />
        </View>
    );
};

export default ListarAlumnos