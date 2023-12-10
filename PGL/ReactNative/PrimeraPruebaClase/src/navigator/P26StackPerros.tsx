import { View, Text } from 'react-native'
import React from 'react'
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import AnimalList from '../components/AnimalList';

type Props = {}

export type RootStackParamList = {
	AnimalList: undefined,
}

const Stack = createNativeStackNavigator<RootStackParamList>();

const P26StackPerros = (props: Props) => {
    return (
        <Stack.Navigator>
            <Stack.Screen name="AnimalList" component={AnimalList} />
            {/*<Stack.Screen name="PokemonCard" component={PokemonCard} />
            */}        
        </Stack.Navigator>
    )
}

export default P26StackPerros