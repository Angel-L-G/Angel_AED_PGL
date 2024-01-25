import { Component, Input } from '@angular/core';
import { AppComponent } from '../app.component';

@Component({
  selector: 'app-tabla',
  standalone: true,
  imports: [
    AppComponent
  ],
  templateUrl: './tabla.component.html',
  styleUrl: './tabla.component.css'
})
export class TablaComponent {
  @Input() tabla: number = -1;
  multiplicador = 1;

  calcular(){
    if(this.multiplicador > 9){
      this.multiplicador = 1;
    }else {
      this.multiplicador++;
    }
  }

}
