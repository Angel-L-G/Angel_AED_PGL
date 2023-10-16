import React, { useState } from 'react'

type Props = {}
type Producto = {
    nombre: string,
    precio: number,
    cantidad: number
}

const Practica32 = (props: Props) => {


  return (
    <div className='container'></div>
  )
}

//export default Practica32;

export default function FormularioProductos(props: Props){
    const [listaProductos, setListaProductos] = useState<Array<Producto>>([])

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

        return (
            <div className='container'>
                <h3>Info Productos</h3>
                <form onSubmit={procesarFormulario}>
                    <label htmlFor="nombreid">Nombre</label>
                    <input type="text" name="nombre" id="nombre" />
                    <label htmlFor="precioid">Precio</label>
                    <input type="text" name="precio" id="precio" />
                    <label htmlFor="cantidadid">Cantidad</label>
                    <input type="text" name="cantidad" id="cantidad" />
                    <button className='button'>Agregar</button>
                </form>
                <textarea value={JSON.stringify(listaProductos,null,2)} cols={100} rows={30}/>
            </div>
        )
    }
}