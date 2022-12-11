import {Component, ErrorHandler, EventEmitter, Inject, Input, OnInit, Output} from '@angular/core';
import {
  Form,
  FormBuilder,
  FormGroup,
  UntypedFormBuilder,
  UntypedFormControl,
  UntypedFormGroup,
  Validators
} from '@angular/forms';
import {Reservation} from "../../shared/reservation";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {HttpClient} from "@angular/common/http";
import {ActivatedRoute, Router} from "@angular/router";
import {Dialog} from "../dayview-page/dayview-page.component";

@Component({
  selector: 'app-reservation-page',
  templateUrl: './reservation-page.component.html',
  styleUrls: ['./reservation-page.component.scss']
})
export class ReservationPageComponent implements OnInit {

  addressForm: FormGroup;
  errors: any = {};

  @Input() reservation?: Reservation;
  @Output() submitReservation = new EventEmitter<Reservation>();

  today = new Date();
  test: Date;


  constructor(private fb: FormBuilder,
              private errorHandler:ErrorHandler,
              public dialogRef: MatDialogRef<Dialog>,
              public http: HttpClient,
              @Inject(MAT_DIALOG_DATA) public data: any,private route: ActivatedRoute,
              private router: Router
              ) { }


  ngOnInit(): void{


    this.test = this.data.date.toLocaleDateString()

    console.log(this.test)

    this.addressForm = new UntypedFormGroup({
      name: new UntypedFormControl(null,
         [Validators.required, Validators.minLength(2)]),
      telefonnummer: new UntypedFormControl(null, [Validators.required, Validators.minLength(8)]),
      tischnummer: new UntypedFormControl(this.data.tablenr, Validators.max(3)),
      startzeit: new UntypedFormControl(this.data.starttime),
      endzeit: new UntypedFormControl(this.data.endtime),
      datum: new UntypedFormControl(this.test),
      personenanzahl: new UntypedFormControl('2'),
      vorname: new UntypedFormControl(null),
      email: new UntypedFormControl(null, Validators.email),
      anmerkungen: new UntypedFormControl(null)
    });

  console.log(this.addressForm.get('datum').value)


    this.addressForm.patchValue({datum: this.test})
    this.addressForm.patchValue({tischnummer: this.data.tablenr})


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
      customer_name: data.nachname,
      start_time: data.startzeit,
      end_time: data.endzeit,
      reservation_date: data.datum,
      person_amount: Number(data.personenanzahl),
      tableEntity: {
        tableno: Number(data.tischnummer)
      },
      employee: {
        employee_id: 1
      }
    };

    console.log(this.newdata)
    this.http.post('http://localhost:8080/reservation/add', this.newdata)
      .subscribe((result)=>{
        this.router.navigate(['..'], {relativeTo: this.route})
        console.log(result)
      });
    this.dialogRef.close();

    this.addressForm.reset();

  }


  weekendsDatesFilter = (d: Date): boolean => {
    const day = d.getDay();

    /* Prevent Monday and Tueasday for select. */
    return day !== 1 && day !== 2 ;
  }

  onNoClick(): void {

    this.dialogRef.close();
  }
}
