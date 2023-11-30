import { FlatList, StyleSheet, Text, TouchableHighlight, View } from 'react-native'
import React, { useState } from 'react'
import PokemonCard from '../components/PokemonCard';
import UsePractica28List from '../hooks/UsePractica28List';
import PokemonCardParaList from '../components/PokemonCardParaList';

type Props = {
    navigation: any
}

const Practica28Listar = (props: Props) => {
    let {results} = UsePractica28List();

    return (
        <View style={{flex: 1, backgroundColor: "lightgrey"}}>
            {
                <FlatList
                    data={results}
                    renderItem={({item}) => (
                        <TouchableHighlight onPress={() => props.navigation.navigate("PokemonCard", {uri: item})}>
                            <PokemonCardParaList uri={item}/>
                        </TouchableHighlight>
                    )}
                />
            }
        </View>
    )
}

export default Practica28Listar

const styles = StyleSheet.create({})