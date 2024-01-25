import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
    selector: 'app-form-example',
    standalone: true,
    imports: [ReactiveFormsModule],
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
        /*let a = this.personaFormData.value.edad;
        let i = parseInt(a);

        new Gato(
            ,
            this.personaFormData.value.nombre,
            this.personaFormData.value.peso,
            this.edadConvertida
        );*/
    }

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
        public edad: number=0,
        public nombre: string="misifu",
        public peso: number=40,
        public edadHumana: string= "1 año",
    ){}
}
