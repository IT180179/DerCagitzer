import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DayviewPageComponent } from './dayview-page.component';

describe('DayviewPageComponent', () => {
  let component: DayviewPageComponent;
  let fixture: ComponentFixture<DayviewPageComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DayviewPageComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DayviewPageComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
