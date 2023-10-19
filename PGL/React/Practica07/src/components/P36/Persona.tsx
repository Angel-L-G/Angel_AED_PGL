class Persona{
    id: number = 0;
    nombre: String = "";
    apellido: String = "";
    altura: number = 0; 
    edad: number = 0;
    peso: number = 0;
    imc: number = 0;

    constructor(i: number, n: String, ap: String, al: number, e: number, p: number) {
        this.id = i;
        this.nombre = n;
        this.apellido = ap;
        this.altura = al;
        this.edad = e;
        this.peso = p;
        this.calculateImc;
    }

    calculateImc() {
        //Peso (kg) / (Altura (m) * Altura (m))
       this.imc = this.peso/(this.altura*this.altura);
        
    }
}

export {Persona}