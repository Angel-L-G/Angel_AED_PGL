import React from 'react'

type Props = {
    num1?: number
    num2?: number
}

const Componente = (props: Props) => {
    const num1 = props.num1 ?? 0;
    const num2 = props.num2 ?? 0;
    const suma = num1+num2;
    return (
        <div>
            num1: {props.num1} + num2: {props.num2} = {suma};
        </div>
    )
}

export default Componente