import { Button, StyleSheet, TextInput, View } from 'react-native'
import React from 'react'
import SwitchLabel from '../components/SwitchLabel';
import UsePractica23 from '../hooks/UsePractica23';
import { useAppContext } from '../context/AppContextProvider';

type Props = {}

const ModificarTarea = (props: Props) => {
    let {tareasContext} = useAppContext();
    let {cambiarValor, modificarTarea} = UsePractica23();

    function fillFormData() {
        
    }

    return (
        <View style={{flex: 1}}>
            <SwitchLabel nombre='Completada' setData={cambiarValor} />
            <View style={{flex: 1}}>
                <TextInput></TextInput>
            </View>
            <View style={{}}>
                <Button title='Crear Tarea' /*onPress={}*//>
            </View>
        </View>
    )
}

export default ModificarTarea

const styles = StyleSheet.create({})