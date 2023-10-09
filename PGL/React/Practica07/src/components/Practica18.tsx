import React, { useEffect, useState } from 'react';
import '../index.css';

type Props = {}

const Preactica18 = (props: Props) => {
    useEffect(() => {
        document.title = `You clicked ${count} times`;
    }, [])
    const [count, setcount] = useState(0);

  return (
    <div className='container'>
        <p>You clicked {count} times</p>
        <button onClick={() => setcount(count+1)}>
            Click Me
        </button>
    </div>
  )
}

export default Preactica18