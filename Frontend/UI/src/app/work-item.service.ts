import { Injectable } from '@angular/core';
import {
  HttpClient,
  HttpErrorResponse,
  HttpHeaders,
} from '@angular/common/http';
import { catchError, Observable, throwError } from 'rxjs';
import { tap } from 'rxjs/operators';
import { WorkItems } from './work-items-component/WorkItems';

@Injectable({
  providedIn: 'root',
})
export class WorkItemService {
  constructor(private httpClient: HttpClient) {}

  getWorkItems(): Observable<WorkItems[]> {
    return this.httpClient
      .get<WorkItems[]>('http://localhost:8004/ftr/workItems')
      .pipe(
        tap((data: any) => console.log('Data Fetched:' + JSON.stringify(data))),
        catchError(this.handleError)
      );
  }

  getSpecificWorkItems(filterValue: any): Observable<WorkItems[]> {
    return this.httpClient
      .get<WorkItems[]>(
        'http://localhost:8004/ftr/workItems/managed-status/' + filterValue
      )
      .pipe(
        tap((data: any) => console.log('Data Fetched:' + JSON.stringify(data))),
        catchError(this.handleError)
      );
  }

  addWorkItems(workItems: WorkItems): Observable<any> {
    const options = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.httpClient
      .post('http://localhost:8004/ftr/workItems', workItems, {
        headers: options,
      })
      .pipe(catchError(this.handleError));
  }

  editWorkItems(workItems: WorkItems): Observable<any> {
    const options = new HttpHeaders({ 'Content-Type': 'application/json' });
    return this.httpClient
      .put(
        'http://localhost:8004/ftr/workItems/' + workItems.workItemId,
        workItems,
        { headers: options }
      )
      .pipe(catchError(this.handleError));
  }

  private handleError(err: HttpErrorResponse): Observable<any> {
    let errMsg = '';
    if (err.error instanceof Error) {
      //console.log('Error Message:',err.error.message);
      errMsg = err.error.message;
    } else {
      //console.log(`error status code ${err.status}`);
      errMsg = err.error.status;
    }
    return throwError(() => errMsg);
  }
}
