import React, { useState } from 'react'

type Props = {}

const Practica10 = (props: Props) => {
  const [numeros, setnumeros] = useState(0);
  Math.random();

  return (
    <div>Practica10</div>
  )
}

export default Practica10;