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
  @Input() reservationsPerDay: number;

  constructor() {}

  ngOnInit(): void {
  }

}
