import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EditWorkItemsComponent } from './edit-work-items.component';

describe('EditWorkItemsComponent', () => {
  let component: EditWorkItemsComponent;
  let fixture: ComponentFixture<EditWorkItemsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EditWorkItemsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EditWorkItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
