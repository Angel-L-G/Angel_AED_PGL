import React from 'react'

type Props = {}

interface Iprops{
    modStatePadre: Function
}

const PersonaCard = (props: Iprops) => {

    function createPerson(){
        const { modStatePadre } = props;
    }

    return (
        <div className='conatiner'>
            <h3>Id: </h3>
            <br />

            <label>Nombre: </label>
            <input type="text" name="nombre" id="nombre" />
            <br />

            <label>Apellido: </label>
            <input type="text" name="apellido" id="apellido" />
            <br />

            <label>Altura: </label>
            <input type="text" name="altura" id="altura" />
            <br />

            <label>Edad: </label>
            <input type="text" name="edad" id="edad" />
            <br />

            <label>Peso: </label>
            <input type="text" name="peso" id="peso" />

        </div>
    )
}

export default PersonaCard