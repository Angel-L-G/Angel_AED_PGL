const {escribir} = require("./utils/manejoFichero");
const {crearTabla} = require("./modelo/tabla");

console.log(escribir("./tabla.txt",crearTabla(process.argv[2]) )
    .then(dato => console.log(dato))
    .catch(err=> console.log(err)));