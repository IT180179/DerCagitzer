import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse, HttpHeaders} from "@angular/common/http";
import {Reservation} from "./reservation";
import {throwError, Observable, catchError} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ReservationService {


  constructor(private httpClient: HttpClient) { }


  postReservation(reservation: Reservation){
    let httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      'Cache-Control': 'no-cache',

      'Access-Control-Allow-Origin': 'http://localhost:8080',
      'Access-Control-Allow-Credentials': 'true',
    });
    return this.httpClient.post("http://localhost:8080/reservation/add", reservation, { headers: httpHeaders })
  }

  getAll(): Observable<Reservation[]> {
    let httpHeaders = new HttpHeaders({
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept",
    });
    return this.httpClient.get<Reservation[]>("http://localhost:8080/reservation/all", { headers: httpHeaders })
      .pipe(
        catchError(this.errorHandler)
      );

  }

  getByID(id: number): Observable<Reservation[]> {
    let httpHeaders = new HttpHeaders({
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept",
    });
    return this.httpClient.get<Reservation[]>("http://localhost:8080/reservation/getByID/" + id, { headers: httpHeaders })
      .pipe(
        catchError(this.errorHandler)
      );
  }

  private errorHandler(error: HttpErrorResponse): Observable<any> {
    console.error("Fehler aufgetreten!");
    return throwError(error.message);
  }
}

