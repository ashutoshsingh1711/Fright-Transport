import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddWorkItemsComponent } from './add-work-items.component';

describe('AddWorkItemsComponent', () => {
  let component: AddWorkItemsComponent;
  let fixture: ComponentFixture<AddWorkItemsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddWorkItemsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AddWorkItemsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
