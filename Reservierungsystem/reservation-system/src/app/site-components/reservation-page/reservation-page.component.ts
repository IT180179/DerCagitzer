import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from '@angular/forms';
import {Reservation} from "../../shared/reservation";


@Component({
  selector: 'app-reservation-page',
  templateUrl: './reservation-page.component.html',
  styleUrls: ['./reservation-page.component.scss']
})
export class ReservationPageComponent implements OnInit {

  @Input() reservation?: Reservation;
  @Output() submitReservation = new EventEmitter<Reservation>();
  reactiveForm: FormGroup;


  constructor(private fb: FormBuilder) { }

  ngOnInit(){

    this.reactiveForm = new FormGroup({
      nachname: new FormControl(null),
      telefonnummer: new FormControl(null),
      tischnummer: new FormControl(),
      datum: new FormControl(null),
      personenanzahl: new FormControl('2'),
      zeit: new FormControl(null)


    });

  }

  submitForm() {
    const formValue = this.reactiveForm.value;
    const newReservation: Reservation = {
      ...formValue,
    }
    this.submitReservation.emit(newReservation);
    this.reactiveForm.reset();
  }
}
