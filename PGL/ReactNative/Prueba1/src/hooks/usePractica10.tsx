import { StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'

const usePractica10 = () => {
    const [numActual, setNumActual] = useState(0);
    const arrVal = ["AC","+-","%","/","7","8","9","x","4","5","6","-","3","2","1","+","0",".","=",];
    const arrColor = ["lightgrey","orange","grey"];

    return {
        arrVal,
        arrColor,
        numActual,
        setNumActual
    };
}

export default usePractica10;