import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Createuser } from './createuser/createuser';
import { Update } from './update-profile/update';

@Injectable({
  providedIn: 'root',
})
export class UpdateService {
  constructor(private http: HttpClient) {}

  userId!: number;
  getUserDetails(detail: any[]) {
    this.userId = detail[0].userId;
    // console.log(this.userId);
  }

  updateUser(user?: Update): Observable<Createuser[]> {
    return this.http.put<Createuser[]>(
      `http://localhost:4000/ftr/userProfile/${this.userId}`,
      user
    );
  }
}
