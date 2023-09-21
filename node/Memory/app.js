const DOM={
    container: document.getElementById("grid"),
}

let nivel = 3;

function crearCasillas(){
    container.innerHTML = "";
    generateArray();
    container.setAttribute('style',`grid-template-rows: repeat(${nivel},auto); grid-template-columns: repeat(${nivel},auto);`);
    for (let index = 0; index < Math.pow(nivel,2); index++) {
        let casilla = document.createElement("div");
        casilla.classList.add("botonNoVisible");
        if(array[index]){
            casilla.innerText = (array[index]);
        }else{
            casilla.innerText = (index+1);
        }
        casilla.onclick = reveal;
        container.appendChild(casilla);
    }
    nivel += 1;

    
}

let array = [];

function generateArray(){
    
    let j = parseInt(Math.trunc(Math.pow(nivel,2))/2);
    for (let i = 0; i < j; i++) {
        array[i] = i+1;
    }
    let array2 = array.slice();

    array = array.concat(array2);
    

    array.sort(function() { return Math.random() - 0.5 });
    console.log(array);
}

let pair = 0;
let last = null;
let counter = 0;

function reveal(evt){
    let casilla = evt.target;
    casilla.classList.remove("botonNoVisible");
    casilla.classList.add("botonVisible");

    console.log(casilla.innerText);
    if(pair==1){
        if(last.innerText !== casilla.innerText){
            casilla.classList.remove("botonVisible");
            casilla.classList.add("botonNoVisible");

            last.classList.remove("botonVisible");
            last.classList.add("botonNoVisible");

            last = null;
        }
        pair = 0;
    }else if(pair==0){
        pair = 1;
        last = casilla;
    }else{
        
    }
}