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

  today = new Date();

  constructor(private fb: FormBuilder) { }

  ngOnInit(){
    this.reactiveForm = new FormGroup({
      nachname: new FormControl(null),
      telefonnummer: new FormControl(null),
      datum: new FormControl(this.today),
      tischnummer: new FormControl(10),
      personenanzahl: new FormControl('2'),
      slot1: new FormControl('11:00 - 13:00'),
      slot2: new FormControl('13:00 - 15:00'),
      slot3: new FormControl('17:00 - 19:00'),
      slot4: new FormControl('19:00 - 21:00'),
      vorname: new FormControl(null),
      email: new FormControl(null),
      anmerkung: new FormControl(null)
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
