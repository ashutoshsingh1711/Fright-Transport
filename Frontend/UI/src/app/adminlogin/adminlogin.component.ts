import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-adminlogin',
  templateUrl: './adminlogin.component.html',
  styleUrls: ['./adminlogin.component.css'],
})
export class AdminloginComponent implements OnInit {
  registerForm!: FormGroup;
  constructor(private formBuilder: FormBuilder, private router: Router) {}

  ngOnInit() {
    this.registerForm = this.formBuilder.group({
      adminname1: ['', Validators.required],
      pwd1: ['', Validators.required],
    });
  }

  adminname!: String;
  pwd!: String;
  isAuthenticated!: boolean;
  submitted = false;
  onSubmit(name: String, password: String) {
    this.submitted = true;
    this.adminname = name;

    if (name === 'admin' && password === 'admin') {
      this.isAuthenticated = true;
      this.router.navigate(['/admin-dashboard']);
    } else {
      this.isAuthenticated = false;
    }
  }
}
