import React from 'react'
import axios from 'axios';

type Props = {}

interface Capitale {
    id: string;
    nombre: string;
    datos: Dato[];
    foto: string;
}

interface Dato {
    anio: number;
    poblacion: number;
}

const ApiDelete = (props: Props) => {
    function DeleteApi(event: React.FormEvent<HTMLFormElement>) {
        event.preventDefault();
        let formulario: HTMLFormElement = event.currentTarget;

        let inputpais: HTMLInputElement = formulario.pais;

        let id: string = inputpais.value;

        let ruta = "http://localhost:3000/capitales/";

        const axiosDelete = async (rutaDeMoneda: string) => {
            try {
                const response = await axios.delete(rutaDeMoneda+id)
                console.log(response.data);
            } catch (error) {
                console.log(error);
            }
        }

        axiosDelete(ruta);
    }
    return (
        <div>
            <form onSubmit={DeleteApi}>
                País: <input type="text" id="pais" /> <br />
                <button type="submit">Eliminar </button>
            </form>
        </div>
    )
}

export default ApiDelete