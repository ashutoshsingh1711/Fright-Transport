import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CreateuserService } from '../createuser.service';
import { ProfileService } from '../profile.service';
import { Createuser } from './createuser';

@Component({
  selector: 'app-createuser',
  templateUrl: './createuser.component.html',
  styleUrls: ['./createuser.component.css'],
})
export class CreateuserComponent implements OnInit {
  constructor(
    private formbuilder: FormBuilder,
    private router: Router,
    private createUser: CreateuserService,
    private profile: ProfileService
  ) {}
  registerForm!: FormGroup;
  // firstname!:String;
  // lastname!:String;
  // emailid!:String;
  // mobilenumber!:Number;
  // password!:String;
  // nationality!:String;
  // passportnumber!:String;
  // permanentaddress!:String;
  // officeaddress!:String;
  // personalidentificationnumber!:Number;

  submitted!: boolean;
  createuser: Createuser = new Createuser();
  output!: string;

  ngOnInit(): void {
    this.registerForm = this.formbuilder.group({
      Firstname: [
        '',
        [
          Validators.minLength(2),
          Validators.required,
          Validators.maxLength(20),
        ],
      ],
      Lastname: [
        '',
        [
          Validators.required,
          Validators.minLength(2),
          Validators.maxLength(20),
        ],
      ],
      Emailid: ['', [Validators.required, Validators.email]],
      Mobilenumber: [
        '',
        [
          Validators.required,
          Validators.minLength(10),
          Validators.maxLength(10),
        ],
      ],
      Password: [
        '',
        [
          Validators.required,
          Validators.pattern(
            '((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!]).{7,15})'
          ),
        ],
      ],
      Nationality: ['', [Validators.required, Validators.maxLength(20)]],
      Passportnumber: [
        '',
        [
          Validators.required,
          Validators.minLength(7),
          Validators.maxLength(12),
        ],
      ],
      Permanentaddress: ['', [Validators.required, Validators.maxLength(200)]],
      Officeaddress: ['', [Validators.required, Validators.maxLength(200)]],
      Personalidentificationnumber: [
        '',
        [
          Validators.required,
          Validators.minLength(12),
          Validators.maxLength(12),
        ],
      ],
      //Validators.pattern('((?=.\\d)(?=.[a-z])(?=.[A-Z])(?=.[@#$%!]).{7,15})')
    });
  }

  submit() {
    this.submitted = true;
    console.log(this.createuser);
    // this.profile.getEmail(this.createuser)
    //this.createUser.addUser(this.createuser);
    this.createUser.addUser(this.createuser).subscribe({
      next: (data) => console.log(data),
      error: (err) => {
        console.log(err);
        if (
          err.error.text.length > 13 &&
          err.error.text.slice(0, 14) == 'UserProfileDTO'
        ) {
          console.log(err.error.text);

          this.router.navigate(['/login']);
        } else {
          this.output = err.error.text;
          console.log(err.error.text);
          console.log(err.error.text[0]);
        }
      },
    });
  }
}
