import { Component, EventEmitter, Input, Output, OnInit } from '@angular/core';
import { WorkItems } from '../work-items-component/WorkItems';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-edit-work-items',
  templateUrl: './edit-work-items.component.html',
  styleUrls: ['./edit-work-items.component.css'],
})
export class EditWorkItemsComponent implements OnInit {
  @Input() editWorkItem!: WorkItems;
  @Output() registerEvent = new EventEmitter<any>();
  editform!: FormGroup;
  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    console.log('In edit' + JSON.stringify(this.editWorkItem));
    this.editform = this.formBuilder.group({
      workItemId: [this.editWorkItem.workItemId],
      itemName: [this.editWorkItem.itemName],
      itemType: [this.editWorkItem.itemType],
      itemDescription: [this.editWorkItem.itemDescription],
      messageToRecipient: [this.editWorkItem.messageToRecipient],
      quantity: [this.editWorkItem.quantity],
      sourceCountry: [this.editWorkItem.sourceCountry],
      destinationCountry: [this.editWorkItem.destinationCountry],
      originHarborLocation: [
        this.editWorkItem.originHarborLocation,
        { validators: [Validators.required] },
      ],
      selectedHarborLocations: [this.editWorkItem.selectedHarborLocations],
      shippingDate: [
        this.editWorkItem.shippingDate,
        { validators: [Validators.required] },
      ],
      amount: [this.editWorkItem.amount],
    });
  }

  editWorkItemFun(editForm: any) {
    this.editform = editForm;
    //console.log('This Form',JSON.stringify(this.form.value));
    this.registerEvent.emit(this.editform.value);
  }
}
