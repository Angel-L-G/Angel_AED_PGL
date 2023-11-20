import React from 'react'
import UseCategoria from '../hooks/UseCategoria'
import UsePeliculaCard from '../hooks/UsePeliculaCard';
import UseFindAllPeli from '../hooks/UseFindAllPeli';

type Props = {}

const CategoryShow = (props: Props) => {
    let {categorias, createCategory} = UseCategoria();
    let {peliculas} = UseFindAllPeli();

    return (
        <div>
            {
                categorias.map(c => {
                    return <a href={'/categorias/'+c.nombre}><p>{c.nombre}</p></a>
                })
            }

            <form method="post" onSubmit={createCategory}>
                <label htmlFor="nombre">Nombre: </label>
                <input type="text" name="nombre" id="nombre" required/>
                <input type="submit" value="enviar" />
            </form>
        </div>
    )
}

export default CategoryShow