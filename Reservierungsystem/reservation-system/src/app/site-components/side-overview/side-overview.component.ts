import {
  AfterViewInit,
  Component,
  EventEmitter,
  Input,
  OnChanges,
  OnInit,
  Output,
  SimpleChanges,
  ViewChild
} from '@angular/core';
import {Reservation} from "../../shared/reservation";
import {ReservationService} from "../../shared/reservation.service";
import {MatCalendar} from "@angular/material/datepicker";
import {FormBuilder, FormGroup, UntypedFormControl, UntypedFormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-side-overview',
  templateUrl: './side-overview.component.html',
  styleUrls: ['./side-overview.component.scss'],
})
export class SideOverviewComponent implements OnChanges {

  @Input() infoReservation: Reservation;
  resultPerDayNoon: number;
  resultPerDayEvening: number;
  resultPerWeek: number;
  _date: Date;
  start_date: Date;
  end_date: Date;
  updateForm: FormGroup

  @Input() set date(value: Date) {
    this._date = value;
    const _date2 = this._date;
    const _date3 = this._date;
    //this.start_date = new Date(_date2.setDate(_date2.getDate() - _date2.getDay() + 3));
    //this.end_date = new Date(_date3.setDate(_date3.getDate() - _date3.getDay() + 7));
    this.reservationsPerDayNoon(this._date.toLocaleDateString());
    this.reservationsPerDayEvening(this._date.toLocaleDateString());
    this.reservationsPerWeek((this._date.getDate() - this._date.getDate() + 3).toLocaleString(), (this._date.getDate() - this._date.getDate() + 3).toLocaleString() + 7);
  }





  constructor(private rs: ReservationService, private fb: FormBuilder, private router: Router) {}


  ngOnChanges(): void {
    this.updateForm = new UntypedFormGroup({
      name: new UntypedFormControl(this.infoReservation.customer_name,
        [Validators.required, Validators.minLength(2)]),
      tischnummer: new UntypedFormControl(this.infoReservation.tableEntity.tableno, Validators.max(3)),
      personenanzahl: new UntypedFormControl(this.infoReservation.person_amount),

    });
  }



  updateReservation() {
    this.infoReservation.customer_name = this.updateForm.get('name').value
    this.infoReservation.tableEntity.tableno = this.updateForm.get('tischnummer').value
    this.infoReservation.person_amount = this.updateForm.get('personenanzahl').value

    this.rs.update(this.infoReservation).subscribe({
      complete: () => {

      }
    });

  }

  deleteReservation(id: number) {
    this.rs.delete(id).subscribe({
      complete: () => {
      }
    });
  }

  reservationsPerDayNoon(date: String) {

    this.rs.countReservationsPerDayNoon(date).subscribe(
      (r: number) => {
        this.resultPerDayNoon = Math.round(r * 100);
      }
    )
  }

  reservationsPerDayEvening(date: String) {
    this.rs.countReservationsPerDayEvening(date).subscribe(
      (r: number) => {
        this.resultPerDayEvening = Math.round(r * 100);
      }
    )
  }

  reservationsPerWeek(start_date: String, end_date: String) {
    this.rs.countReservationsPerWeek(start_date, end_date).subscribe(
      (r: number) => {
        this.resultPerWeek = Math.round(r * 100);
        if(this.resultPerWeek == 0) {
          this.resultPerWeek = 1;
        }
      }
    )
  }
}
