import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { IVehicle } from './IVehicle';

@Injectable({
  providedIn: 'root',
})
export class VehicleserviceService {
  constructor(private http: HttpClient) {}
  id!: any;

  getVehicle(): Observable<IVehicle[]> {
    let c = this.http.get<IVehicle[]>('http://localhost:8000/ftr/vehicles');
    console.log(c);
    return c;
  }
  getVehicleByVehicleNumber(number: string): Observable<IVehicle[]> {
    return this.http.get<IVehicle[]>(
      'http://localhost:8000/ftr/vehicles/vehicleNumber/' + number
    );
  }

  getVehicleByVehicleName(name: string): Observable<IVehicle[]> {
    let c = this.http.get<IVehicle[]>(
      'http://localhost:8000/ftr/vehicles/vehicleName/' + name
    );
    return c;
  }

  removeVehicle(item: string): Observable<string> {
    let param1 = new HttpParams().set('vehicleNumber', item);
    const opt = { params: param1 };
    let c = this.http.delete<string>(
      'http://localhost:8000/ftr/vehicles/',
      opt
    );
    return c;
  }

  addVehicle(vehicle?: IVehicle): Observable<IVehicle[]> {
    console.log('In service', vehicle);
    let c = this.http.post<IVehicle[]>(
      'http://localhost:8000/ftr/vehicles',
      vehicle
    );
    console.log(c);
    return c;
  }
}
