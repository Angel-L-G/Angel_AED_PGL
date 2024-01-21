import { View, Text, TextInput, TouchableOpacity } from 'react-native'
import React, { useState } from 'react'
import styles from '../themes/styles'
import { Alumno } from '../components/types'
import UseAlumnos from '../hooks/UseAlumnos'

type Props = {
    route: any
}

const UpdateAlumno = ({route}: Props) => {
    const {updateAlumno} = UseAlumnos();
    const [alumno, setAlumno] = useState<Alumno>({
        dni: '',
        nombre: '',
        apellidos: '',
        foto: '',
        fechanacimiento: 0,
    });
    
    const handleInputChange = (field: keyof Alumno, value: string) => {
        setAlumno((prevAlumno) => ({
            ...prevAlumno,
            [field]: value,
        }));
    };
    
    const handleSubmit = () => {
        updateAlumno(alumno);
    };

    return (
        <View style={styles.container}>
            <Text style={styles.label}>DNI:</Text>
            <TextInput
                value={alumno.dni}
                onChangeText={(value) => handleInputChange('dni', value)}
                style={styles.input}
            />

            <Text style={styles.label}>Nombre:</Text>
            <TextInput
                value={alumno.nombre}
                onChangeText={(value) => handleInputChange('nombre', value)}
                style={styles.input}
            />

            <Text style={styles.label}>Apellidos:</Text>
            <TextInput
                value={alumno.apellidos}
                onChangeText={(value) => handleInputChange('apellidos', value)}
                style={styles.input}
            />

            <Text style={styles.label}>Foto:</Text>
            <TextInput
                value={alumno.foto}
                onChangeText={(value) => handleInputChange('foto', value)}
                style={styles.input}
            />

            <Text style={styles.label}>Fecha de Nacimiento:</Text>
            <TextInput
                value={alumno.fechanacimiento.toString()}
                onChangeText={(value) => handleInputChange('fechanacimiento', value)}
                style={styles.input}
            />

            <TouchableOpacity onPress={handleSubmit} style={styles.editButton}>
                <Text style={styles.buttonText}>Actualizar</Text>
            </TouchableOpacity>
        </View>
    )
}

export default UpdateAlumno