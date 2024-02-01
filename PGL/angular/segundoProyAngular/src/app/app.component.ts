import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule, JsonPipe } from '@angular/common';
import { UnaPruebaComponent } from './una-prueba/una-prueba.component';
import { ViewTasksComponent } from './view-tasks/view-tasks.component';
import { AddTaskComponent } from './add-task/add-task.component';

@Component({
    selector: 'app-root',
    standalone: true,
    imports: [RouterOutlet, CommonModule, UnaPruebaComponent, ViewTasksComponent, AddTaskComponent],
    templateUrl: './app.component.html',
    styleUrl: './app.component.css'
})
export class AppComponent {
    title = 'segundoProyAngular';
}
