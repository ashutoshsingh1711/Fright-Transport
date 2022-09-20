import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ITerminal } from './Poster';
import { TerminalserviceService } from './terminal.service';
//import { TerminalserviceService } from './terminalservice.service';
// import { TerminalserviceService } from './terminalservice.service';

// import { FormBuilder, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-terminals',
  templateUrl: './terminals.component.html',
  styleUrls: ['./terminals.component.css'],
})
export class TerminalsComponent implements OnInit {
  submitted = false;
  adding = false;
  getting = false;
  updating = false;
  deleting = false;
  gettingId = false;
  gettingItem = false;
  // AddForm!: FormGroup;
  terminalDetails: any[] = [];
  terminalDetailsById: any = {};

  terminalDetailsByItem: any[] = [];
  test: any = 'hii';

  term: ITerminal = new ITerminal();

  stringdelete!: string;
  stringadd: any[] = [];
  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private terminalservice: TerminalserviceService
  ) {}
  addterminal!: FormGroup;

  terminalId!: string;
  terminal_name!: string;
  country!: string;
  itemType!: string;
  terminal_description!: string;
  capacity!: number;
  status!: string;
  harbor_location!: string;
  available_capacity!: number;

  output!: string;
  cap!: number;

  addingmessage = false;
  updatingmessage = false;
  deletingmessage = false;
  gettingIdmessage = false;
  gettingItemmessage = false;
  name = 'ashutosh';

  ngOnInit(): void {
    this.terminalservice.getTerminal().subscribe({
      next: (data: any) => {
        this.terminalDetails = data;
        console.log(this.terminalDetails);
      },
      error: (err: any) => {
        this.output = err.error.text;
      },
    });

    // this.terminalservice.getTerminalByItem(this.itemType).subscribe(data=>this.terminalDetailsByItem=data);

    this.addterminal = this.formBuilder.group({
      Terminalid: ['', Validators.required],
      Terminalname: [
        '',
        [
          Validators.minLength(3),
          Validators.required,
          Validators.maxLength(20),
        ],
      ], //min 3 max 20
      Country: [
        '',
        [
          Validators.minLength(3),
          Validators.required,
          Validators.maxLength(20),
        ],
      ], //same
      Itemtype: [
        '',
        [
          Validators.minLength(4),
          Validators.required,
          Validators.maxLength(30),
        ],
      ], //min 4 max 30
      Terminaldescription: [
        '',
        [Validators.required, Validators.maxLength(25)],
      ], //max 25
      Capacity: ['', [Validators.required, Validators.max(99999)]], //max 99999
      Status: ['', Validators.required], //
      Harbourlocation: ['', Validators.required], //
      Availablecapacity: ['', [Validators.required, Validators.max(99999)]], //max 99999
    });
  }

  // terminalDetails:any[]=[
  //   {terminalId:"T1",terminalName:"Haka",country:"India",itemType:"Oil Container",itemDescription:"T1-Oil Container",capacity:30000,availableCapacity:10000,status:"Available",harborLocation:"Chennai port"}
  // ]

  add() {
    this.submitted = true;
    this.adding = true;
  }
  getAll() {
    this.submitted = true;
    this.getting = true;
  }
  update() {
    this.submitted = true;
    this.updating = true;
  }
  delete() {
    this.submitted = true;
    this.deleting = true;
  }
  getById() {
    this.submitted = true;
    this.gettingId = true;
  }
  getByItem() {
    this.submitted = true;
    this.gettingItem = true;
  }
  Back() {
    this.submitted = false;
    this.adding = false;
    this.getting = false;
    this.updating = false;
    this.deleting = false;
    this.gettingId = false;
    this.gettingItem = false;
    this.updatingmessage = false;
    this.deletingmessage = false;
    this.addingmessage = false;
    this.gettingIdmessage = false;
    this.gettingItemmessage = false;
  }

  Submit() {
    this.addingmessage = true;
    this.terminalservice
      .addTerminal(this.term)
      .subscribe((data: any) => (this.stringadd = data));
  }

  updatemessage() {
    this.updatingmessage = true;
  }

  deletemessage() {
    this.deletingmessage = true;
    this.terminalservice
      .deleteTerminal(this.terminalId)
      .subscribe((data: any) => (this.stringdelete = data));
    console.log(this.stringdelete);
  }

  getIdmessage() {
    this.gettingIdmessage = true;
    console.log(this.terminalId);
    // document.write(this.terminalId);
    this.terminalservice
      .getTerminalById(this.terminalId)
      .subscribe((data: any) => {
        this.terminalDetailsById = data;
        console.log(this.terminalDetailsById);
        console.log(typeof data);
      });

    console.log(this.terminalDetailsById);
  }

  getItemmessage() {
    this.gettingItemmessage = true;
    this.terminalservice
      .getTerminalByItem(this.itemType)
      .subscribe(
        (data: any) => ((this.terminalDetailsByItem = data), console.log(data))
      );
  }
}
