import { Routes } from '@angular/router';
import { ViewTasksComponent } from './view-tasks/view-tasks.component';
import { AddTaskComponent } from './add-task/add-task.component';

export const routes: Routes = [
  {
    path: '',
    redirectTo: 'seeTasks',
    pathMatch: 'full'
  },

  {
    path: 'seeTasks',
    component: ViewTasksComponent,
    pathMatch: 'full'
  },

  {
    path: 'addTasks',
    component: AddTaskComponent,
    pathMatch: 'full'
  },
];
