const DOM={
    container: document.getElementById("grid"),
}

let nivel = 3;

function crearCasillas(){
    container.innerHTML = "";
    generateArray();
    container.setAttribute('style',`grid-template-rows: repeat(${nivel},2rem); grid-template-columns: repeat(${nivel},2rem);`);
    for (let index = 0; index < Math.pow(nivel,2); index++) {
        let casilla = document.createElement("div");
        casilla.classList.add("botonNoVisible");
        casilla.innerText = (array[index]);
        casilla.onclick = reveal;
        container.appendChild(casilla);
    }
}

let array = [];

function generateArray(){
    
    let j = parseInt(Math.trunc(Math.pow(nivel,2))/2);
    for (let i = 0; i < j; i++) {
        array[i] = i+1;
    }

    let array2 = array.slice();

    if(array2.length){
        array.push(j+1);
    }

    array = array.concat(array2);

    array.sort(function() { return Math.random() - 0.5 });
    console.log(array);
}

let pair = 0;
let first = null;
let second = null;
let counter = 0;

function reveal(evt){

    if(counter == parseInt(Math.pow(nivel,2)/2)){
        counter++;
    }

    if(pair==2){
        first.classList.replace("botonVisible","botonNoVisible");
        //first.classList.add("botonNoVisible");
        //first.classList.remove("botonVisible");

        second.classList.replace("botonVisible","botonNoVisible");
        //second.classList.add("botonNoVisible");
        //second.classList.remove("botonVisible");

        pair = 0;
    }
    

    let casilla = evt.target;
    //casilla.classList.replace("botonNoVisible","botonVisible");
    casilla.classList.remove("botonNoVisible");
    casilla.classList.add("botonVisible");

    console.log(casilla.innerText);
    if(pair==1){
        pair = 0;

        if(first.innerText !== casilla.innerText){
            pair = 2;
            second = casilla;
        }else{
            counter++;
        }

    }else if(pair==0){
        pair = 1;
        first = casilla;
    }

    if(counter >= Math.pow(nivel,2)/2){
        alert("Muy Buena Crack, Subes De Nivel");
        nivel++;
        counter = 0;
        pair = 0;
        crearCasillas();
    }
}