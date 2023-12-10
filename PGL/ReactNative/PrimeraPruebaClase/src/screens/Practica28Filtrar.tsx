import { FlatList, StyleSheet, Text, TextInput, TouchableHighlight, View } from 'react-native'
import React, { useEffect } from 'react'
import UsePractica28Filtrar from '../hooks/UsePractica28Filtrar'
import PokemonCardParaList from '../components/PokemonCardParaList'

type Props = {
    navigation: any
}

const Practica28Filtrar = (props: Props) => {
    let {listaFiltrado, filtrar, results} = UsePractica28Filtrar();

    return (
        <View>
            <TextInput onChangeText={(text) => filtrar(text)} placeholder='Introduce un texto'/>
            <View>
                <FlatList
                    data={listaFiltrado}
                    renderItem={({item}) => (
                        <TouchableHighlight onPress={() => props.navigation.navigate("PokemonCard", {uri: item})}>
                            <PokemonCardParaList uri={item.url}/>
                        </TouchableHighlight>
                    )}
                />
            </View>
        </View>
    )
}

export default Practica28Filtrar

const styles = StyleSheet.create({})