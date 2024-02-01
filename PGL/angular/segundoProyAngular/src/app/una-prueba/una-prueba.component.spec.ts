import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UnaPruebaComponent } from './una-prueba.component';

describe('UnaPruebaComponent', () => {
  let component: UnaPruebaComponent;
  let fixture: ComponentFixture<UnaPruebaComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [UnaPruebaComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(UnaPruebaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
