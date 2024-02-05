import { Component } from '@angular/core';
import { RouterLink, RouterModule, RouterOutlet } from '@angular/router';
import { CommonModule, JsonPipe } from '@angular/common';
import { ViewTasksComponent } from './view-tasks/view-tasks.component';
import { AddTaskComponent } from './add-task/add-task.component';

@Component({
    selector: 'app-root',
    standalone: true,
    imports: [RouterOutlet, CommonModule, ViewTasksComponent, AddTaskComponent, RouterModule, RouterLink],
    templateUrl: './app.component.html',
    styleUrl: './app.component.css'
})
export class AppComponent {
    title = 'segundoProyAngular';
}
