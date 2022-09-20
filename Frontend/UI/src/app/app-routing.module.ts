import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddWorkItemsComponent } from './add-work-items/add-work-items.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';
import { CreateuserComponent } from './createuser/createuser.component';
import { EditWorkItemsComponent } from './edit-work-items/edit-work-items.component';
import { LandingComponent } from './landing/landing.component';
import { LoginComponent } from './login/login.component';
import { ProfileComponent } from './profile/profile.component';
import { TerminalsComponent } from './terminals/terminals.component';
import { UpdateProfileComponent } from './update-profile/update-profile.component';
import { UserdashboardComponent } from './userdashboard/userdashboard.component';
import { VehicleComponent } from './vehicle/vehicle.component';
import { WorkItemsComponentComponent } from './work-items-component/work-items-component.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'create-user', component: CreateuserComponent },
  { path: 'user-dashboard', component: UserdashboardComponent },
  { path: 'home', component: LandingComponent },
  { path: '', redirectTo: '/home', pathMatch: 'full' },
  // {path:"create-workitem", component: CreateworkitemComponent},
  { path: 'profile', component: ProfileComponent },
  { path: 'update-profile', component: UpdateProfileComponent },
  { path: 'admin', component: AdminloginComponent },
  { path: 'admin-dashboard', component: AdmindashboardComponent },
  { path: 'terminal', component: TerminalsComponent },
  { path: 'vehicle', component: VehicleComponent },
  { path: 'work-items', component: WorkItemsComponentComponent },
  { path: 'create-work-items', component: AddWorkItemsComponent },
  { path: 'edit-work-items', component: EditWorkItemsComponent },
  //{path:"update-workitem", component: UpdateworkitemComponent}, AdminloginComponent AdmindashboardComponent VehicleComponent
  //{path:"user-workitem", component: UserWorkitemComponent} WorkItemsComponentComponent AddWorkItemsComponent
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
