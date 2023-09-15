const DOM ={
    num1: document.getElementById("num1"),
    num2: document.getElementById("num2"),
    oper: document.getElementById("oper"),
    result: document.querySelector(".resultado")
}

function calcular(){
    let numero1 = number(DOM.num1.value);
    let numero2 = number(DOM.num2.value);
    let operacion = DOM.oper.value;

    let res = "";

    switch (operacion) {
        case "+":
            res = numero1 + "+" + numero2 + "=" + (numero1+numero2);
            break;
        case "-":
            res = numero1 + "-" + numero2 + "=" + (numero1-numero2);
            break;
        case "*":
            res = numero1 + "*" + numero2 + "=" + (numero1*numero2);
            break;
        case "/":
            res = numero1 + "/" + numero2 + "=" + (numero1/numero2);
            break;
        default:
            break;
    }
    
    DOM.result.innerHTML += res;

}