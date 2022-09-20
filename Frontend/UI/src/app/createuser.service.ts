import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Createuser } from './createuser/createuser';

@Injectable({
  providedIn: 'root',
})
export class CreateuserService {
  constructor(private http: HttpClient) {}

  addUser(user?: Createuser): Observable<Createuser[]> {
    return this.http.post<Createuser[]>(
      'http://localhost:4040/ftr/userProfile',
      user
    );
  }

  getuser(): Observable<Createuser[]> {
    return this.http.get<Createuser[]>(
      `http://localhost:4040/ftr/userProfile/${'1'}`
    );
  }
}
