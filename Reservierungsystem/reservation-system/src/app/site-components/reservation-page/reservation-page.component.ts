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
      datum: new FormControl(null),
      tischnummer: new FormControl(),
      personenanzahl: new FormControl('2'),
      slot1: new FormControl('11:30 - 13:00'),
      slot2: new FormControl('17:30 - 19:00'),
      slot3: new FormControl('13:00 - 14:30'),
      slot4: new FormControl('19:00 - 20:30'),
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
