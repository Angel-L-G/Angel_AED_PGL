function getTabla(tabla){

    let lim = 10;
    let res = "";
    for(let i =1; i <= lim; i++){
        res += `${tabla} x ${i} = ${tabla*i} \n`;
    }
    return res;
}

console.log(getTabla(4));