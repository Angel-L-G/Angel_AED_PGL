import React, { useState } from 'react'

type Props = {}

const Practica29 = (props: Props) => {
    const [num, setNum] = useState(20);

    function calculate(oper: number){
        if(oper == 1){
            setNum(num*2);
        }else{
            setNum(num/2);
        }
    }

  return (
    <div className='container'>
        <h2>Valor Actual: {num}</h2>
        <button className='button' onClick={() => calculate(0)}>{num}/2</button>
        <button className='button' onClick={() => calculate(1)}>{num}*2</button>
    </div>
  )
}

export default Practica29