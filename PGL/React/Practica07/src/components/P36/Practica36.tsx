import React, { useState } from 'react'
import { Persona } from './Persona'
import PersonaCard from './PersonaCard';

type Props = {}

function Practica36({ }: Props) {
    const [arrPersona, setArrPersona] = useState<Array<Persona>>([]);
    const [id, setId] = useState(0);
    setId(arrPersona.length+1);

    function modState(p: Persona) {
        setArrPersona([...arrPersona,p]);
    }

    const p = new Persona(id,"","",0,0,0);

    return (
        <div className='container'>
            {
                arrPersona.map((valor, index) =>{
                    return <PersonaCard id={id} modStatePadre={modState} p={valor}/>
                })
            }
            <button>Add Persona</button>
        </div>
    )
}

export default Practica36