import { View, Text } from 'react-native'
import React from 'react'
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import Login from '../screens/Login';
import Register from '../screens/Register';

type RootStackParamList = {
    Login: undefined,
    Register: undefined,
};

type Props = {}
const Stack = createNativeStackNavigator<RootStackParamList>();

const MainNav = (props: Props) => {
    return (
        <NavigationContainer>
            <Stack.Navigator screenOptions={{ headerShown: false }}>
                <Stack.Screen name="Register" component={Register} />
                <Stack.Screen name="Login" component={Login} />
            </Stack.Navigator>
            {/*<DrawerNav/>*/}
        </NavigationContainer>
    )
}

export default MainNav