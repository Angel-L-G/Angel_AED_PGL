const toBeGuessed= parseInt(Math.random() * 10);

function adivinar(num){
    console.log(toBeGuessed);
    let p = document.getElementById("res");
    if(num == toBeGuessed){
        window.alert("Acertaste, bien por ti.");
        window.location.reload();
    }else if(num > toBeGuessed){
        p.innerHTML += `</br>${num} es mayor que el numero oculto`;
    }else{
        p.innerHTML += `</br>${num} es menor que el numero oculto`;    
    }
}