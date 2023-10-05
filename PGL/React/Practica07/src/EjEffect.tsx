import React, { useEffect, useState } from 'react'

type Props = {}

const EjEffect = (props: Props) => {
    const [color, setcolor] = useState(0);
    useEffect(() => {
      setcolor(-5);
    }, [Number(color) > 4])
    

  return (
    <div className='container'>
      <button className="button" onClick={() => setcolor(color+1)}>Pulsa</button>
      <p className='p'>{color}</p>
    </div>
  )
}

export default EjEffect