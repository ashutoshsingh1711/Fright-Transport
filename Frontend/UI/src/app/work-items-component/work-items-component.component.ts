import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';
import { WorkItemService } from '../work-item.service';
import { WorkItems } from './WorkItems';

@Component({
  selector: 'app-work-items-component',
  templateUrl: './work-items-component.component.html',
  styleUrls: ['./work-items-component.component.css'],
})
export class WorkItemsComponentComponent implements OnInit {
  workItems!: WorkItems[];
  errorMessage!: string;
  filteredWorkItems!: WorkItems[];
  isAdd: boolean = false;
  isEdit: boolean = false;
  editWorkItem!: WorkItems;
  displayedColumns: string[] = [
    'workItemId',
    'itemName',
    'itemType',
    'itemDescription',
    'messageToRecipient',
    'quantity',
    'sourceCountry',
    'destinationCountry',
    'originHarborLocation',
    'selectedHarborLocations',
    'shippingDate',
    'amount',
    'editButton',
  ];

  constructor(private workItemsService: WorkItemService) {}

  dataSource = new MatTableDataSource(this.filteredWorkItems);

  ngOnInit(): void {
    this.getWorkItems();
    this.isEdit = false;
    this.isAdd = false;
  }

  applyFilter(event: Event) {
    this.workItemsService
      .getSpecificWorkItems((event.target as HTMLInputElement).value)
      .subscribe({
        next: (filteredWorkItems) =>
          (this.filteredWorkItems = filteredWorkItems),
        error: (error) => (this.errorMessage = <any>error),
      });
  }

  getWorkItems() {
    this.workItemsService.getWorkItems().subscribe({
      next: (workItems) => (this.workItems = workItems),
      error: (error) => (this.errorMessage = <any>error),
    });
  }

  addWorkItem(workItems: WorkItems): void {
    console.log('In add work items', JSON.stringify(workItems));
    this.workItemsService.addWorkItems(workItems).subscribe({
      next: (workItem: any) => {
        this.workItems.push(workItem);
        this.isAdd = false;
        this.getWorkItems();
      },
      error: (error: any) => {
        this.getWorkItems();
        this.isAdd = false;
      },
    });
  }

  editWorkItemFun(edittedWorkItem: WorkItems) {
    console.log('In Work Component' + JSON.stringify(edittedWorkItem));
    this.workItemsService.editWorkItems(edittedWorkItem).subscribe({
      next: (workItem: any) => {
        this.workItems.push(workItem);
        this.isAdd = false;
        this.isEdit = false;
        this.getWorkItems();
      },
      error: (error: any) => {
        this.getWorkItems();
        this.isAdd = false;
        this.isEdit = false;
      },
    });
  }
}
