import { Component } from '@angular/core';
import { AppComponent } from '../app.component';
import { CommonModule } from '@angular/common';

@Component({
    selector: 'app-piedra-papel-tijera',
    standalone: true,
    imports: [AppComponent, CommonModule],
    templateUrl: './piedra-papel-tijera.component.html',
    styleUrl: './piedra-papel-tijera.component.css'
})
export class PiedraPapelTijeraComponent {
    opciones = ["piedra", "papel", "tijeras"];
    opcion: any;
    resultado = "";
    finished = false;

    jugar(e: string){
        let op = Math.round(Math.random()*3);
        this.finished = true;
        switch (e) {
            case "tijeras":
                switch (this.opciones[op]) {
                    case "tijeras":
                        this.resultado = "Empate. La Maquina Utilizo: " + this.opciones[op];
                        break;
                    case "papel":
                        this.resultado = "Gano El Jugador, Bien Hecho. La Maquina Utilizo: " + this.opciones[op];
                        break;
                    case "piedra":
                        this.resultado = "Gano La Maquina, Que Tonto. La Maquina Utilizo: " + this.opciones[op];
                        break;
                    default:
                        break;
                }
                break;
            case "papel":
                switch (this.opciones[op]) {
                    case "tijeras":
                        this.resultado = "Gano La Maquina, Que Tonto. La Maquina Utilizo: " + this.opciones[op];
                        break;
                    case "papel":
                        this.resultado = "Empate. La Maquina Utilizo: " + this.opciones[op];
                        break;
                    case "piedra":
                        this.resultado = "Gano El Jugador, Bien Hecho. La Maquina Utilizo: " + this.opciones[op];
                        break;
                    default:
                        break;
                }
                break;
            case "piedra":
                switch (this.opciones[op]) {
                    case "tijeras":
                        this.resultado = "Gano El Jugador, Bien Hecho. La Maquina Utilizo: " + this.opciones[op];
                        break;
                    case "papel":
                        this.resultado = "Gano La Maquina, Que Tonto. La Maquina Utilizo: " + this.opciones[op];
                        break;
                    case "piedra":
                        this.resultado = "Empate. La Maquina Utilizo: " + this.opciones[op];
                        break;
                    default:
                        break;
                }
                break;
            default:
                break;
        }
    }

    reiniciar(){
        this.finished = false;
        this.opcion="";
        this.resultado="";
    }
}
