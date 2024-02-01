import { Injectable } from '@angular/core';

@Injectable({
    providedIn: 'root'
})

export class ToDo {
    constructor(
        public id: Number=0,
        public subject: string="Task",
        public terminado: boolean=true,
    ){}


}

export class TaskServiceService {

    constructor() { }
}
