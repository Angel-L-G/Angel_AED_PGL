import { StyleSheet, Text, View } from 'react-native'
import React from 'react'
import { createDrawerNavigator } from '@react-navigation/drawer';
import P26StackGatos from '../navigator/P26StackGatos';
import P26StackPerros from '../navigator/P26StackPerros';

type Props = {}

const Drawer = createDrawerNavigator();

const Practica26 = (props: Props) => {
    return (
        <Drawer.Navigator>
            <Drawer.Screen name="Perros" component={P26StackGatos} />
            <Drawer.Screen name="Gatos" component={P26StackPerros} />
        </Drawer.Navigator>
    )
}

export default Practica26

const styles = StyleSheet.create({})