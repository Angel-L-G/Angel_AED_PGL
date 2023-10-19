import React, { useRef } from 'react'
import { Persona } from './Persona';

type Props = {}

interface Iprops{
    id: number,
    modStatePadre: Function,
    p: Persona
}

const PersonaCard = (props: Iprops) => {
    const nameRef = useRef<HTMLInputElement>({} as HTMLInputElement);
    const apRef = useRef<HTMLInputElement>({} as HTMLInputElement);
    const altRef = useRef<HTMLInputElement>({} as HTMLInputElement);
    const ageRef = useRef<HTMLInputElement>({} as HTMLInputElement);
    const pesRef = useRef<HTMLInputElement>({} as HTMLInputElement);

    const { p } = props;
    const { id }  = props;

    function createPerson(){ 
        const name = nameRef.current.value ?? "";
        const ap = apRef.current.value ?? "";
        const alt = Number(altRef.current.value) ?? 0;
        const age = Number(ageRef.current.value) ?? 0;
        const pes = Number(pesRef.current.value) ?? 0;

    
        const persona = new Persona(id,name,ap, alt, age, pes);

        const { modStatePadre } = props;

        modStatePadre(persona);
    }

    return (
        <div className='conatiner'>
            <h3>Id: {p.id}</h3>
            <br />

            <label>Nombre: {p.nombre}</label>
            <input type="text" name="nombre" id="nombre" onChange={createPerson} ref={nameRef}/>
            <br />

            <label>Apellido: {p.apellido}</label>
            <input type="text" name="apellido" id="apellido" onChange={createPerson} ref={apRef}/>
            <br />

            <label>Altura: {p.altura}</label>
            <input type="text" name="altura" id="altura" onChange={createPerson} ref={altRef}/>
            <br />

            <label>Edad: {p.edad}</label>
            <input type="text" name="edad" id="edad" onChange={createPerson} ref={ageRef}/>
            <br />

            <label>Peso: {p.peso}</label>
            <input type="text" name="peso" id="peso" onChange={createPerson} ref={pesRef}/>

            <p>IMC: {p.imc}</p>

        </div>
    )
}

export default PersonaCard