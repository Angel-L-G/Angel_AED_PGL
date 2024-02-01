import { Component, Input } from '@angular/core';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';

@Component({
    selector: 'app-una-prueba',
    standalone: true,
    imports: [ReactiveFormsModule, FormsModule],
    templateUrl: './una-prueba.component.html',
    styleUrl: './una-prueba.component.css'
})
export class UnaPruebaComponent {
    @Input() nombre: string = "ABC";
    mostrar: boolean = false;

    formData = new FormGroup({
        txt: new FormControl('')
    });

    enviarFormulario(){
        alert(this.formData.value.txt);
    }

    cambiarBool(){
        this.mostrar = !this.mostrar;
    }

    alertar(text: string){
        alert(text);
    }
}
