import { Button, Image, StyleSheet, Text, TextInput, View } from 'react-native'
import React, { useState } from 'react'
import stylesPractica9 from '../themes/Practicas9Styles'

type Props = {}

type Align = "baseline" | "center" | "flex-end" | "flex-start" | "stretch";
type Justify = "baseline" | "center" | "flex-end" | "flex-start" | "stretch";

const Practica9 = (props: Props) => {
    const [align, setAlign] = useState <Align>("flex-start");
    const [justify, setJustify] = useState <Justify>("flex-start");

    return (
        <View style={{margin: 10, backgroundColor: "gray", flex: 1}}>
            <TextInput style={{borderWidth: 1, margin: 10, backgroundColor: "white"}} 
                onChangeText={newText => setJustify(newText)}
            />
            <View style={stylesPractica9.botonesJuntos}>
                <Button title='STRETCH' onPress={() => setAlign("stretch")}/>
                <Button title='CENTER' onPress={() => setAlign('center')}/>
                <Button title='FLEX-START' onPress={() => setAlign('flex-start')}/>
                <Button title='FLEX-END' onPress={() => setAlign('flex-end')}/>
            </View>
            <View style={{
                ...styles.imgs, alignItems: align
            }}>
                <Image source={{uri: "https://img.freepik.com/vector-premium/logotipo-estrella-simple-moderno_535345-2471.jpg?w=740"}}
                    style={{width: 50, height: 50}}
                />
                <Image source={{uri: "https://img.freepik.com/vector-gratis/vector-forma-geometrica-pentagono-azul_53876-175075.jpg?w=740&t=st=1692203592~exp=1692204192~hmac=b6f63c07a79e2ff41719578b178e004f851718b3b467bf1976878d8b800b9201"}}
                    style={{width: 50, height: 50}}
                />
                <Image source={{uri: "https://img.freepik.com/psd-gratis/caja-carton-aislada_125540-1169.jpg?w=1060&t=st=1692203785~exp=1692204385~hmac=ce41256e62eb2af8e8e813b44cbfb4bed697c698b2902ffdb0cb8f502df86d1d"}}
                    style={{width: 50, height: 50}}
                />
            </View>
        </View>
    )
}

export default Practica9

const styles = StyleSheet.create({
    imgs: {
        flex: 1, backgroundColor: "lightgray", margin: 20, justifyContent: 'space-around', flexWrap: "nowrap",
    }
})