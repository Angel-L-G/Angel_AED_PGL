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

type SectionProps = PropsWithChildren<{
    title: string;
}>;

function Section({ children, title }: SectionProps): JSX.Element {
    const isDarkMode = useColorScheme() === 'dark';
    return (
        <div></div>
    );
}

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

export default App;
