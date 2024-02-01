import { Component, Inject, inject } from '@angular/core';
import { TaskServiceService } from '../task-service.service';
import { FormControl, FormGroup, FormsModule, ReactiveFormsModule } from '@angular/forms';
import { ToDo } from '../ToD';

@Component({
    selector: 'app-add-task',
    standalone: true,
    imports: [ReactiveFormsModule, FormsModule],
    templateUrl: './add-task.component.html',
    styleUrl: './add-task.component.css'
})
export class AddTaskComponent {

    taskService: TaskServiceService = inject(TaskServiceService);
    constructor() { }

    formData = new FormGroup({
        txt: new FormControl('')
    });

    enviarFormulario(){
        /*t: ToDo = new ToDo({
            id: 0,
            subject: this.formData.value.txt,
            terminado: false
        });*/
    }

}
