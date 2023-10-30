import axios from 'axios';
import React, { useEffect } from 'react';
import { useState } from 'react';
import { useParams } from 'react-router-dom';

type Props = {}

type Iprops = {
    url: string
}

interface Capitales {
  id: string;
  nombre: string;
  datos: Dato[];
  foto: string;
}

interface Dato {
  anio: number;
  poblacion: number;
}

const CapitalCard = (props: Iprops) => {
    const [cardData, setCardData] = useState<Capitales>({} as Capitales);

    const { id } = useParams();
    const uri: string = props.url + "" + id;
    console.log(uri);
    

    useEffect(() => {
        async function getCapitalCard(direccion:string) {

            const response = await axios.get(direccion);
            const newCard: Capitales = {
                id: response.data.id,
                nombre: response.data.nombre,
                datos: response.data.datos,
                foto: response.data.foto
            }
            setCardData(newCard);
        }
        
        getCapitalCard(uri);
    }, [])
    

    return (
        <div className='container'>
            <h3>{cardData.id}</h3>
            <p>Titulo: {cardData.nombre}</p>
            <p>
                datos: {cardData.datos.map((value,index) =>{
                    return <ul><li>{value.anio}</li><li>{value.poblacion}</li></ul>
                    
                })}
            </p>
            <br/>
            <span>
                <img src={"http://localhost:3000/"+cardData.foto}/>
            </span>
        </div>
    )
}

export default CapitalCard