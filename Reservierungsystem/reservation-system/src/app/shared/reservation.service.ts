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
      'Cache-Control': 'no-cache'
    });
    return this.httpClient.post("https://localhost:8080/reservation/add", reservation, { headers: httpHeaders })
  }

  getAll(): Observable<Reservation[]> {

    return this.httpClient.get<Reservation[]>("https://localhost:8080/reservation/all")
      .pipe(
        catchError(this.errorHandler)
      );

  }

  private errorHandler(error: HttpErrorResponse): Observable<any> {
    console.error("Fehler aufgetreten!");
    return throwError(error.message);
  }
}

