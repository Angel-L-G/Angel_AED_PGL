export type Pelicula = {
    id: string,
    titulo: string,
    direccion: string,
    actores: string,
    argumento: string,
    imagen: string,
    trailer: string,
    categorias: Categoria[]
}

export type Categoria = {
    id: string,
    nombre: string
}