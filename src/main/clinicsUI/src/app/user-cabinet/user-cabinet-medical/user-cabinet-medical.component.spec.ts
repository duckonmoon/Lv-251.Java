import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserCabinetMedicalComponent } from './user-cabinet-medical.component';

describe('UserCabinetMedicalComponent', () => {
  let component: UserCabinetMedicalComponent;
  let fixture: ComponentFixture<UserCabinetMedicalComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserCabinetMedicalComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserCabinetMedicalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
