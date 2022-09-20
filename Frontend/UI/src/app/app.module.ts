import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
// import { AddWorkItemsComponent } from './add-work-items/add-work-items.component';
import { AdmindashboardComponent } from './admindashboard/admindashboard.component';
import { AdminloginComponent } from './adminlogin/adminlogin.component';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
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
import { MatTableModule } from '@angular/material/table';
import { MatButtonModule } from '@angular/material/button';
import { MatNativeDateModule } from '@angular/material/core';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatInputModule } from '@angular/material/input';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AddWorkItemsComponent } from './add-work-items/add-work-items.component';

@NgModule({
  declarations: [
    AppComponent,
    AddWorkItemsComponent,
    AdmindashboardComponent,
    AdminloginComponent,
    CreateuserComponent,
    EditWorkItemsComponent,
    LandingComponent,
    LoginComponent,
    ProfileComponent,
    TerminalsComponent,
    UpdateProfileComponent,
    UserdashboardComponent,
    VehicleComponent,
    WorkItemsComponentComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatTableModule,
    MatButtonModule,
    MatFormFieldModule,
    MatDatepickerModule,
    ReactiveFormsModule,
    MatNativeDateModule,

    MatInputModule,
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
