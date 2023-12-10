import { Button, StyleSheet, TextInput, View } from 'react-native'
import React, { ChangeEvent } from 'react'
import SwitchLabel from '../components/SwitchLabel';
import UsePractica23 from '../hooks/UsePractica23';
import { useAppContext } from '../context/AppContextProvider';
import { NativeStackScreenProps } from '@react-navigation/native-stack';
import { RootStackParamList } from '../../App';

type Props = NativeStackScreenProps<RootStackParamList, 'ModificarTarea'>;

type Tarea = {
    desc: string,
    terminada: boolean
}

const ModificarTarea = ({navigation, route}: Props) => {
    let {tareasContext, setTareasContext} = useAppContext();
    let {cambiarValor, modificarTarea} = UsePractica23();
    let t = tareasContext[route.params.id];

    function fillFormData(txt: string) {
        let t = tareasContext[route.params.id];
        t.desc = txt;
    }

    function finished(){
        let trs = tareasContext;
        trs[route.params.id] = t;
        setTareasContext(trs);

        navigation.navigate("Practica23")
    }

    return (
        <View style={{flex: 1}}>
            <SwitchLabel nombre='Completada' setData={() => cambiarValor(route.params.id)} />
            <View style={{flex: 1}}>
                <TextInput placeholder='Informacion' onChangeText={(text) => fillFormData(text)}></TextInput>
            </View>
            <View style={{}}>
                <Button title='Crear Tarea' onPress={finished}/>
            </View>
        </View>
    )
}

export default ModificarTarea

const styles = StyleSheet.create({})