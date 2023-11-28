import { Button, StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'

type Props = {}
type Tarea = {
    desc: string,
    terminada: boolean
}

const Practica23 = (props: Props) => {
    const [tareas, setTareas] = useState<Array<Tarea>>([] as Array<Tarea>)

    return (
        <View style={{flex: 1}}>
            <View style={{flex: 1}}>
                {
                    tareas.map((value,index) => {
                        return <span>
                            <Text>{value.desc}</Text>
                        </span>
                    })
                }
            </View>
            <View style={{}}>
                <Button title='+'/>
            </View>
        </View>
    )
}

export default Practica23

const styles = StyleSheet.create({})