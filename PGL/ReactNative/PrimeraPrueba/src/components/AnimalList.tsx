import { StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'
import { FlatList } from 'react-native-gesture-handler'
import { Image } from 'react-native-reanimated/lib/typescript/Animated'

type Props = {}
type Animal = {
    nombre: string,
    img: string,
}

const AnimalList = (props: Props) => {
    const [animales, setAnimales] = useState<Array<Animal>>([] as Array<Animal>);

    return (
        <View>
            <FlatList 
                data={animales}
                renderItem={({ item }) => 
                    <View>
                        <Image
                            style={{}}
                            source={{
                                uri: item.img,
                            }}
                        />
                        <Text>{item.nombre}</Text>
                    </View>
                }
            />
        </View>
    )
}

export default AnimalList

const styles = StyleSheet.create({})