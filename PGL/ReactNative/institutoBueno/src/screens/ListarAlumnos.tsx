import { View, Text, TouchableOpacity } from 'react-native'
import React from 'react'
import styles from '../themes/styles';
import { FlatList } from 'react-native-gesture-handler';

type Props = {}

const data = [
    { id: '1', name: 'Usuario 1' },
    { id: '2', name: 'Usuario 2' },
    { id: '3', name: 'Usuario 3' },
    { id: '4', name: 'Usuario 4' },
    // Agrega más usuarios según sea necesario
];

const ListarAlumnos = (props: Props) => {
    function handleEdit(userId:any ) {
        console.log(`Editar usuario con ID: ${userId}`);
    }

    function handleDelete(userId:any ) {
        console.log(`Editar usuario con ID: ${userId}`);
    }

    return (
        <View style={styles.container}>
            <FlatList
                data={data}
                keyExtractor={(item) => item.id}
                renderItem={({ item }) => (
                    <View style={styles.userContainer}>
                        <Text style={styles.userName}>{item.name}</Text>
                        <View style={styles.buttonContainer}>
                            <TouchableOpacity onPress={() => handleEdit(item.id)} style={styles.editButton}>
                                <Text style={styles.buttonText}>Editar</Text>
                            </TouchableOpacity>
                            <TouchableOpacity onPress={() => handleDelete(item.id)} style={styles.deleteButton}>
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