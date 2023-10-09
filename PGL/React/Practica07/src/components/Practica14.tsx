import React from 'react';
import Tabla from './Practica9';

type Props = {}

const Practica14 = (props: Props) => {
    let arr: Array<number> = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10];
    return (
        <div className="container">
            {
                arr.map((elemento, index) => {
                    return <Tabla key={index} tablaDel={elemento} />;
                })
            }
        </div>
    );
}

export default Practica14