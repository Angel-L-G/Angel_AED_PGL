import { View, Text } from 'react-native'
import React from 'react'
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import Practica31Listar from '../screens/Practica31Listar';
import Practica31Unica from '../screens/Practica31Unica';

type Props = {}

export type RootStackParamList = {
    Practica31Listar: undefined,
    Practica31Unica: { desc: string },
}

const Stack = createNativeStackNavigator<RootStackParamList>();

const P31Stack = (props: Props) => {
    return (
        <Stack.Navigator>
            <Stack.Screen name="Practica31Listar" component={Practica31Listar} />
            <Stack.Screen name="Practica31Unica" component={Practica31Unica} />
        </Stack.Navigator>
    )
}

export default P31Stack