import { StyleSheet, Text, TouchableHighlight, View } from 'react-native'
import React, { useState } from 'react'
import BotonCalc from '../components/BotonCalc';
import usePractica10 from '../hooks/usePractica10';

type Props = {}

const Practica10 = (props: Props) => {
    const {arrVal, arrColor, numActual} = usePractica10();

    return (
        <View style={styles.principal}>
            <View>
                <Text adjustsFontSizeToFit={true} numberOfLines={1} > 
                    texto 
                </Text>
            </View>
            <View>       
                <Text>Practica10</Text>
                {
                    arrVal.map((value,index) => {
                        {
                            let color = arrColor[2];
                            
                            if(index <  3){
                                color = arrColor[0];
                            }else if(index == 3 || index == 7 || index == 11 || index == 15 || index == 18){
                                color = arrColor[1];
                            }

                            return <BotonCalc txt={value} color={color}/>;
                        }
                    })
                }
            </View>
        </View>
    )
}

export default Practica10

const styles = StyleSheet.create({
    principal: {
        flex: 1,
        backgroundColor: "black"
    }

})