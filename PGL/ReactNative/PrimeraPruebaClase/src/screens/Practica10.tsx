import { Alert, Button, StyleSheet, Text, TextInput, TouchableHighlight, View } from 'react-native'
import React, { useState } from 'react'
import BotonCalculadora from '../components/BotonCalculadora';
import usePractica10 from '../hooks/usePractica10';

type Props = {}

const Practica10 = (props: Props) => {
    const {arr, linea, setLinea} = usePractica10();

    return (
        <View style={{backgroundColor: "black", flex: 1}}>
            <View style={{flex: 1, justifyContent: 'flex-end'}}>
                <Text adjustsFontSizeToFit={true} numberOfLines={1} style={{fontSize: 100, color: "white", textAlign: "right"}}>{linea}</Text>
            </View>
            <View style={{flexDirection: 'row', flexWrap: 'wrap', margin: 35}}>
                {
                    arr.map((value, index) => {
                        if (index == 16) {
                            return <TouchableHighlight onPress={() => setLinea(linea + value)}><BotonCalculadora key={index} texto={value} fondo="grey" letra="white" largo={160}/></TouchableHighlight>
                        } else if (index < 3) {
                            return <BotonCalculadora key={index} texto={value} fondo="lightgrey" letra="black"/>;
                        } else if (index == 3 || index == 7 || index == 11 || index == 15) {
                            return <BotonCalculadora key={index} texto={value} fondo="orange" letra="white"/>;
                        } else {
                            return <BotonCalculadora key={index} texto={value} fondo="grey" letra="white"/>;
                        }
                    })
                }
                {/*
                <TouchableHighlight onPress={() => setLinea("")}>
                    <View style={{...styles.boton, backgroundColor: "lightgray"}}>
                        <Text style={{color: "black", fontSize: 30}}>AC</Text>
                    </View>
                </TouchableHighlight>
                <TouchableHighlight>
                    <View style={{...styles.boton, backgroundColor: "lightgray"}}>
                        <Text style={{color: "black", fontSize: 30}}>±</Text>
                    </View>
                </TouchableHighlight>
                <TouchableHighlight onPress={() => setLinea(linea + "%")}>
                    <View style={{...styles.boton, backgroundColor: "lightgray"}}>
                        <Text style={{color: "black", fontSize: 30}}>%</Text>
                    </View>
                </TouchableHighlight>
                <TouchableHighlight onPress={() => setLinea(linea + "/")}>
                    <View style={{...styles.boton, backgroundColor: "orange"}}>
                        <Text style={{color: "white", fontSize: 30}}>/</Text>
                    </View>
                </TouchableHighlight>
                <TouchableHighlight onPress={() => setLinea(linea + "7")}>
                    <View style={styles.boton}>
                        <Text style={{color: "white", fontSize: 30}}>7</Text>
                    </View>
                </TouchableHighlight>
                <TouchableHighlight onPress={() => setLinea(linea + "8")}>
                    <View style={styles.boton}>
                        <Text style={{color: "white", fontSize: 30}}>8</Text>
                    </View>
                </TouchableHighlight>
                <TouchableHighlight onPress={() => setLinea(linea + "9")}>
                    <View style={styles.boton}>
                        <Text style={{color: "white", fontSize: 30}}>9</Text>
                    </View>
                </TouchableHighlight>
                <TouchableHighlight onPress={() => setLinea(linea + "x")}>
                    <View style={{...styles.boton, backgroundColor: "orange"}}>
                        <Text style={{color: "white", fontSize: 30}}>x</Text>
                    </View>
                </TouchableHighlight>
                <TouchableHighlight onPress={() => setLinea(linea + "4")}>
                    <View style={styles.boton}>
                        <Text style={{color: "white", fontSize: 30}}>4</Text>
                    </View>
                </TouchableHighlight>
                <TouchableHighlight onPress={() => setLinea(linea + "5")}>
                    <View style={styles.boton}>
                        <Text style={{color: "white", fontSize: 30}}>5</Text>
                    </View>
                </TouchableHighlight>
                <TouchableHighlight onPress={() => setLinea(linea + "6")}>
                    <View style={styles.boton}>
                        <Text style={{color: "white", fontSize: 30}}>6</Text>
                    </View>
                </TouchableHighlight>
                <TouchableHighlight onPress={() => setLinea(linea + "-")}>
                    <View style={{...styles.boton, backgroundColor: "orange"}}>
                        <Text style={{color: "white", fontSize: 30}}>-</Text>
                    </View>
                </TouchableHighlight>
                <TouchableHighlight onPress={() => setLinea(linea + "1")}>
                    <View style={styles.boton}>
                        <Text style={{color: "white", fontSize: 30}}>1</Text>
                    </View>
                </TouchableHighlight>
                <TouchableHighlight onPress={() => setLinea(linea + "2")}>
                    <View style={styles.boton}>
                        <Text style={{color: "white", fontSize: 30}}>2</Text>
                    </View>
                </TouchableHighlight>
                <TouchableHighlight onPress={() => setLinea(linea + "3")}>
                    <View style={styles.boton}>
                        <Text style={{color: "white", fontSize: 30}}>3</Text>
                    </View>
                </TouchableHighlight>
                <TouchableHighlight onPress={() => setLinea(linea + "+")}>
                    <View style={{...styles.boton, backgroundColor: "orange"}}>
                        <Text style={{color: "white", fontSize: 30}}>+</Text>
                    </View>
                </TouchableHighlight>
                <TouchableHighlight onPress={() => setLinea(linea + "0")}>
                    <View style={{...styles.boton, width: 160, alignItems: 'flex-start'}}>
                        <Text style={{color: "white", fontSize: 30, marginLeft: 28}}>0</Text>
                    </View>
                </TouchableHighlight>
                <TouchableHighlight onPress={() => setLinea(linea + ".")}>
                    <View style={styles.boton}>
                        <Text style={{color: "white", fontSize: 30}}>.</Text>
                    </View>
                </TouchableHighlight>
                <TouchableHighlight>
                    <View style={{...styles.boton, backgroundColor: "orange"}}>
                        <Text style={{color: "white", fontSize: 30}}>=</Text>
                    </View>
                </TouchableHighlight>*/
}
            </View>
        </View>
    )
}

export default Practica10

const styles = StyleSheet.create({
    boton:  {
        width: 80,
        height: 80,
        backgroundColor: "gray",
        borderRadius: 100,
        borderWidth: 2,
        justifyContent: "center",
        alignItems: 'center',
    }
})