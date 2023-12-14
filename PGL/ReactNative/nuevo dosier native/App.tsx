import 'react-native-gesture-handler';
/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import React, { useEffect } from 'react';
import type { PropsWithChildren } from 'react';

import {
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
import { NavigationContainer } from '@react-navigation/native';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { GestureHandlerRootView } from 'react-native-gesture-handler';
import P31Stack from './src/navigations/P31Stack';
import Practica31Listar from './src/screens/Practica31Listar';
import Practica31Unica from './src/screens/Practica31Unica';
import Practica31Crear from './src/screens/Practica31Crear';
import Practica31ListarFeeds from './src/screens/Practica31ListarFeeds';
import { dataSource } from './src/data/Database';

type SectionProps = PropsWithChildren<{
    title: string;
}>;

export type RootStackParamList = {
    Practica31ListarFeeds: undefined
    Practica31Listar: { feed: Feed },
    Practica31Unica: { desc: string },
    Practica31Crear: undefined,
}

type Feed = {
    id: number,
    titulo: string,
    url: string
}

const Stack = createNativeStackNavigator<RootStackParamList>();

function App(): JSX.Element {
    useEffect(() => {
        async function iniciarDB() {
            await dataSource.initialize();
        }

        iniciarDB();
    }, [])


    return (
        <NavigationContainer>
            <Stack.Navigator screenOptions={{ headerShown: false }}>
                <Stack.Screen name="Practica31ListarFeeds" component={Practica31ListarFeeds} />
                <Stack.Screen name="Practica31Listar" component={Practica31Listar} />
                <Stack.Screen name="Practica31Crear" component={Practica31Crear} />
                <Stack.Screen name="Practica31Unica" component={Practica31Unica} />
            </Stack.Navigator>
        </NavigationContainer>
    )
}

export default App;
