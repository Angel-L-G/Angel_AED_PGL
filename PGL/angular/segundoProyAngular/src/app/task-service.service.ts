import { Injectable } from '@angular/core';
import { ToDo } from './ToD';

@Injectable({
    providedIn: 'root'
})

export class TaskServiceService {
    constructor() {

        this.toDos.push(new ToDo(1,"First"));
        this.toDos.push(new ToDo(2,"Second"))
        this.toDos.push(new ToDo(3,"third"));
    }

    toDos: Array<ToDo> = [

    ];

    getAll(){
        return this.toDos;
    }

    add(td: ToDo){
        this.toDos.push(td);
    }
}
