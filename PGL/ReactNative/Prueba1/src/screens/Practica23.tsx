import { View, Text, TouchableHighlight, TouchableOpacity } from 'react-native';
import React from 'react'

type Props = {}

const Practica23 = (props: Props) => {
    function newTarea() {
        
    }

    return (
        <View>
            <Text>Tareas</Text>
            <View>
                {/*Lista de tareas*/}
            </View>

            <TouchableOpacity onPress={newTarea}>+</TouchableOpacity>
        </View>
    )
}

export default Practica23