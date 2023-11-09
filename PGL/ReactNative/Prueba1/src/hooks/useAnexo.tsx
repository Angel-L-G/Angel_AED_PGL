import { StyleSheet, Text, View } from 'react-native'
import React, { useEffect, useState } from 'react'

type Props = {}
type FormData = {
    jubilado: boolean,
    casado: boolean,
    edad: number,
    nombre: string
}

const useAnexo = () => {
    const [formData, setFormData] = useState<FormData>({} as FormData);
    const [jubilado, setJubilado] = useState(false);
    const [casado, setCasado] = useState(false);

    useEffect(() => {
        fillFormData(jubilado,"jubilado")
    }, [jubilado])
    
    useEffect(() => {
        fillFormData(casado,"casado")
    }, [casado])

    function fillFormData(value: boolean | number | string, field: keyof FormData) {
        setFormData(
            {
                ...formData,
                [field]: value
            }
        );
    }

    return {
        formData,
        setFormData,
        fillFormData,
        jubilado,
        setJubilado,
        casado,
        setCasado
    }
}

export default useAnexo;
