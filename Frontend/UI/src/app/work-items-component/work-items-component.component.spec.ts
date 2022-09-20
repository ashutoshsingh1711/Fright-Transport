import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WorkItemsComponentComponent } from './work-items-component.component';

describe('WorkItemsComponentComponent', () => {
  let component: WorkItemsComponentComponent;
  let fixture: ComponentFixture<WorkItemsComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WorkItemsComponentComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WorkItemsComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
