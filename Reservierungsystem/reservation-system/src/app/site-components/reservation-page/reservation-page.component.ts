import {Component, EventEmitter, Inject, Input, OnInit, Output} from '@angular/core';
import {UntypedFormBuilder, UntypedFormControl, UntypedFormGroup} from '@angular/forms';
import {Reservation} from "../../shared/reservation";
import {MAT_DIALOG_DATA} from "@angular/material/dialog";
import {HttpClient} from "@angular/common/http";

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

  constructor(public http: HttpClient, private fb: UntypedFormBuilder, @Inject(MAT_DIALOG_DATA) public data: any) { }


  ngOnInit(){
    this.test = this.data.date.toLocaleDateString()

    console.log(this.data)

    this.addressForm = new UntypedFormGroup({
      nachname: new UntypedFormControl(null),
      telefonnummer: new UntypedFormControl(null),
      tischnummer: new UntypedFormControl(this.data.tablenr),
      startzeit: new UntypedFormControl(this.data.starttime),
      endzeit: new UntypedFormControl(this.data.endtime),
      datum: new UntypedFormControl(this.test),
      personenanzahl: new UntypedFormControl('2'),
      vorname: new UntypedFormControl(null),
      email: new UntypedFormControl(null),
      anmerkungen: new UntypedFormControl(null)
    });

  }
newdata: any
  addressForm: any;
  onSubmit(data: any) {
    const formValue = this.addressForm.value;
    const newReservation: Reservation = {
      ...formValue,
    }
    this.submitReservation.emit(newReservation);

    this.newdata = {
      customer:{
        last_name: this.addressForm.nachname,
        telNr: this.addressForm.telefonnummer,
        email: this.addressForm.email,
        first_name: this.addressForm.vorname,
      },
      customer_name: this.addressForm.nachname,
      start_time: this.addressForm.startzeit,
      end_time: this.addressForm.endzeit,
      reservation_date: this.addressForm.datum,
      person_amount: this.addressForm.personenanzahl,
      tableEntity: {
        tableno: this.addressForm.tischnummer
      }
    };

    console.warn(this.newdata)

    this.http.post('http://localhost:8080/reservation/add', this.newdata)
      .subscribe((result)=>{
        console.log(result)
      });

    this.reactiveForm.reset();
  }
}
