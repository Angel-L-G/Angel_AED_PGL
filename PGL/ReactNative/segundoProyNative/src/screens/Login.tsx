import { View, Text, Image, TouchableHighlight, TouchableOpacity,TextInput } from 'react-native';
import React from 'react'
import styles from '../themes/styles'

type Props = {
    navigation: any
}

const Login = ({navigation}: Props) => {


    return (
        <View style={styles.container}>
            <Image
                style={styles.BackgorundImage}
                source={require('../img/sesion.jpg')}
            />

            <View style={styles.formContainer}>
                <View style={styles.formTitle}>
                    <Text style={{fontSize: 20,fontWeight: 'bold'}}>Iniciar Sesión</Text>
                </View>

                <Text></Text>

                <View style={styles.innerFormContainer}>
                    <Text style={styles.formText}>Nick</Text>
                    <TextInput placeholder='nick'/>
                </View>

                <Text></Text>
                
                <View style={styles.innerFormContainer}>
                    <Text style={styles.formText}>Password</Text>
                    <TextInput placeholder='********'/>
                </View>

                <Text></Text>
                
                <View style={{alignItems: 'center', justifyContent: 'center'}}>
                    <TouchableOpacity onPress={() => navigation.navigate("Main")} style={styles.button}>
                        <Text>Log In</Text>
                    </TouchableOpacity>

                    <Text></Text>

                    <TouchableOpacity onPress={() => navigation.navigate("Register")}>
                        <Text style={styles.enlaceText}>Register</Text>
                    </TouchableOpacity>
                </View>
            </View>
        </View>
    )
}

export default Login