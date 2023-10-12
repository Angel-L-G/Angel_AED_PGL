import React, { useEffect, useRef, useState } from 'react'

type Props = {}

function Practica31({ }: Props) {
    let intervalRef = useRef<ReturnType<typeof setInterval>>();
    const [segs, setSegs] = useState<number>(0);
    const [show, setShow] = useState<boolean>(true)

    const [next, setNext] = useState<number>(0);
    const [array, setArr] = useState<Array<number>>([]);
    const [tries, setTries] = useState<number>(0);

    useEffect(() => {
      let arrDesor = [0, 1, 2, 3, 4, 5, 6, 7];
      arrDesor.sort(() => Math.random() - 0.5);
      let aux = [];
      
      for (let i = 0; i < 8; i++) {
        aux[i] = arrDesor[i];
      }
      setArr(aux);
    }, [])
  
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
      if(segs < 3000){
        console.log(segs);
        setSegs(segs + 1);
      }else{
        setShow(false);
      }
    }

    return (
      <div className='container'>
        {
          array.map((valor, index) => {
            return (    
              (valor < next)
              ?<button className="button" name={"" + index} id={"" + index} onClick={() => descubrir(valor)}>{valor}</button>
              :<button className="button" name={"" + index} id={"" + index} onClick={() => descubrir(valor)}>-</button>
            )
          })
        }
        {
          (show)??<p>{array}</p>
        }
        <p>Next: {next}</p>
        <p className='highlight'>Has Usado: {tries} Intentos</p>
      </div>
    )
}

export default Practica31