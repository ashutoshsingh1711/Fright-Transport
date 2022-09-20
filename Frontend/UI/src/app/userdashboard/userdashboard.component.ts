import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Createuser } from '../createuser/createuser';
import { ProfileService } from '../profile.service';

@Component({
  selector: 'app-userdashboard',
  templateUrl: './userdashboard.component.html',
  styleUrls: ['./userdashboard.component.css'],
})
export class UserdashboardComponent implements OnInit {
  constructor(private profileService: ProfileService) {}

  output!: string;
  createUser: Createuser = new Createuser();

  ngOnInit(): void {}

  submit() {}
}
