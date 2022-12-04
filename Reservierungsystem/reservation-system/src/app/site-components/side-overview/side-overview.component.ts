import {Component, Input, OnInit} from '@angular/core';
import {Reservation} from "../../shared/reservation";
import {ReservationService} from "../../shared/reservation.service";

@Component({
  selector: 'app-side-overview',
  templateUrl: './side-overview.component.html',
  styleUrls: ['./side-overview.component.scss'],
})
export class SideOverviewComponent implements OnInit {

  @Input() infoReservation: Reservation;
  @Input() resultPerDay: number;
  @Input() resultPerRoomNoon: number;
  @Input() resultPerRoomEvening: number;
  reservationsPerDay: number;
  reservationsPerRoomNoon: number;
  reservationsPerRoomEvening: number;

  constructor(private rs: ReservationService) {}

  ngOnInit(): void {
    this.reservationsPerDayCalc("01.12.2022");
  }

  reservationsPerDayCalc(date: String) {
    this.rs.countReservationsPerDay(date).subscribe(
      (r: number) => {
        this.reservationsPerDay = r;
        this.resultPerDay = (this.reservationsPerDay / 124) * 100;
      }
    )
  }
  reservationsPerRoomNoonCalc(date: String, room: number) {
    this.rs.countReservationsPerRoomNoon(date, room).subscribe(
      (r: number) => {
        this.reservationsPerRoomNoon = r;
        this.resultPerRoomNoon = (this.reservationsPerRoomNoon / 31) * 100;
      }
    )
  }
  reservationsPerRoomEveningCalc(date: String, room: number) {
    this.rs.countReservationsPerRoomEvening(date, room).subscribe(
      (r: number) => {
        this.reservationsPerRoomEvening = r;
        this.resultPerRoomEvening = (this.reservationsPerRoomEvening / 31) * 100;
      }
    )
  }
}
