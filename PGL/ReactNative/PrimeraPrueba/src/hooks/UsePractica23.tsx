import { View, Text } from 'react-native'
import React from 'react'
import { useState } from 'react';

type Props = {}

type Tarea = {
    desc: string,
    terminada: boolean
}

const UsePractica23 = () => {
    const [tareas, setTareas] = useState<Array<Tarea>>([] as Array<Tarea>)

    function cambiarValor(id: number) {
        tareas[id].terminada = !tareas[id].terminada;
    }

    function createTarea(d: string, t: boolean){
        let tarea: Tarea;

        tarea = {
            desc: d,
            terminada: t
        }

        setTareas([...tareas, tarea]);
    }

    function modificarTarea(id: number, d: string, t: boolean){
        let tarea = tareas[id];

        tarea = {
            desc: d,
            terminada: t
        }

        setTareas([...tareas, tarea]);


    }

    return {
        tareas,
        modificarTarea,
        createTarea
    }
}

export default UsePractica23