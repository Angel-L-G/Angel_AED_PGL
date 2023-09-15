const yargs = require('yargs/yargs');
const {hideBin} = require('yargs/helpers');
const argv = yargs(hideBin(process.argv)).argv;

const {escribir} = require("./utils/manejoFichero");
const {crearTabla} = require("./modelo/tabla");

escribir("./tabla.txt",crearTabla(argv.tabla) )
    //.then(console.log("Ok Grabado"))
    //.catch(err=> console.log(err));


console.log(argv.tabla);

// Comando: node fich --nombreVar=Valor