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

const ApiUpdate = (props: Props) => {
    function UpdateApi(event: React.FormEvent<HTMLFormElement>) {
        event.preventDefault();
        let formulario: HTMLFormElement = event.currentTarget;

        let inputpais: HTMLInputElement = formulario.pais;
        let inputpaisanio: HTMLInputElement = formulario.paisanio;
        let inputpaispob: HTMLInputElement = formulario.paispob;
        let inputpaisfot: HTMLInputElement = formulario.paisfot;

        let pais: string = inputpais.value;
        let anio: number = Number(inputpaisanio.value);
        let pob: number = Number(inputpaispob.value);
        let foto: string = inputpaisfot.value;

        const newPais: Capitale = {
            "id": pais,
            "nombre": pais,
            "datos": [{
                "anio": anio,
                "poblacion": pob
            }],
            "foto": foto
        }

        let ruta = "http://localhost:3000/capitales/";

        const axiosput = async (rutaDeMoneda: string) => {
            try {
                const response = await axios.put(rutaDeMoneda+newPais.id, newPais)
                console.log(response.data);
            } catch (error) {
                console.log(error);
            }
        }

        axiosput(ruta);
    }
    return (
        <div>
            <form onSubmit={UpdateApi}>
                País: <input type="text" id="pais" /> <br />
                Año: <input type="text" id="paisanio" />
                Poblacion: <input type="text" id="paispob" />
                Foto: <input type="text" id="paisfot" />
                <button type="submit">Actualizar </button>
            </form>
        </div>
    )
}

export default ApiUpdate