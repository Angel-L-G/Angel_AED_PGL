import { View, Text } from 'react-native'
import React from 'react'
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import Login from '../screens/Login';
import Register from '../screens/Register';
import ListarAlumnos from '../screens/ListarAlumnos';
import DrawerNav from './DrawerNav';
import AppContextProvider, { AppContext } from '../components/AppContextProvider';

type RootStackParamList = {
    Login: undefined,
    Register: undefined,
    ListarAlumnos: undefined,
    DrawerNav: undefined,
};

type Props = {}
const Stack = createNativeStackNavigator<RootStackParamList>();

const MainNav = (props: Props) => {
    return (
        <AppContextProvider>
            <NavigationContainer>
                <Stack.Navigator screenOptions={{ headerShown: false }}>
                    <Stack.Screen name="Register" component={Register} />
                    <Stack.Screen name="Login" component={Login} />
                    
                    <Stack.Screen name="DrawerNav" component={DrawerNav} />
                </Stack.Navigator>
            </NavigationContainer>
        </AppContextProvider>
    )
}

export default MainNav