import React, { useState } from 'react'
import Practica14 from './Practica14';
import { userInfo } from 'os';

type Props = {
  userInput: any
}

const Practica17 = (props: Props) => {
  const str: string = "";

  return (
    <div className='container'>
      {(typeof str == typeof props.userInput)?<Letras userInput={props.userInput} />: <Practica14/>}
    </div>
  )
}

const Letras = (props: Props) => {
  return (
    <>
      <h2>La Cadena Tiene: </h2>
      <p className='p'>{props.userInput.length}</p>
    </>
  )
}

export default Practica17