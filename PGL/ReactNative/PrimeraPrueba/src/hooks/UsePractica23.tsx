import { View, Text } from 'react-native'
import React from 'react'
import { useState } from 'react';
import { useAppContext } from '../context/AppContextProvider';

type Props = {}

type Tarea = {
    desc: string,
    terminada: boolean
}

const UsePractica23 = () => {
    let {setTareasContext, tareasContext} = useAppContext();

    function cambiarValor(id: number) {
        let t = tareasContext[id];
        t.terminada = !t.terminada;
        let trs = tareasContext;
        trs[id] = t;
        setTareasContext(trs);
    }

    function createTarea(){
        let tarea: Tarea;

        tarea = {
            desc: "Por Actualizar",
            terminada: false
        }

        setTareasContext([...tareasContext, tarea]);
    }

    function modificarTarea(id: number, d: string, t: boolean){
        let tarea = tareasContext[id];

        tarea = {
            desc: d,
            terminada: t
        }

        setTareasContext([...tareasContext, tarea]);
    }

    function deleteTarea(id: number){
        let aux: Array<Tarea>;
        aux = [];

        tareasContext.map((value, index) => {
            if(index != id){
                aux = [...aux, value];
            }
        })

        if(aux.length > 0){
            setTareasContext(aux);
        }
    }

    return {
        modificarTarea,
        createTarea,
        cambiarValor,
        deleteTarea
    }
}

export default UsePractica23