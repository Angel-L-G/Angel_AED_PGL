import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import Practica28Listar from './Practica28Listar';
import Practica28Stack from '../navigator/Practica28Stack';
import Practica28Filtrar from './Practica28Filtrar';

type Props = {}

const Tab = createBottomTabNavigator();

const Practica28 = (props: Props) => {
    return (
        <Tab.Navigator screenOptions={{headerShown: false}}>
            <Tab.Screen name="Practica28List" component={Practica28Stack} options={{headerStyle:{backgroundColor:"#608CEB"}, headerTitleAlign:"center", headerTintColor:"white"}}/>
            <Tab.Screen name="Practica28Filter" component={Practica28Filtrar} options={{headerStyle:{backgroundColor:"#608CEB"}, headerTitleAlign:"center", headerTintColor:"white"}}/>
        </Tab.Navigator>
    )
}

export default Practica28

const styles = StyleSheet.create({})