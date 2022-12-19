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

  countReservationsPerDayNoon(date: String): Observable<number> {
    let httpHeaders = new HttpHeaders({
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept",
    });
    return this.httpClient.get("http://localhost:8080/reservation/calculateReservationsPerDayNoon/" + date, {headers:httpHeaders})
      .pipe(
        catchError(this.errorHandler)
      );
  }

  countReservationsPerDayEvening(date: String): Observable<number> {
    let httpHeaders = new HttpHeaders({
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept",
    });
    return this.httpClient.get("http://localhost:8080/reservation/calculateReservationsPerDayEvening/" + date, {headers:httpHeaders})
      .pipe(
        catchError(this.errorHandler)
      );
  }

  countReservationsPerWeek(start_date: String, end_date: String): Observable<number> {
    let httpHeaders = new HttpHeaders({
      "Access-Control-Allow-Origin": "*",
      "Access-Control-Allow-Headers": "Origin, X-Requested-With, Content-Type, Accept",
    });
    return this.httpClient.get("http://localhost:8080/reservation/calculateReservationsPerWeek/" + start_date + "/" + end_date, {headers:httpHeaders})
      .pipe(
        catchError(this.errorHandler)
      );
  }

  update(reservation: Reservation){
    let httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      'Cache-Control': 'no-cache',

      'Access-Control-Allow-Origin': 'http://localhost:8080',
      'Access-Control-Allow-Credentials': 'true',
    });
    return this.httpClient.put("http://localhost:8080/reservation/update", reservation, { headers: httpHeaders })
  }

  delete(id: number): Observable<any> {
    let httpHeaders = new HttpHeaders({
      'Content-Type': 'application/json',
      'Cache-Control': 'no-cache',

      'Access-Control-Allow-Origin': 'http://localhost:8080',
      'Access-Control-Allow-Credentials': 'true',
    });
    return this.httpClient.delete("http://localhost:8080/reservation/delete/" + id, {headers: httpHeaders});
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

