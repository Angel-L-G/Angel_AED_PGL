import { StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'

const usePractica10 = () => {
    const [linea, setLinea] = useState("");
    const arr: Array<string> = ["AC", "±", "%", "/", "7", "8", "9", "x", "4", "5", "6", "-", "1", "2", "3", "+", "0", ".", "="];

    return {
        arr,
        linea,
        setLinea
    }
}

export default usePractica10

const styles = StyleSheet.create({})