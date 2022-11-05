import { Component, OnInit } from '@angular/core';
import {ReservationService} from "../../shared/reservation.service";
import {Reservation} from "../../shared/reservation";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-create-reservation',
  templateUrl: './create-reservation.component.html',
  styleUrls: ['./create-reservation.component.scss']
})
export class CreateReservationComponent implements OnInit {

  constructor(
    private reservationService: ReservationService,
    private route: ActivatedRoute,
    private router: Router,
  ) { }

  ngOnInit(): void {

  }

  createReservation(reservation: Reservation){
    this.reservationService.postReservation(reservation).subscribe(() => {
      this.router.navigate(['..'], {relativeTo: this.route})
    })
  }
}
