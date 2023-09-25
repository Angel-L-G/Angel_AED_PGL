const {escribir} = require("./utils/manejoFichero");
const {crearTabla} = require("./modelo/tabla");

console.log(escribir("tabla.txt",crearTabla(7) )
    .then(dato=> console.log(dato))
    .catch(err=> console.log(err)));