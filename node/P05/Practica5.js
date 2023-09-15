const {escribir} = require("./utils/manejoFichero");
const {crearTabla} = require("./modelo/tabla");

escribir("tabla.txt",crearTabla(7) )
    //.then(console.log("Ok Grabado"))
    //.catch(err=> console.log(err));