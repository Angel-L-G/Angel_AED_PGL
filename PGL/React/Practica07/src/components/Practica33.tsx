import React, { useState } from 'react'
import usePractica33 from '../hooks/usePractica33'

type Props = {}

const Practica33 = (props: Props) => {
    const {listaPrimos, processForm}= usePractica33();

    return (
        <div className='container'>
            <form onSubmit={processForm}>
                <label>Primo Mayor</label>
                <input type="text" id="mayor"/>
                <br/>
                <label>Primo Menor</label>
                <input type="text" id="menor"/>
                <br/>
                <button type="submit">Enviar</button>
            </form>

            <textarea value={JSON.stringify(listaPrimos,null,2)} cols={100} rows={30}/>
            <p>Numero de Primos: {listaPrimos.length}</p>
        </div>
    )
}

export default Practica33