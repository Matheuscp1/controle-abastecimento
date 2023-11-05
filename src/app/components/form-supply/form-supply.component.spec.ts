import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FormSupplyComponent } from './form-supply.component';

describe('FormSupplyComponent', () => {
  let component: FormSupplyComponent;
  let fixture: ComponentFixture<FormSupplyComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [FormSupplyComponent]
    });
    fixture = TestBed.createComponent(FormSupplyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
