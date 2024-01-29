import { Component } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
    selector: 'app-form-example',
    standalone: true,
    imports: [ReactiveFormsModule, FormsModule],
    templateUrl: './form-example.component.html',
    styleUrl: './form-example.component.css'
})
export class FormExampleComponent {
    edadConvertida = "";
    personaFormData = new FormGroup({
        nombre: new FormControl(''),
        peso: new FormControl(''),
        edad: new FormControl(''),
    });

    enviarFormulario(){
        this.calcular(this.personaFormData.value.edad);
        let g = new Gato();
        g.nombre = this.personaFormData.value.nombre ?? "";
        g.edad = this.personaFormData.value.edad ?? "";
        g.peso = Number(this.personaFormData.value.peso) ?? 10;
        g.edadHumana = this.edadConvertida;
    }


    /*edad1: any;
    nombre1: any;

    procesarForm(ape: any, peso: any){
        alert("los datos son: " + this.edad1 + " y el nombre: " + this.nombre1 + " apellidos: " + ape + " peso "+peso);
    }*/

    calcular(strEdad: any){
        switch (strEdad) {
            case "1":
                this.edadConvertida = "1 año"
                break;
            case "2":
            case "3":
                this.edadConvertida = "3 años"
                break;
            case "4":
                this.edadConvertida = "7 años"
                break;
            case "5":
                this.edadConvertida = "8 años"
                break;
            case "6":
                this.edadConvertida = "10 años"
                break;
            default:
                break;
        }
    }
}

export class Gato{
    constructor(
        public edad: string="0",
        public nombre: string="misifu",
        public peso: number=40,
        public edadHumana: string= "1 año",
    ){}
}
