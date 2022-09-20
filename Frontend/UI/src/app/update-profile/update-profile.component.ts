import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { UpdateService } from '../update.service';
import { Update } from './update';

@Component({
  selector: 'app-update-profile',
  templateUrl: './update-profile.component.html',
  styleUrls: ['./update-profile.component.css'],
})
export class UpdateProfileComponent implements OnInit {
  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private updateService: UpdateService
  ) {}
  ngAfterContentInit(): void {}

  update!: FormGroup;

  ngOnInit(): void {
    this.update = this.formBuilder.group({
      Mobilenumber: ['', Validators.required],

      Permanentaddress: ['', Validators.required],
      Officeaddress: ['', Validators.required],
    });
  }
  // mobileNumber!:number;
  // permanentAddress!:string;
  // officeAddress!:string;

  upd: Update = new Update();

  submit() {
    this.updateService.updateUser(this.upd).subscribe(
      (data) => {
        console.log(data);

        //this.updateService.getUserDetails(this.userDetails.userId)
      }

      //  console.log(this.createUser);
    );
    this.router.navigate(['/profile']);

    return;
  }
}
