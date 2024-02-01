import { Component, OnInit } from '@angular/core';
import { TaskServiceService } from '../task-service.service';
import { ToDo } from '../ToD';
import { JsonPipe } from '@angular/common';

@Component({
    selector: 'app-view-tasks',
    standalone: true,
    imports: [JsonPipe],
    templateUrl: './view-tasks.component.html',
    styleUrl: './view-tasks.component.css'
})
export class ViewTasksComponent implements OnInit {

    toDos: Array<ToDo> = [];
    constructor(private taskService: TaskServiceService) { }

    ngOnInit(): void {
        this.toDos = this.taskService.getAll();
    }
}
