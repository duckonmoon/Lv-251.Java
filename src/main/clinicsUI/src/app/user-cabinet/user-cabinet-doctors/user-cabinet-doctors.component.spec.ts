import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UserCabinetDoctorsComponent } from './user-cabinet-doctors.component';

describe('UserCabinetDoctorsComponent', () => {
  let component: UserCabinetDoctorsComponent;
  let fixture: ComponentFixture<UserCabinetDoctorsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UserCabinetDoctorsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UserCabinetDoctorsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
