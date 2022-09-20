import { Component, OnInit, AfterContentInit, DoCheck } from '@angular/core';
import { FormBuilder, Validator, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { ProfileService } from '../profile.service';
import { Login } from './login';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})
export class LoginComponent implements OnInit, AfterContentInit, DoCheck {
  constructor(
    private formBuilder: FormBuilder,
    private router: Router,
    private loginservice: LoginService,
    private profileService: ProfileService
  ) {}

  ngAfterContentInit(): void {}
  login!: FormGroup;

  ngOnInit(): void {
    this.login = this.formBuilder.group({
      UserName: ['', Validators.required],
      Password: ['', Validators.required],
    });
  }
  isAuthenticated!: boolean;
  submitted = false;
  // username!:string;
  // password!:string;
  url!: boolean;
  //bookride:string='["/book-ride"]';
  //logins:string='["/login"]';
  logincheck: Login = new Login();

  ngDoCheck(): void {
    //  console.log(this.logincheck.userId);
    this.profileService.getEmail(this.logincheck.userId);
  }
  submit() {
    //this.submitted=true;
    console.log(this.logincheck);
    this.loginservice.getuser(this.logincheck).subscribe({
      next: (data: any) => console.log(data),
      error: (err: { error: { text: string } }) => {
        if (err.error.text == 'Logged In Successfully!') {
          console.log(err);
          this.router.navigate(['/user-dashboard']);
          this.isAuthenticated = true;
        } else {
          this.submitted = true;
          this.isAuthenticated = false;
        }
      },
    });
  }
}
