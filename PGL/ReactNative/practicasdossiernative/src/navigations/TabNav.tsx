import { View, Text } from 'react-native'
import React from 'react'
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs'
import CrearAlumno from '../screens/CrearAlumno';
import ListarAlumnos from '../screens/ListarAlumnos';
import UpdateAlumno from '../screens/UpdateAlumno';

type Props = {}

const Tab = createBottomTabNavigator();

const TabNav = (props: Props) => {
  return (
    <Tab.Navigator screenOptions={{headerShown: false}}>
        <Tab.Screen name="Listar" component={ListarAlumnos} />
        <Tab.Screen name="Crear" component={CrearAlumno} />
        <Tab.Screen name="Actualizar" component={UpdateAlumno} />
    </Tab.Navigator>
  )
}

export default TabNav