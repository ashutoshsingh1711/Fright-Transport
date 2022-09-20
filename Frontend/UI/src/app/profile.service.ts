import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Createuser } from './createuser/createuser';

@Injectable({
  providedIn: 'root',
})
export class ProfileService {
  constructor(private http: HttpClient) {}

  email!: any;
  getEmail(email: any) {
    this.email = email;
  }
  getuser(): Observable<Createuser[]> {
    return this.http.get<Createuser[]>(
      `http://localhost:4000/ftr/userProfile/email/${this.email}`
    );
  }
}
