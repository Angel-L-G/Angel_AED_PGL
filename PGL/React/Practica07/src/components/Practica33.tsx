import React, { useState } from 'react'

type Props = {}

const Practica33 = (props: Props) => {
    const [listaPrimos, setListaPrimos] = useState([]);

    function processForm(evt: React.FormEvent<HTMLFormElement>){
        evt.preventDefault();

        let form = evt.currentTarget;
        let mayor = Number(form.mayor.value);
        let menor = Number(form.menor.value);
        
        let arrAux = [];

        for (let i = menor; i < mayor; i++) {
            let isPrimo:boolean = true;
            
            for (let j = 2; j < i; j++) {
                if(!(i % j === 0)){
                    isPrimo = true
                    break;
                }
            }
            
            if(isPrimo){
                arrAux.push(i);
            }
        }

    }

    return (
        <div className='container'>
            <form onSubmit={processForm}>
                <label>Primo Mayor</label>
                <input type="text" id="mayor"/>
                <br/>
                <label>Primo Menor</label>
                <input type="text" id="menor"/>
                <br/>
                <button>Send</button>
            </form>
        </div>
    )
}

export default Practica33