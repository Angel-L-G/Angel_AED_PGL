import { StyleSheet, Switch, Text, TextInput, View } from 'react-native'
import React, { useState } from 'react'
import usePractica15 from '../hooks/usePractica15'
import SwitchLabel from '../components/SwitchLabel'
import Icon from 'react-native-vector-icons/Ionicons';

type Props = {}

const Practica15 = (props: Props) => {
    const { jubilado, casado, setJubilado, setCasado, formData, fillFormData } = usePractica15();

    return (
        <View>
            <SwitchLabel nombre={"Jubilado"} setData={setJubilado} />
            <SwitchLabel nombre={"Casado"} setData={setCasado} />


            <TextInput placeholder='nombre' onChangeText={(texto) => fillFormData(texto, "nombre")} />
            <TextInput placeholder='edad' onChangeText={(texto) => fillFormData(parseInt(texto), "edad")} />
            <Text>
                {JSON.stringify(formData)}
            </Text>
        </View>
    )
}

export default Practica15

const styles = StyleSheet.create({})