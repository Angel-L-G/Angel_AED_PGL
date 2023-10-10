import React, { useEffect, useRef, useState } from 'react'

type Props = {}

const Practica24 = (props: Props) => {
    const [strRes, setstrRes] = useState("");
    const [num, setnum] = useState(-1);
    const inputNum = useRef<HTMLInputElement>({} as HTMLInputElement);

    function apostar(){
        let inputNumObj = inputNum.current;
        setnum(parseInt(inputNumObj.value));
        
      if(num > rand){
        setstrRes(strRes + "\r\n " + num + " es mayor que el numero secreto");
      }else if(num < rand){
        setstrRes(strRes + "\r\n " + num + " es menor que el numero secreto");
      }else{
        setstrRes("Buena crack has ganado el numero era: " + rand);
      }
    }
  
    useEffect(() => {
      return () => {
        
      }
    }, [])
    const [rand, setRand] = useState(Math.floor(Math.random()*10));
  
    function nuevoRand(){
      setRand(Math.floor(Math.random()*10));
    }  
  
      let array = [0,1,2,3,4,5,6,7,8,9];
  
    return (
      <div className='container'>
        <h2>Acertar Numero</h2>
        <input type="number" ref={inputNum}/>
        <br/>
        <button className='button' onClick={() => apostar()}>Comprobar</button>
        <br/><br/><br/>
        {
          (num == rand)? <button className="button" onClick={() => nuevoRand()}>Reiniciar</button>: <p></p>
        }
        <br/>
        <p>{strRes}</p>
      </div>
    )
}

export default Practica24