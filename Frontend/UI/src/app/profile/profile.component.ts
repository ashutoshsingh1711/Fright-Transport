import { Component, DoCheck, OnChanges, OnInit } from '@angular/core';
import { Router } from '@angular/router';

import { Createuser } from '../createuser/createuser';
import { DeleteService } from '../delete.service';
import { ProfileService } from '../profile.service';
import { UpdateService } from '../update.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],
})
export class ProfileComponent implements OnInit, DoCheck {
  public updated: boolean = false;
  public deleted: boolean = false;
  constructor(
    private profileService: ProfileService,
    private router: Router,
    private updateService: UpdateService,
    private deleteService: DeleteService
  ) {}

  createUser: Createuser = new Createuser();
  userDetails: any[] = [];
  userid!: number;

  ngDoCheck(): void {
    this.profileService.getuser().subscribe((data) => {
      this.userDetails = data;
    });
    this.updateService.getUserDetails(this.userDetails);
    this.deleteService.getUserDetails(this.userDetails);
    this.userid = this.deleteService.userId;
  }
  ngOnInit(): void {}
  public update(): void {
    this.updated = true;
    console.log('Updated = ' + this.updated);
  }
  // this.userid = this.deleteServive.userId;
  public delete(): void {
    this.deleted = true;
    this.deleteService.deleteUser().subscribe(
      (data) => {
        console.log(data);

        //this.updateService.getUserDetails(this.userDetails.userId)
      }

      //  console.log(this.createUser);
    );
    this.router.navigate(['/login']);
    console.log('User ' + this.userid + 'details are removed successfully');
    return;
  }
}
