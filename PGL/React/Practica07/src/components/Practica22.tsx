import React from 'react';
import Reloj from './Reloj';

type Props = {}

const Practica22 = (props: Props) => {
    let arr: Array<string> = ["Europe/London","America/New_York","Europe/Madrid"];

  return (
    <div className='container'>
        
            {
                arr.map((valor,index) => {
                    return <p><Reloj zona={valor}/></p>
                })
            }
        
    </div>
  )
}

export default Practica22