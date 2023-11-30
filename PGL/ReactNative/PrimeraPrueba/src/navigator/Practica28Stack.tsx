import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import Practica28Listar from '../screens/Practica28Listar';
import PokemonCard from '../components/PokemonCard';

type Props = {}

export type RootStackParamList = {
	Practica28List: undefined,
	Practica28Card: {uri: string},
    Practica28Filter: undefined,

}

const Stack = createNativeStackNavigator<RootStackParamList>();

const Practica28Stack = (props: Props) => {
    return (
        <Stack.Navigator>
			<Stack.Screen name="Practica28List" component={Practica28Listar} options={{headerStyle:{backgroundColor:"#608CEB"}, headerTitleAlign:"center", headerTintColor:"white"}} />
            <Stack.Screen name="Practica28Card" component={PokemonCard} options={{headerStyle:{backgroundColor:"#608CEB"}, headerTitleAlign:"center", headerTintColor:"white"}} />
			{/*<Stack.Screen name="Practica28Filter" component={ModificarTarea} options={{headerStyle:{backgroundColor:"#608CEB"}, headerTitleAlign:"center", headerTintColor:"white"}} />
            */} 
        </Stack.Navigator>
    )
}

export default Practica28Stack

const styles = StyleSheet.create({})