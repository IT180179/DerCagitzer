import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {UntypedFormBuilder, UntypedFormControl, UntypedFormGroup} from '@angular/forms';
import {Reservation} from "../../shared/reservation";


@Component({
  selector: 'app-reservation-page',
  templateUrl: './reservation-page.component.html',
  styleUrls: ['./reservation-page.component.scss']
})
export class ReservationPageComponent implements OnInit {

  @Input() reservation?: Reservation;
  @Output() submitReservation = new EventEmitter<Reservation>();
  reactiveForm: UntypedFormGroup;


  constructor(private fb: UntypedFormBuilder) { }

  ngOnInit(){
    this.reactiveForm = new UntypedFormGroup({
      nachname: new UntypedFormControl(null),
      telefonnummer: new UntypedFormControl(null),
      datum: new UntypedFormControl(null),
      tischnummer: new UntypedFormControl(),
      personenanzahl: new UntypedFormControl('2'),
      slot1: new UntypedFormControl('11:30 - 13:00'),
      slot2: new UntypedFormControl('17:30 - 19:00'),
      slot3: new UntypedFormControl('13:00 - 14:30'),
      slot4: new UntypedFormControl('19:00 - 20:30'),
      vorname: new UntypedFormControl(null),
      email: new UntypedFormControl(null),
      anmerkung: new UntypedFormControl(null)
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
