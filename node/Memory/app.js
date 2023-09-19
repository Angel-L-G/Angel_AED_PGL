const DOM={
    grid: document.getElementById("grid"),

}

let nivel = 3;

function crearCasillas(){
    for (let index = 0; index < Math.pow(nivel); index++) {
        let casilla = document.createElement("button");
        casilla.classList.add("botonNoVisible");
        DOM.grid.appendChild(casilla);
    }
    nivel += 1;
}

function reveal(evt){
    let casilla = evt.target();
    casilla.classList.remove("botonNoVisible");
    casilla.classList.add("botonVisible");
}

/*document.createElement();

function unaFuncion(evt){
    evt.
}*/