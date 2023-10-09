import React, { useState } from 'react'

type Props = {}
type Moneda = {
    nombre: string,
    pais: string
}

const Practica13 = (props: Props) => {
    const [monedas, setmonedas] = useState<Array<Moneda>>([]);
    function addMoneda() {
        const moneda: Moneda = {
            nombre: "libra",
            pais: "uk"
        }
        setmonedas([...monedas, moneda]);
    }
    return (
        <div className='container'>
            <h3>Cliente de monedas</h3>
            <div>
                <button onClick={addMoneda} className='button'>
                    agregar moneda
                </button>
                <h4>Monedas: </h4>
                <ul>
                    {
                        monedas.map((m: Moneda) => {
                            return (
                                <>
                                    <li> {m.pais + " " + m.nombre} </li>
                                </>
                            );
                        })
                    }
                </ul>
            </div>
        </div>
    );


}

export default Practica13