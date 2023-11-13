/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import React, { useState } from 'react';
import type { PropsWithChildren } from 'react';
import Contador from '../../React/Practica07/src/components/Practica8';
import {
    Button,
    SafeAreaView,
    ScrollView,
    StatusBar,
    StyleSheet,
    Text,
    useColorScheme,
    View,
} from 'react-native';

import {
    Colors,
    DebugInstructions,
    Header,
    LearnMoreLinks,
    ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';
import Practica04 from './src/screens/Practica04-5';
import Practica07 from './src/screens/Practica07';
import Practica09 from './src/screens/Practica09';
import Practica10 from './src/screens/Practica10';
import Practica12 from './src/screens/Practica12';
import Practica13 from './src/screens/Practica13';
import Practica15 from './src/screens/Practica15';
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';

type SectionProps = PropsWithChildren<{
    title: string;
}>;

function Section({ children, title }: SectionProps): JSX.Element {
    const isDarkMode = useColorScheme() === 'dark';
    return (
        <div></div>
    );
}

function HomeSreen(){
    return (
        <SafeAreaView>
            <View style={{ flex: 1, alignItems: 'center', justifyContent: 'center' }}>
                <Text>Home</Text>
            </View>
        </SafeAreaView>
    );
}

const Stack = createNativeStackNavigator();

function App(): JSX.Element {
    const [contador,setContador] = useState(0);

    return (

        <NavigationContainer>
            <Stack.Navigator>
                <Stack.Screen name="Home" component={HomeSreen} />
            </Stack.Navigator>
        </NavigationContainer>
    );
}

export default App;

/*
function App(): JSX.Element {
    const [contador,setContador] = useState(0);

    return (
        <View style={{
            flex: 1,
            borderWidth: 3,
            borderColor: "black",
            backgroundColor: "ligthgray",
            margin: 1
        }}>

            <Text>Ejercicio Basico. Contador:{contador}</Text>
            <Button title='Pulsame' onPress={()=>setContador(contador+1)}></Button>
        </View>
    );
}
*/
