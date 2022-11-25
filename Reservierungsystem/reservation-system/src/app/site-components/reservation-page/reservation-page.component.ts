import {Component, EventEmitter, Inject, Input, OnInit, Output} from '@angular/core';
import {UntypedFormBuilder, UntypedFormControl, UntypedFormGroup} from '@angular/forms';
import {Reservation} from "../../shared/reservation";
import {MAT_DIALOG_DATA} from "@angular/material/dialog";


@Component({
  selector: 'app-reservation-page',
  templateUrl: './reservation-page.component.html',
  styleUrls: ['./reservation-page.component.scss']
})
export class ReservationPageComponent implements OnInit {



  @Input() reservation?: Reservation;
  @Output() submitReservation = new EventEmitter<Reservation>();
  reactiveForm: UntypedFormGroup;

  today = new Date();
  test: Date;

  constructor(private fb: UntypedFormBuilder, @Inject(MAT_DIALOG_DATA) public data: any) { }


  ngOnInit(){
console.log(this.data.data.fulltime)
    this.test = this.data.date.toLocaleDateString()

    this.reactiveForm = new UntypedFormGroup({
      nachname: new UntypedFormControl(null),
      telefonnummer: new UntypedFormControl(null),
      tischnummer: new UntypedFormControl(this.data.tablenr.nr),
      uhrzeit: new UntypedFormControl(this.data.data.fulltime),
      datum: new UntypedFormControl(this.test),
      personenanzahl: new UntypedFormControl('2'),
      //slot1: new FormControl('11:00 - 13:00'),
      //slot2: new FormControl('13:00 - 15:00'),
      //slot3: new FormControl('17:00 - 19:00'),
     // slot4: new FormControl('19:00 - 21:00'),
      vorname: new UntypedFormControl(null),
      email: new UntypedFormControl(null),
      anmerkungen: new UntypedFormControl(null)
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
