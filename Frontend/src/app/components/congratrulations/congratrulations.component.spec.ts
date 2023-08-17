import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CongratrulationsComponent } from './congratrulations.component';

describe('CongratrulationsComponent', () => {
  let component: CongratrulationsComponent;
  let fixture: ComponentFixture<CongratrulationsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CongratrulationsComponent]
    });
    fixture = TestBed.createComponent(CongratrulationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
