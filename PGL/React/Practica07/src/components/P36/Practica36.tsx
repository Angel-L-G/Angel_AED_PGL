import React, { useState } from 'react'
import { Persona } from './Persona'
import PersonaCard from './PersonaCard';

type Props = {}

function Practica36({ }: Props) {
    const [arrPersona, setArrPersona] = useState<Array<Persona>>([]);

    function modState(p: Persona) {
        setArrPersona([...arrPersona,p]);
    }

    return (
        <div className='container'>
            
            <button>Add Persona</button>
        </div>
    )
}

export default Practica36