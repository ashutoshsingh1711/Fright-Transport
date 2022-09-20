import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable, tap } from 'rxjs';
import { ITerminal } from './Poster';

@Injectable({
  providedIn: 'root',
})
export class TerminalserviceService {
  constructor(private http: HttpClient) {}

  getTerminal(): Observable<ITerminal[]> {
    return this.http.get<ITerminal[]>('http://localhost:8696/ftr/terminals');
  }

  getTerminalById(id?: string): Observable<ITerminal[]> {
    // const options = new HttpHeaders({
    //   'Content-Type': 'application/json',
    //   'Access-Control-Allow-Origin': '*',
    //   'Access-Control-Allow-Methods': '*',
    // });
    return this.http.get<ITerminal[]>(
      'http://localhost:8696/ftr/terminals/fetchTerminalsByTerminalId/' + id
    );
  }

  // getTerminalById(id?: string): Observable<ITerminal[]> {
  //   console.log(id);
  //   // let param1=new HttpParams().set('terminalId','T2')
  //   return this.http.get<ITerminal[]>(
  //     `http://localhost:8696/ftr/terminals/fetchTerminalByTerminalId/${id}`s
  //   );
  // }

  getTerminalByItem(item: string): Observable<any> {
    console.log(item);
    // let param1=new HttpParams().set('terminalItem','item')
    // console.log(param1)
    return this.http.get<ITerminal[]>(
      'http://localhost:8696/ftr/terminals/fetchTerminalsByItemType/' + item
    );
  }

  deleteTerminal(item?: string): Observable<string> {
    return this.http.delete<string>(
      'http://localhost:8696/ftr/terminals/' + item
    );
  }

  addTerminal(terminal?: ITerminal): Observable<ITerminal[]> {
    return this.http.post<ITerminal[]>(
      `http://localhost:8696/ftr/terminals`,
      terminal
    );
  }
}
