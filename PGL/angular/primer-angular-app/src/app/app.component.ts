import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';

@Component({
    selector: 'app-root',
    standalone: true,
    imports: [RouterOutlet],
    templateUrl: './app.component.html',
    styleUrl: './app.component.css'
})

export class AppComponent {
    title = 'primer-angular-app';
    resTabla = "";

    unMetodo(num: number) {
        let tabla = "";

        for (let i = 0; i <= 10; i++) {
            tabla += i+" * "+num+" = "+ (i*num)+"\n";
        }

        this.resTabla = tabla;
    }
}

export class EjemploTemplatesComponent{
    array = [
        {
            id: 1,
            nombre: "Juanma"
        },
        {
            id: 2,
            nombre: "Javier"
        },
        {
            id: 3,
            nombre: "Patricia"
        },
    ];
}
