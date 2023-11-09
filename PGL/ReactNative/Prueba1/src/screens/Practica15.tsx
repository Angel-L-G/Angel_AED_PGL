import { StyleSheet, Text, View, TextInput, Switch } from 'react-native';
import React, { useState } from 'react'
import SwitchLabel from '../components/SwitchLabel';
import useAnexo from '../hooks/useAnexo';
import Icon from 'react-native-vector-icons/Ionicons'


type Props = {}
type FormData = {
    jubilado: boolean,
    casado: boolean,
    edad: number,
    nombre: string
}

const Practica15 = (props: Props) => {
    const {formData, setFormData, fillFormData, jubilado, setCasado, setJubilado, casado} = useAnexo();

    return (
        <View>

            <SwitchLabel nombre={"jubilado"} setData={setJubilado} />
            <SwitchLabel nombre={"casado"} setData={setCasado} />

            <TextInput placeholder='nombre' onChangeText={(texto)=>fillFormData(texto,"nombre")}/>
            <TextInput placeholder='edad' onChangeText={(texto)=>fillFormData(texto,"edad")}/>

            <Text>{JSON.stringify(formData)}</Text>

            <Text>
                Jubilado: {formData.jubilado} 
                -casado: {formData.casado} 
                -edad: {formData.edad} 
                -nombre: {formData.nombre} 
            </Text>

            <Icon name='car-outline' style={{width: 500, height: 500}}></Icon>
        </View>
    )
}

export default Practica15

const styles = StyleSheet.create({})