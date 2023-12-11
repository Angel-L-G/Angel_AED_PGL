import { View, Text, TouchableOpacity, Image, TextInput } from 'react-native'
import React from 'react'
import styles from '../themes/styles'

type Props = {
    navigation: any
}

const Register = ({navigation}: Props) => {
    return (
        <View style={styles.container}>
            <Image
                style={styles.BackgorundImage}
                source={require('../img/sesion.jpg')}
            />

            <View style={styles.formContainer}>
                <View style={styles.formTitle}>
                    <Text style={{ fontSize: 20, fontWeight: 'bold' }}>Registrate</Text>
                </View>

                <Text></Text>

                <View style={styles.innerFormContainer}>
                    <Text style={styles.formText}>Nick</Text>
                    <TextInput placeholder='nick' />
                </View>

                <Text></Text>

                <View style={styles.innerFormContainer}>
                    <Text style={styles.formText}>Email</Text>
                    <TextInput placeholder='email@gmail.com' />
                </View>

                <Text></Text>


                <View style={styles.innerFormContainer}>
                    <Text style={styles.formText}>Password</Text>
                    <TextInput placeholder='********' />
                </View>

                <Text></Text>

                <View style={{ alignItems: 'center', justifyContent: 'center' }}>
                    <TouchableOpacity onPress={() => navigation.navigate("Main")} style={styles.button}>
                        <Text>Register</Text>
                    </TouchableOpacity>

                    <Text></Text>

                    <TouchableOpacity onPress={() => navigation.navigate("Login")}>
                        <Text style={styles.enlaceText}>Log In</Text>
                    </TouchableOpacity>
                </View>
            </View>
        </View>
    )
}

export default Register