/*let arr = [];

arr[2] = "adios"; arr[7] = "Hola";

arr.map( (value)=> console.log("dato: " + value))

for (const dato of arr) {
    console.log(dato);
}

let conjunto = new Set;

conjunto.add("a");
conjunto.add(1);
conjunto.add("b"+2);
conjunto.add("b"+2);
conjunto.add("b"+2);
conjunto.add(1);

for (const dato of conjunto) {
    console.log(dato);
}

let miObjeto = {
    nombre: "Rivaldo",
    edad: 23
}

console.log(miObjeto);

let nuevoObjeto = {
    ...miObjeto,
    edad: 34,
    apellido: "Hernandez"
}

console.log(nuevoObjeto);

let arr = [];*/


function miFuncion(dato){
    console.log("dato: " + dato)
}

let unaVariableFunction = miFuncion;
unaVariableFunction(5);

let miFunc = (dato1,dato2) => dato1*dato2;

console.log(miFunc(2,3));