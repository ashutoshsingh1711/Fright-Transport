import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Createuser } from './createuser/createuser';

@Injectable({
  providedIn: 'root',
})
export class DeleteService {
  constructor(private http: HttpClient) {}

  userId!: number;
  getUserDetails(detail: any[]) {
    this.userId = detail[0].userId;
    console.log(this.userId);
  }

  deleteUser(): Observable<Createuser[]> {
    return this.http.delete<Createuser[]>(
      `http://localhost:4000/ftr/userProfile/${this.userId}`
    );
  }
}
