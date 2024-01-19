import { View, Text } from 'react-native'
import React from 'react'
import { createDrawerNavigator } from '@react-navigation/drawer';
import ListarAlumnos from '../screens/ListarAlumnos';
import CrearAlumno from '../screens/CrearAlumno';
import ValidarUsuarios from '../screens/ValidarUsuarios';
import TabNav from './TabNav';

type Props = {}

const Drawer = createDrawerNavigator();

const DrawerNav = (props: Props) => {
    return (
        <Drawer.Navigator>
            <Drawer.Screen name="Alumnos" component={TabNav} />
            
            <Drawer.Screen name="Validar Usuarios" component={ValidarUsuarios} />
        </Drawer.Navigator>
    )
}

export default DrawerNav