import { Button, StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'
import stylesp08 from '../themes/P8Styles'
import Circulo from '../components/Circulo'

type Props = {}

type WrapStyle = "wrap"|"nowrap";
type Aligment = "row"|"column"|"row-reverse"|"column-reverse";

const Practica07 = (props: Props) => {
    const [wrapStyle, setWrapStyle] = useState<WrapStyle>("nowrap");
    const [aligment, setAligment] = useState<Aligment>("column");
    const [nums, setNums] = useState<Array<number>>([]);
    const [counter, setCounter] = useState(0);

    function changeWrap() {
        if(wrapStyle == "nowrap"){
            setWrapStyle("wrap");
        }else{
            setWrapStyle("nowrap");
        }
    }

    function changeAligment() {
        if(aligment == "column"){
            setAligment("row");
        }else{
            setAligment("column");
        }
    }

    function agregar(){
        setCounter(counter + 1);
        setNums([...nums, counter]);
    }

    return (
        <View style={stylesp08.principal}>
            <Button title="Agregar" onPress={agregar}/>
            <Button title={wrapStyle} onPress={changeWrap}/>
            <Button title={aligment} onPress={changeAligment}/>

            <View style={stylesp08.secundary}>
                {
                    nums.map((value,key) => {
                        return <Circulo 
                            num={key} 
                            color={"a"}
                        />
                    })
                }
            </View>
        </View>
    )
}

export default Practica07;
