import { View, Text, Image, TouchableOpacity } from 'react-native'
import React, { useEffect } from 'react'
import styles from '../themes/styles'
import { Alumno } from './types'
import EncryptedStorage from 'react-native-encrypted-storage'
import { useAppContext } from './AppContextProvider'
import { TouchableHighlight } from 'react-native-gesture-handler'

type Props = {
    navigation: any,
    route: any,
}

const AlumnoCard = ({route,navigation}: Props) => {
    const ruta = "http://192.168.56.1:8080/api/v2/files";
    const {token} = useAppContext();
    const {alumno} = route.params;
    let tk = "";

    useEffect(() => {
        async function getToken() {
            if(token == null){
                tk = await EncryptedStorage.getItem("token");
            }else {
                tk = token;
            }
        }
        
        getToken();
    }, [])
    
    return (
        <View style={styles.container}>
            <Image 
                source={{ 
                    uri: ruta+alumno.foto,
                    headers: { "Authorization": "Bearer " + tk },
                }} 
                style={styles.foto} 
            />
            <Text style={styles.texto}>DNI: {alumno.dni}</Text>
            <Text style={styles.texto}>Nombre: {alumno.nombre}</Text>
            <Text style={styles.texto}>Apellidos: {alumno.apellidos}</Text>
            <Text style={styles.texto}>
                Fecha de Nacimiento: {alumno.fechanacimiento}
            </Text>

            <TouchableOpacity onPress={() => navigation.navigate("DrawerNav")} style={styles.backButton}>
                <Text style={styles.buttonText}>Back</Text>
            </TouchableOpacity>
        </View>
    )
}

export default AlumnoCard