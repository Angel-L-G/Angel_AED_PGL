import React, { useRef } from 'react'

type Props = {}

type Complejo = {
    real: number,
    imag: number

}

const Practica23 = (props: Props) => {
    const inputNombre = useRef<HTMLInputElement>({} as HTMLInputElement);
    const inputApellido = useRef<HTMLInputElement>({} as HTMLInputElement);
    const pRes = useRef<HTMLParagraphElement>({} as HTMLParagraphElement);

    function tomar(){
        let inputNombreObj = inputNombre.current;
        let inputApellidoObj = inputApellido.current;
        let pResObj = pRes.current;

        pResObj.innerText = "" + (inputNombreObj.value + "" + inputApellidoObj.value).length
    }

    return (
        <div className='container'>
            <label>Nombre</label>
            <input type="text" ref={inputNombre}/>
            <br/>
            <label>Apellidos</label>
            <input type="text" ref={inputApellido}/>
            <p ref={pRes}></p>
            <button className='button' onClick={() => tomar()}>Enviar</button>
        </div>
    )
}

export default Practica23