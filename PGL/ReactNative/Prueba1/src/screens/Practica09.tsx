import { Button, Image, StyleSheet, Text, TextInput, View } from 'react-native'
import React, { useState } from 'react'
import stylesp08 from '../themes/P8Styles'

type Props = {}
type Estilo = "stretch"|"center"|"flex-start"|"flex-end";

const Practica09 = (props: Props) => {
    const [estilo, setEstilo] = useState<Estilo>();
    const [estiloContenido, setEstiloContenido] = useState<string>();



    return (
        <View style={styles.principal}>
            <TextInput 
            style={{backgroundColor: "white", margin:10}} 
            onChangeText={nuevoTexto => setEstiloContenido(nuevoTexto)}
            placeholder='space-around'
            />

            <View style={styles.secundary}>
                <Button title="Stretch" onPress={() => setEstilo("stretch")}/>
                <Button title="Center" onPress={() => setEstilo("center")}/>
                <Button title="Flex-start" onPress={() => setEstilo("flex-start")}/>
                <Button title="Flex-end" onPress={() => setEstilo("flex-end")}/>
            </View>

            <View style={{...styles.terciary, alignItems: estilo/*, justifyContent: estiloContenido as*/}}>
                <Image
                source = {{uri: "https://img.freepik.com/vector-premium/logotipo-estrella-simple-moderno_535345-2471.jpg?w=740"}}
                style={{width: 50, height: 50}}
                />

                <Image 
                source={{uri: "https://img.freepik.com/vector-gratis/vector-forma-geometrica-pentagono-azul_53876-175075.jpg?w=740&t=st=1692203592~exp=1692204192~hmac=b6f63c07a79e2ff41719578b178e004f851718b3b467bf1976878d8b800b9201"}}
                style={{width: 50, height: 50}}
                />

                <Image 
                source={{uri:"https://img.freepik.com/psd-gratis/caja-carton-aislada_125540-1169.jpg?w=1060&t=st=1692203785~exp=1692204385~hmac=ce41256e62eb2af8e8e813b44cbfb4bed697c698b2902ffdb0cb8f502df86d1d"}}
                style={{width: 50, height: 50}}
                />
            </View>
        </View>
    )
}

export default Practica09;

const styles = StyleSheet.create({
    principal: {
        backgroundColor: "grey",
        flex: 1,
        margin: 5,
        padding: 10,
    },
    
    secundary: {
        flexDirection: 'row',
        backgroundColor: "grey",
        justifyContent: "center",
        gap: 15,
        maxWidth: "auto",
        margin: 5
    },

    terciary: {
        flexWrap: 'nowrap',
        flex: 1,
        backgroundColor: "lightgrey",
        justifyContent: "space-around",
        alignItems: "flex-end",
    }
})