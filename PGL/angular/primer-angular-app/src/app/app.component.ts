import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { TablaComponent } from './tabla/tabla.component';
import { CommonModule } from '@angular/common';
import { FormExampleComponent } from './form-example/form-example.component';
import { PiedraPapelTijeraComponent } from './piedra-papel-tijera/piedra-papel-tijera.component';

@Component({
    selector: 'app-root',
    standalone: true,
    imports: [RouterOutlet, TablaComponent, CommonModule, FormExampleComponent, PiedraPapelTijeraComponent],
    templateUrl: './app.component.html',
    styleUrl: './app.component.css'
})

export class AppComponent {
    title = 'primer-angular-app';
    resTabla = "";

    array = [1,2,3,4,5,6,7,8,9,10];
}
