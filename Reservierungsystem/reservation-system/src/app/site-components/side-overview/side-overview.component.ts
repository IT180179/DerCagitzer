import {Component, Input, OnInit} from '@angular/core';
import {Reservation} from "../../shared/reservation";
import {ReservationService} from "../../shared/reservation.service";
import {SideOverviewService} from "../../shared/side-overview.service";

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

  constructor(private rs: ReservationService, public sos: SideOverviewService) {}

  ngOnInit(): void {
    this.reservationsPerDayCalc("01.12.2022");
    this.resultPerRoomNoon = this.sos.reservationsPerRoomNoonCalc("01.12.2022");
    this.resultPerRoomEvening = this.sos.reservationsPerRoomEveningCalc("01.12.2022");
  }

  reservationsPerDayCalc(date: String) {
    this.rs.countReservationsPerDay(date).subscribe(
      (r: number) => {
        this.reservationsPerDay = r;
        this.resultPerDay = (this.reservationsPerDay / 124) * 100;
      }
    )
  }
}
