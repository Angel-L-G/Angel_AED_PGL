import React from 'react'

type Props = {}

const Practica33 = (props: Props) => {
    function processForm(){

    }

    return (
        <div className='container'>
            <form action="" method="post">
                <label>Primo Mayor</label>
                <input type="text"/>
                <br/>
                <label>Primo Menor</label>
                <input type="text"/>
                <br/>
                <button>Send</button>
            </form>
        </div>
    )
}

export default Practica33