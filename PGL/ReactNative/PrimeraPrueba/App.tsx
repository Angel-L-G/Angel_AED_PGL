/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import React, { useState } from 'react';
import type { PropsWithChildren } from 'react';
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

import Practica2 from './src/components/Practica2';
import InicioScreen from './src/components/Practica3';
import Practica4 from './src/screens/Practica4';
import Practica8 from './src/screens/Practica8';
import Practica9 from './src/screens/Practica9';
import Practica10 from './src/screens/Practica10';
import Practica12 from './src/screens/Practica12';
import Practica15 from './src/screens/Practica15';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { NavigationContainer } from '@react-navigation/native';
import Practica23 from './src/screens/Practica23';
import AppContextProvider from './src/context/AppContextProvider';

type Props = {
	navigation: any
}

function HomeScreen({navigation}: Props) {
	return (
		<SafeAreaView style={{flex: 1}}>
			<View style={{flex: 1, alignItems: 'center', justifyContent: 'center'}}>
				<Text>Home Screen</Text>
				<Button title='Inicio' onPress={() => navigation.navigate("Inicio")}/>
				<Button title='Practica2' onPress={() => navigation.navigate("Practica2")}/>
				<Button title='Practica4' onPress={() => navigation.navigate("Practica4")}/>
				<Button title='Practica8' onPress={() => navigation.navigate("Practica8")}/>
				<Button title='Practica9' onPress={() => navigation.navigate("Practica9")}/>
				<Button title='Practica10' onPress={() => navigation.navigate("Practica10")}/>
				<Button title='Practica12' onPress={() => navigation.navigate("Practica12")}/>
				<Button title='Practica15' onPress={() => navigation.navigate("Practica15")}/>
				<Button title='Practica23' onPress={() => navigation.navigate("Practica23")}/>
			</View>
		</SafeAreaView>
	)
}

const Stack = createNativeStackNavigator();

function App(): JSX.Element {
	return (
		<NavigationContainer>
			<AppContextProvider>
				<Stack.Navigator >
					{/*
					<Stack.Screen name="Home" component={HomeScreen} />
					<Stack.Screen name="Inicio" component={InicioScreen} />
					<Stack.Screen name="Practica2" component={Practica2} />
					<Stack.Screen name="Practica4" component={Practica4} />
					<Stack.Screen name="Practica8" component={Practica8} />
					<Stack.Screen name="Practica9" component={Practica9} />
					<Stack.Screen name="Practica10" component={Practica10} />
					<Stack.Screen name="Practica12" component={Practica12} />
					<Stack.Screen name="Practica15" component={Practica15} />
					*/}
					<Stack.Screen options={{headerStyle: {backgroundColor: '#709CEB'}, headerTintColor: 'white', headerTitleAlign: "center"}} name="Tareas" component={Practica23} />
				</Stack.Navigator>
			</AppContextProvider>
		</NavigationContainer>
	);
}

export default App;
