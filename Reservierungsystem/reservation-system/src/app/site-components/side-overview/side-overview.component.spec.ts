import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SideOverviewComponent } from './side-overview.component';

describe('SideOverviewComponent', () => {
  let component: SideOverviewComponent;
  let fixture: ComponentFixture<SideOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SideOverviewComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SideOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
