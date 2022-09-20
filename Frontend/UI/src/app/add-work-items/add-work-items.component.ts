import { Component, EventEmitter, OnInit, Output } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { v4 as uuidv4 } from 'uuid';

@Component({
  selector: 'app-add-work-items',
  templateUrl: './add-work-items.component.html',
  styleUrls: ['./add-work-items.component.css'],
})
export class AddWorkItemsComponent implements OnInit {
  @Output() registerEvent = new EventEmitter<any>();
  form!: FormGroup;
  workItem!: any;

  constructor(private formBuilder: FormBuilder) {}

  ngOnInit(): void {
    this.form = this.formBuilder.group({
      workitemId: [uuidv4()],
      itemName: ['', { validators: [Validators.required] }],
      itemType: ['', { validators: [Validators.required] }],
      itemDescription: ['', { validators: [Validators.required] }],
      messageToRecipient: ['', { validators: [Validators.required] }],
      quantity: ['', { validators: [Validators.required] }],
      sourceCountry: ['', { validators: [Validators.required] }],
      destinationCountry: ['', { validators: [Validators.required] }],
      orginHarborLocation: ['', { validators: [Validators.required] }],
      selectedHarborLocation: ['', { validators: [Validators.required] }],
      shippingDate: ['', { validators: [Validators.required] }],
      amount: ['', { validators: [Validators.required] }],
    });
  }

  addWorkItem(addForm: any) {
    this.form = addForm;
    //console.log('This Form',JSON.stringify(this.form.value));
    this.registerEvent.emit(this.form.value);
  }
}
