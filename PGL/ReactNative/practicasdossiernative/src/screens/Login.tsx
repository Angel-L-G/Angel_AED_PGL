import { StyleSheet, Text, TextInput, TouchableOpacity, View } from 'react-native'
import React, { useState } from 'react'
import styles from '../themes/styles';
import UseSesion from '../hooks/UseSesion';

type Props = {
  navigation: any
}

const Login = ({navigation}: Props) => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');

    const {login} = UseSesion(navigation);

    const handleLogin = () => {
        
        navigation.navigate("DrawerNav");
        //login(username, password);
    };

    return (
        <View style={styles.container}>
            <Text style={styles.title}>Iniciar Sesión</Text>
            <View style={styles.form}>
                <TextInput
                    style={styles.input}
                    placeholder="Nombre de Usuario"
                    value={username}
                    onChangeText={(text) => setUsername(text)}
                />

                <TextInput
                    style={styles.input}
                    placeholder="Contraseña"
                    secureTextEntry
                    value={password}
                    onChangeText={(text) => setPassword(text)}
                />
                
                <TouchableOpacity style={styles.button} onPress={handleLogin}>
                <Text>Iniciar Sesión</Text>
                </TouchableOpacity>

                <TouchableOpacity onPress={() => navigation.navigate("Register")}>
                <Text style={styles.link}>Register</Text>
                </TouchableOpacity>
            </View>
        </View>
    );
}

export default Login