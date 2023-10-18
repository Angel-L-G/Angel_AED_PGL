import React, { useRef, useState } from 'react'

type Props = {}
type Producto = {
    nombre: string,
    precio: number,
    cantidad: number
}

export default function Practica32(props: Props){
    const [listaProductos, setListaProductos] = useState<Array<Producto>>([]);
    const [filteredList, setFilteredList] = useState<Array<Producto>>([]);
    const inputRef = useRef<HTMLInputElement>({} as HTMLInputElement);

    function procesarFormulario(e: React.FormEvent<HTMLFormElement>){
        e.preventDefault();
        let formulario = e.currentTarget;
        const nombre = formulario.nombre.value ?? "";
        const precio = Number(formulario.precioid.value ?? 0);
        const cantidad = Number(formulario.cantidad.value ?? 0);

        const producto: Producto = {
            nombre: nombre,
            precio: precio,
            cantidad: cantidad
        }

        setListaProductos([...listaProductos,producto]);
    }

    function navBar(){
        let inputVal = inputRef.current.value;
        let arrAux:Array<Producto> = [];
        let productosFiltrados = [];

        listaProductos.map((valor,index) =>{
            if(valor.nombre.startsWith(inputVal)){
                arrAux.push(valor);
            }
        });

        setFilteredList(arrAux);
    }

    return (
        <div className='container'>
            <h3>Info Productos</h3>
            <form onSubmit={procesarFormulario}>
                <label htmlFor="nombreid">Nombre</label>
                <input type="text" name="nombre" id="nombreid" />
                <label htmlFor="precioid">Precio</label>
                <input type="text" name="precio" id="precioid" />
                <label htmlFor="cantidadid">Cantidad</label>
                <input type="text" name="cantidad" id="cantidadid" />
                <button className='button'>Agregar</button>
            </form>
            <textarea value={JSON.stringify(listaProductos,null,2)} cols={100} rows={30}/>

            <br/><br/><br/>
            <input type="text" onChange={navBar} ref={inputRef}/><br/>
            <textarea value={JSON.stringify(filteredList,null,2)} cols={100} rows={30}/>
        </div>
    )
}