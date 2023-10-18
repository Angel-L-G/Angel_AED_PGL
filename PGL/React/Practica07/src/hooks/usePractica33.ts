import React, { useState } from 'react'

const usePractica33 = () => {
    const [listaPrimos, setListaPrimos] = useState<Array<Number>>([]);

    function processForm(evt: React.FormEvent<HTMLFormElement>){
        evt.preventDefault();

        let form = evt.currentTarget;
        let mayor = Number(form.mayor.value);
        let menor = Number(form.menor.value);
        
        let arrAux= [];

        for (let i = menor; i < mayor; i++) {
            let isPrimo:boolean = true;
            
            for (let j = 2; j < i; j++) {
                if(i % j === 0){
                    isPrimo = false;
                    break;
                }
            }
            
            if(isPrimo){
                arrAux.push(i);
            }
        }

        setListaPrimos(arrAux);
    }

    return {
        listaPrimos,
        processForm
    }
}

export default usePractica33