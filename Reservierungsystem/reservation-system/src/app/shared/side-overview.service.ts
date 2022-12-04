import { Injectable } from '@angular/core';
import {ReservationService} from "./reservation.service";

@Injectable({
  providedIn: 'root'
})
export class SideOverviewService {
  get room(): any {
    return this._room;
  }

  set room(value: any) {
    this._room = value;
  }

  reservationsPerRoomNoon: number;
  reservationsPerRoomEvening: number;
  private _room: any = 1;

  constructor(private rs: ReservationService) {}

  reservationsPerRoomNoonCalc(date: String): number {
    console.log("haalllloooo" + this.room)
    this.rs.countReservationsPerRoomNoon(date, this.room).subscribe(
      (r: number) => {
        this.reservationsPerRoomNoon = r;
        return (this.reservationsPerRoomNoon / 31) * 100;
      }
    )
    return 0;
  }

  reservationsPerRoomEveningCalc(date: String): any {
    this.rs.countReservationsPerRoomEvening(date, this.room).subscribe(
      (r: number) => {
        this.reservationsPerRoomEvening = r;
        return (this.reservationsPerRoomEvening / 31) * 100;
      }
    )
  }
}
