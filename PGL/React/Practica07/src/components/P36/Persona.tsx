class Persona{
    id: Number = 0;
    nombre: String = "";
    apellido: String = "";
    altura: number = 0; 
    edad: number = 0;
    peso: number = 0;
    imc: number = 0;

    construct(i: Number, n: String, ap: String, al: number, e: number, p: number) {
        this.id = i ?? 0;
        this.nombre = n ?? "";
        this.apellido = ap ?? "";
        this.altura = al ?? 0;
        this.edad = e ?? 0;
        this.peso = p ?? 0;
    }

    calculateImc() {
        //Peso (kg) / (Altura (m) * Altura (m))
       this.imc = this.peso/(this.altura*this.altura);
        
    }
}

export {Persona}