import 'react-native-gesture-handler';

/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 */

import React, { useEffect } from 'react';
import type {PropsWithChildren} from 'react';
import {
  SafeAreaView,
  ScrollView,
  StatusBar,
  StyleSheet,
  Text,
  useColorScheme,
  View,
} from 'react-native';
import MainNav from './src/navigations/MainNav';
import { GestureHandlerRootView } from 'react-native-gesture-handler';

//import { dataSource } from './src/data/Database';


function App(): JSX.Element {

    useEffect(() => {
        /*async function iniciarDDBB(){
        await dataSource.initialize();
        }
        iniciarDDBB();*/
    }, []);


    return (
        <MainNav />
    );
}

export default App;
