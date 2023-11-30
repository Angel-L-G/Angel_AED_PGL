import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import Practica28Listar from '../screens/Practica28Listar';
import PokemonCard from '../components/PokemonCard';
import Practica28Filtrar from '../screens/Practica28Filtrar';

type Props = {}

export type RootStackParamList = {
	Practica28List: undefined,
	PokemonCard: {uri: string},
    Practica28Filter: undefined,
}

const Stack = createNativeStackNavigator<RootStackParamList>();

const Practica28Stack = (props: Props) => {
    return (
        <Stack.Navigator>
			<Stack.Screen name="Practica28List" component={Practica28Listar} options={{headerStyle:{backgroundColor:"#608CEB"}, headerTitleAlign:"center", headerTintColor:"white"}} />
            <Stack.Screen name="PokemonCard" component={PokemonCard} />
			<Stack.Screen name="Practica28Filter" component={Practica28Filtrar} />
        </Stack.Navigator>
    )
}

export default Practica28Stack

const styles = StyleSheet.create({})