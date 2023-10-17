import React, { useEffect, useRef, useState } from 'react'

type Props = {}

type NumRef = {
  contador: number;
}

function Practica31({ }: Props) {
    let intervalRef = useRef<ReturnType<typeof setInterval>>();
    const numRef = useRef({contador: 0} as NumRef)
    const [counter, setCounter] = useState<number>(0);
    const [show, setShow] = useState<boolean>(true);

    const [next, setNext] = useState<number>(0);
    const [winnedTimes, setWinnedTimes] = useState<number>(0);
    const [array, setArr] = useState<Array<number>>([]);
    const [tries, setTries] = useState<number>(0);

    useEffect(() => {
      let arrDesor = [0, 1, 2, 3, 4, 5, 6, 7];
      arrDesor.sort(() => Math.random() - 0.5);
      let aux = [];
      
      aux = [...arrDesor];

      const timerID = setInterval(
        tick,
        1000
      );
      setArr(aux);
      setNext(0);

      numRef.current.contador = 0;

      if(next == 8){
        setWinnedTimes(winnedTimes + 1);
      }
    }, [next == 8])
  
    function descubrir(id: number) {
      setTries(tries + 1);
      if(next===id){
        setNext(next + 1);
        
      }else if(next <= 7){
        intervalRef.current = setInterval(tick ,3000);
        setNext(0);
        
      }else{
        console.log("fallo");
      }
      
    }

    function tick(){
      numRef.current.contador++;
      setCounter(numRef.current.contador);
    }

    return (
      <div className='container'>
        <div className='grid'>
        {
          array.map((valor, index) => {
            return (  
              (numRef.current.contador < 3)//True Se muestra
              ?<button className="button" name={"" + index} id={"" + index} onClick={() => descubrir(valor)}>{valor}</button>  
              :(valor < next)//True Se muestra
                ?<button className="button" name={"" + index} id={"" + index} onClick={() => descubrir(valor)}>{valor}</button>
                :<button className="button" name={"" + index} id={"" + index} onClick={() => descubrir(valor)}>-</button>
            )
          })
        }
        </div>
        {
          (show)??<p>{array}</p>
        }
        <p>Next: {next}</p>
        <p className='highlight'>Has Usado: {tries} Intentos</p>
        <p>Has Ganado: {winnedTimes} Veces Crack</p>
      </div>
    )
}

export default Practica31