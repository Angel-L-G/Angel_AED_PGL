import { View, Text, TextInput, Button, TouchableOpacity } from 'react-native'
import React, { useState } from 'react'
import styles from '../themes/styles'
import { Alumno } from '../components/types';
import UseAlumnos from '../hooks/UseAlumnos';

type Props = {
    navigation: any
}

const CrearAlumno = ({navigation}: Props) => {
    const {saveAlumno} = UseAlumnos();
    const [alumno, setAlumno] = useState<Alumno>({
        dni: '',
        nombre: '',
        apellidos: '',
        foto: '',
        fechanacimiento: 0,
    });
    
    const handleInputChange = (field: keyof Alumno, value: any) => {
        setAlumno((prevAlumno) => ({
            ...prevAlumno,
            [field]: value,
        }));
    };
    
    const handleSubmit = () => {
        saveAlumno(alumno.dni, alumno.nombre, alumno.apellidos, alumno.foto, alumno.fechanacimiento)
    };
    
    return (
        <View style={styles.container}>
            <Text style={styles.label}>DNI:</Text>
            <TextInput
                style={styles.input}
                value={alumno.dni}
                onChangeText={(value) => handleInputChange('dni', value)}
            />

            <Text style={styles.label}>Nombre:</Text>
            <TextInput
                style={styles.input}
                value={alumno.nombre}
                onChangeText={(value) => handleInputChange('nombre', value)}
            />

            <Text style={styles.label}>Apellidos:</Text>
            <TextInput
                style={styles.input}
                value={alumno.apellidos}
                onChangeText={(value) => handleInputChange('apellidos', value)}
            />

            <Text style={styles.label}>Foto:</Text>
            <TextInput
                style={styles.input}
                value={alumno.foto}
                onChangeText={(value) => handleInputChange('foto', value)}
            />

            <Text style={styles.label}>Fecha de Nacimiento:</Text>
            <TextInput
                style={styles.input}
                value={alumno.fechanacimiento.toString()}
                onChangeText={(value) => handleInputChange('fechanacimiento', value)}
            />

            <TouchableOpacity onPress={handleSubmit} style={styles.editButton}>
                <Text style={styles.buttonText}>Create</Text>
            </TouchableOpacity>
        </View>
    );
};

export default CrearAlumno