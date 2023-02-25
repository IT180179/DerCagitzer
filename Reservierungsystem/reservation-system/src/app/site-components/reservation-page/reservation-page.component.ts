import {Component, ErrorHandler, EventEmitter, Inject, Input, OnInit, Output} from '@angular/core';

import {
  AbstractControl,
  Form,
  FormBuilder,
  FormGroup,
  UntypedFormBuilder,
  UntypedFormControl,
  UntypedFormGroup, ValidationErrors, ValidatorFn,
  Validators
} from '@angular/forms';
import {Reservation} from "../../shared/reservation";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {Dialog} from "../dayview-page/dayview-page.component";
import {DatePipe, Time} from "@angular/common";
import {distinctUntilChanged} from "rxjs";
import {DateAdapter, MAT_DATE_FORMATS, MAT_DATE_LOCALE} from "@angular/material/core";

@Component({
  selector: 'app-reservation-page',
  templateUrl: './reservation-page.component.html',
  styleUrls: ['./reservation-page.component.scss'],
})
export class ReservationPageComponent implements OnInit {

  addressForm: FormGroup;
  errors: any = {};
  checkTime: boolean = true;

  @Input() reservation?: Reservation;
  @Output() submitReservation = new EventEmitter<Reservation>();

  today = new Date();
  test: Date;
  private endzeit: any;

  constructor(private fb: FormBuilder,
              private errorHandler: ErrorHandler,
              public dialogRef: MatDialogRef<Dialog>,
              public http: HttpClient,
              @Inject(MAT_DIALOG_DATA) public data: any, private route: ActivatedRoute,
              private router: Router,
  ) {
  }


  seats: any;
  ngOnInit(): void {

    console.log( this.data.table)

    console.log(this.startZeit)

    this.today = new Date()
    this.test = this.data.date.toLocaleDateString()

    console.log(this.test)

    this.seats = this.data.table.seats;



    if (!this.data.isUpdate) {

      this.addressForm = new UntypedFormGroup({
        name: new UntypedFormControl(null,
          [Validators.required, Validators.minLength(2)]),
        telefonnummer: new UntypedFormControl(null, [Validators.minLength(8)]),
        startzeit: new UntypedFormControl(this.data.starttime, [Validators.required]),
        endzeit: new UntypedFormControl(this.data.endtime, [Validators.required]),
        datum: new UntypedFormControl(this.data.date),
        personenanzahl: new UntypedFormControl('2', [Validators.required, Validators.max(this.seats), Validators.min(1)]),
        email: new UntypedFormControl(null, Validators.email),
        anmerkungen: new UntypedFormControl(null)
      });
    }else {
      this.addressForm = new UntypedFormGroup({
        name: new UntypedFormControl(this.data.updateRes.customer_name,
          [Validators.required, Validators.minLength(2)]),
        telefonnummer: new UntypedFormControl(this.data.updateRes, [Validators.minLength(8)]),
        startzeit: new UntypedFormControl(this.data.starttime, [Validators.required]),
        endzeit: new UntypedFormControl(this.data.endtime, [Validators.required]),
        datum: new UntypedFormControl(this.data.date),
        personenanzahl: new UntypedFormControl('2', [Validators.required, Validators.max(this.seats), Validators.min(1)]),
        email: new UntypedFormControl(null, Validators.email),
        anmerkungen: new UntypedFormControl(null)
      });
    }


    this.addressForm.get('startzeit').valueChanges.subscribe(value => {

      var checkStart = this.formatTime(value, "h:m");
      console.log(checkStart)
      var checkEnd = this.formatTime(this.addressForm.get('endzeit').value,"h:m");
      if (checkStart >= checkEnd){
        this.checkTime = false
      }else {
       this.checkTime = true
      }
        console.log(this.checkTime);
    }
    )
    this.addressForm.get('endzeit').valueChanges.subscribe(value => {


        var checkStart = this.formatTime(value, "h:m");
        console.log(checkStart)
        var checkEnd = this.formatTime(this.addressForm.get('endzeit').value,"h:m");
        if (checkStart >= checkEnd){
          this.checkTime = false
        }else {
          this.checkTime = true
        }
        console.log(this.checkTime);
      }
    )

    this.addressForm.patchValue({datum: this.data.date})
    this.addressForm.patchValue({tischnummer: this.data.tablenr})


  }

  validateTime(control: AbstractControl){
    var checkStart = this.formatTime(control.value('startzeit'), "h:m");
    var checkEnd = this.formatTime(control.value('endzeit'),"h:m");
    if (checkStart >= checkEnd){
      return {invalidTime: true}
    }else {
      return null
    }

  }

  formatTime(dStr, format){
    var now = new Date();
    now.setHours(dStr.substr(0,dStr.indexOf(":")));
    now.setMinutes(dStr.substr(dStr.indexOf(":")+1));
    now.setSeconds(0);
    return now;
  }


  newdata: any

  onSubmit(data: any) {
    const formValue = this.addressForm.value;
    const newReservation: Reservation = {
      ...formValue,
    }
    this.submitReservation.emit(newReservation);

    this.newdata = {
      customer: null,
      customer_name: data.name,
      start_time: data.startzeit,
      end_time: data.endzeit,
      reservation_date: data.datum.toLocaleDateString(),
      person_amount: Number(data.personenanzahl),
      tableEntity: {
        tableno: Number(this.data.table.tableno)
      },
      employee: {
        employee_id: 1
      }
    };

    console.log(this.newdata)
    this.http.post('http://localhost:8080/reservation/add', this.newdata)
      .subscribe((result) => {
        this.router.navigate(['..'], {relativeTo: this.route})
        console.log(result)
      });
    this.dialogRef.close();
    this.addressForm.reset();
  }


  weekendsDatesFilter = (d: Date): boolean => {
    const day = d.getDay();

    /* Prevent Monday and Tueasday for select. */
    return day !== 1 && day !== 2;
  }
  selectedOption: any;
  startZeit: any;

  onNoClick(): void {

    this.dialogRef.close();
  }


  timeChanged() {

    var array = this.startZeit.split(":");
    var seconds = (parseInt(array[0], 10) * 60 * 60) + (parseInt(array[1], 10) * 60) + parseInt(array[2], 10)

    console.log(seconds)

   // var array = this.startZeit.split(":");
   // var seconds = (parseInt(array[0], 10) * 60 * 60) + (parseInt(array[1], 10) * 60) + parseInt(array[2], 10)


    this.startZeit = this.addressForm.get("startzeit").value
    console.log(this.startZeit)

    this.endzeit=this.addressForm.get("endzeit").value
    console.log(this.endzeit)

    console.log(this.startZeit.toNumber() - this.endzeit.toNumber() )
  }
}
