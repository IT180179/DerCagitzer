import {Component, EventEmitter, Input, OnInit, Output, ViewChild} from '@angular/core';
import {Reservation} from "../../shared/reservation";
import {ReservationService} from "../../shared/reservation.service";
import {MatCalendar} from "@angular/material/datepicker";

@Component({
  selector: 'app-side-overview',
  templateUrl: './side-overview.component.html',
  styleUrls: ['./side-overview.component.scss'],
})
export class SideOverviewComponent implements OnInit {

  @Input() infoReservation: Reservation;
  @Input() resultPerDayNoon: number;
  @Input() resultPerDayEvening: number;
  @Input() resultPerWeek: number;

  constructor(private rs: ReservationService) {}

  ngOnInit(): void {
    this.reservationsPerDayNoon("01.12.2022");
    this.reservationsPerDayEvening("01.12.2022");
  }

  reservationsPerDayNoon(date: String) {
    this.rs.countReservationsPerDayNoon(date).subscribe(
      (r: number) => {
        this.resultPerDayNoon = Math.round(r * 100);
      }
    )
  }

  reservationsPerDayEvening(date: String) {
    this.rs.countReservationsPerDayEvening(date).subscribe(
      (r: number) => {
        this.resultPerDayEvening = Math.round(r * 100);
      }
    )
  }

  //reservationsPerWeek(date: Date) {
  //  this.rs.countReservationsPerWeek().subscribe(
  //    (r: number) => {
  //      this.resultPerDayEvening = Math.round(r * 100);
  //    }
  //  )
  //}
}
