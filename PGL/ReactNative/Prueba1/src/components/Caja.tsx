import { Button, StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'

type Props = {
    color?: string
}

const Caja = (props: Props) => {
    const color = props.color?? "beige";
    const [counter, setCounter] = useState(1);

    return (
        <View style={{
            ...styles.caja,
            backgroundColor: color,
            flex: counter
        }}>
            <Button title="+1" onPress={()=>setCounter(counter+1)}/>
            <Button title="-1" onPress={()=>setCounter(counter-1)}/>
            <Text>Caja: {counter}</Text>
        </View>
    )
}

export default Caja

const styles = StyleSheet.create({
    caja: {
        flex: 1,
        height: 100,
        width: 200,
        margin: 5,
    }

})