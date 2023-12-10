import { StyleSheet, Text, View } from 'react-native'
import React, { useState } from 'react'

type FormData = {
    jubilado: boolean,
    casado: boolean,
    edad: number,
    nombre: string
}

const usePractica15 = () => {
    const [formData, setFormData] = useState<FormData>({} as FormData);
    const [jubilado, setJubilado] = useState(false);
    const [casado, setCasado] = useState(false);

    function fillFormData(value: boolean|number|string, field: keyof FormData) {
        setFormData(
            {
                ...formData,
                [field]: value
            }
        );
    }

    return {
        formData,
        fillFormData,
        jubilado,
        setJubilado,
        casado,
        setCasado
    }
}

export default usePractica15