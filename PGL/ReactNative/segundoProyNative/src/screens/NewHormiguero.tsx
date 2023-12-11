import { View, Text, TextInput, TouchableHighlight } from 'react-native'
import React from 'react'
import styles from '../themes/styles'
import SelectDropdown from 'react-native-select-dropdown'

type Props = {}

const NewHormiguero = (props: Props) => {
    const biomas = ["Humedal", "Planicie", "Montaña", "Bosque"];
    const hormigas = ["Humedal", "Planicie", "Montaña", "Bosque"];

    return (
        <View style={styles.container}>
            <View style={styles.crearBody}>
                <Text style={styles.title}>Crear Hormiguero</Text>
                <Text></Text>

                <View style={styles.formContainer}>
                    <Text style={styles.formTitle}>Nombre: </Text>
                    <TextInput placeholder='nombre'></TextInput>

                    <View style={styles.innerFormContainer}>
                        <Text style={styles.subTitle}>Bioma: </Text>
                        <SelectDropdown
                            data={biomas}
                            onSelect={(selectedItem, index) => {
                                console.log(selectedItem, index)
                            }}
                            buttonTextAfterSelection={(selectedItem, index) => {
                                return selectedItem
                            }}
                            rowTextForSelection={(item, index) => {
                                return item
                            }}
                            defaultButtonText='Biome'
                        />
                    </View>

                    <Text></Text>

                    <View style={styles.innerFormContainer}>
                        <Text style={styles.subTitle}>Tipo de Hormiga: </Text>
                        <SelectDropdown
                            data={hormigas}
                            onSelect={(selectedItem, index) => {
                                console.log(selectedItem, index)
                            }}
                            buttonTextAfterSelection={(selectedItem, index) => {
                                return selectedItem
                            }}
                            rowTextForSelection={(item, index) => {
                                return item
                            }}
                            defaultButtonText='Tipo De Hormiga'
                        />
                    </View>

                    <Text></Text>

                    <TouchableHighlight style={styles.button}>
                        <Text style={styles.textBody}>Crear</Text>
                    </TouchableHighlight>
                </View> 
            </View>
        </View>
    )
}

export default NewHormiguero