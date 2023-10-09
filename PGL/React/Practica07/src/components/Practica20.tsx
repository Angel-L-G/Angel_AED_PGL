import React, { useEffect, useState } from 'react'
import '../index.css';

type Props = {}



const Practica20 = (props: Props) => {
  function apostar(num: number){
    return num === rand;
  }

  useEffect(() => {
    return () => {
      
    }
  }, [])
  const [rand, setRand] = useState(0);
  setRand(Math.floor(Math.random()*10));


  return (
    <div className='container'>
      <h2>Acertar Numero</h2>
      <button onClick={() => apostar(0)} > 0 </button>
      <button onClick={() => apostar(1)} > 1 </button>
      <button onClick={() => apostar(2)} > 2 </button>
      <button onClick={() => apostar(3)} > 3 </button>
      <button onClick={() => apostar(4)} > 4 </button>
      <button onClick={() => apostar(5)} > 5 </button>
      <button onClick={() => apostar(6)} > 6 </button>
      <button onClick={() => apostar(7)} > 7 </button>
      <button onClick={() => apostar(8)} > 8 </button>
      <button onClick={() => apostar(9)} > 9 </button>
      <p>{rand}</p>
    </div>
  )
}

export default Practica20