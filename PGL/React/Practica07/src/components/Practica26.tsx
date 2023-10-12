import React, { useState,useEffect, useRef } from 'react'

type EstadoTimer = "iniciar" | "parar";
type Props = {}
type NumeroRef = {
  contador: number;
}

const Practica26 = (props: Props) => {
    const inputNumber = useRef<HTMLInputElement>({} as HTMLInputElement);
    let intervalRef = useRef<ReturnType<typeof setInterval>>();
    const [pruebaState, setpruebaState] = useState(100);
    const numeroRef = useRef({contador: 200} as NumeroRef);
    const [iniciarparar,setiniciarparar ] = useState<boolean>(false);

  function tick(){
    console.log("yepa");

    numeroRef.current.contador--;
    if(numeroRef.current.contador ==0){
      clearInterval(intervalRef.current);
      alert("Acabó");   
    }else{
      setpruebaState(numeroRef.current.contador); 
    }
    
  }
 
 function iniciar(){
    if( iniciarparar == false){
      const contadorParaAlcanzar = Number(inputNumber.current.value);
      numeroRef.current.contador = contadorParaAlcanzar;
      
      inputNumber.current.value=""+0;    
      intervalRef.current = setInterval( tick,1000);
      
    }else{
      clearInterval(intervalRef.current);  
    }
    setiniciarparar(!iniciarparar);

 }

  return (
    <>
      <h3>Prueba timer</h3>
      
      
      <button onClick={iniciar}> {!iniciarparar?"iniciar":"parar"}</button>
      <input type="text" ref={inputNumber}  />
      <p>{pruebaState}</p>
    </>
  )
}

export default Practica26