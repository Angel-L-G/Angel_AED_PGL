async function escribirFichero (nombreFichero,res){
    const fs = require('fs');

    fs.writeFile(
        nombreFichero, //nombre del fichero
        res, //información a guardar
        (err) => { //callback respuesta al finalizar
            if (err)
                console.log("no se ha grabado");
            else
                console.log("se ha grabado");
        }
    );
}

exports.escribir = escribirFichero;