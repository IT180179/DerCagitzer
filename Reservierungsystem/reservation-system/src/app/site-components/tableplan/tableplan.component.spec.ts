import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TableplanComponent } from './tableplan.component';

describe('TableplanComponent', () => {
  let component: TableplanComponent;
  let fixture: ComponentFixture<TableplanComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TableplanComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TableplanComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
