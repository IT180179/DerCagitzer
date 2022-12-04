import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class DataService {
  constructor(private httpClient: HttpClient) {
  }

  getReservations(): Observable<any> {

    const url = "http://localhost:8080/reservation/all";
    return this.httpClient.get<any>(url);

  }

  getReservationByID(id: any): Observable<any> {

    const url: string = "http://localhost:8080/reservation/getByID/" + id;

    //console.log( this.httpClient.get<any>(url));
    return this.httpClient.get<any>(url);

  }

  getRooms(): Observable<any> {

    const url = "http://localhost:8080/room/all";
    return this.httpClient.get<any>(url);

  }

  getTabels(id:any): Observable<any> {

    const url = "http://localhost:8080/tables/getTablesPerRoom/"+id;
    return this.httpClient.get<any>(url);

  }

}
