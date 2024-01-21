import { View, Text, TouchableOpacity, FlatList, TextInput } from 'react-native'
import React, { useEffect, useState } from 'react'
import styles from '../themes/styles';
import UseAlumnos from '../hooks/UseAlumnos';
import { Alumno } from '../components/types';

type Props = {
    navigation: any
}

const ListarAlumnos = ({navigation}: Props) => {
    const {alumnos,deleteAlumno,alumnosFiltrados,setAlumnosFiltrados} = UseAlumnos();
    const [filtro, setFiltro] = useState("");
    
    function handleEdit(dni:string) {
        navigation.navigate("Actualizar", dni);
    }

    function handleDelete(dni:string ) {
        deleteAlumno(dni);
    }

    const handleAlumnoPress = (alumno: Alumno) => {
        navigation.navigate('Alumno', { alumno });
    };

    const handleFilter = (texto) => {
        setFiltro(texto);
        setAlumnosFiltrados(
            alumnos.filter((alumno) =>
                alumno.nombre.toLowerCase().includes(texto.toLowerCase())
            )
        );
    };

    return (
        <View style={styles.container}>
            <TextInput
                style={styles.input}
                placeholder="Filtrar por nombre"
                value={filtro}
                onChangeText={handleFilter}
            />
            <FlatList
                data={alumnosFiltrados}
                keyExtractor={(item) => item.dni}
                renderItem={({ item }) => (
                    <TouchableOpacity onPress={() => handleAlumnoPress(item)}>
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
                    </TouchableOpacity>
                )}
            />
        </View>
    );
};

export default ListarAlumnos