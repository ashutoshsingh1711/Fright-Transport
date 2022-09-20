import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Createuser } from './createuser/createuser';
import { Login } from './login/login';

@Injectable({
  providedIn: 'root',
})
export class LoginService {
  constructor(private http: HttpClient) {}

  getuser(user?: Login): Observable<Createuser[]> {
    return this.http.post<Createuser[]>(
      `http://localhost:4000/ftr/userProfile/login`,
      user
    );
  }
}
