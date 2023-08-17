import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CheckINComponent } from './check-in.component';

describe('CheckINComponent', () => {
  let component: CheckINComponent;
  let fixture: ComponentFixture<CheckINComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [CheckINComponent]
    });
    fixture = TestBed.createComponent(CheckINComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
