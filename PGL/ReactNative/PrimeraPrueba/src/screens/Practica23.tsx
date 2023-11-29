import { Button, StyleSheet, Text, TouchableOpacity, View } from 'react-native'
import React, { useState } from 'react'
import UsePractica23 from '../hooks/UsePractica23'
import Icon from 'react-native-vector-icons/Ionicons'
import ModificarTarea from './ModificarTarea'
import { useNavigation } from '@react-navigation/native'
import { useAppContext } from '../context/AppContextProvider'

type Props = {
    navigation: any
}

type Tarea = {
    desc: string,
    terminada: boolean
}

const Practica23 = ({navigation}: Props) => {
    let {tareasContext} = useAppContext();
    let {createTarea, cambiarValor, modificarTarea, deleteTarea} = UsePractica23();

    return (
        <View style={{flex: 1}}>
            <View style={{flex: 1}}>
                {
                    tareasContext.map((value,index) => {
                        return <View style={{flexDirection: 'row', justifyContent: 'space-evenly'}}>
                            <TouchableOpacity onPress={() => cambiarValor(index)}>
                                <Icon name={(value.terminada == true)?'chevron-down-circle-outline':'close-circle-outline'} size={30}/>
                            </TouchableOpacity>
                            <Text style={{textDecorationLine: value.terminada ? 'line-through' : 'none'}}>
                                {value.desc}
                            </Text>
                            <TouchableOpacity onPress={() => {navigation.navigate("ModificarTarea", {id: index})}}>
                                <Icon name="hammer-outline" size={30}/>
                            </TouchableOpacity>
                            <TouchableOpacity onPress={() => deleteTarea(index)}>
                                <Icon name="trash-outline" size={30}/>
                            </TouchableOpacity>
                        </View>
                    })
                }
            </View>
            <View style={{}}>
                <Button title='+' onPress={createTarea}/>
            </View>
        </View>
    )
}

export default Practica23

const styles = StyleSheet.create({})