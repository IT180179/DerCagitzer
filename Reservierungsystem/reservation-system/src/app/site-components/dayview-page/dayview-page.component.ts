import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {TimetableEvent, TimetableLocation, TimetableSchedule, TimetableScope} from "ng2-wf-timetable";
import {ReservationService} from "../../shared/reservation.service";
import {Reservation} from "../../shared/reservation";
import {MatDialog, MatDialogRef} from "@angular/material/dialog";
import {ReservationPageComponent} from "../reservation-page/reservation-page.component";


@Component({
  selector: 'app-dayview-page',
  templateUrl: './dayview-page.component.html',
  styleUrls: ['./dayview-page.component.scss']
})

export class DayviewPageComponent implements OnInit {
  reservations?: Reservation[];

  today = new Date().toLocaleDateString();
  now = new Date()
  current = new Date().toLocaleDateString();
  i = 0;

  scope!: TimetableScope;
  schedules!: Array<TimetableSchedule>;

  constructor(private rs: ReservationService, public dialog: MatDialog) {

  }

  ngOnInit(): void {

  }


  eventClicked(event: TimetableEvent): void {
    this.openDialog();
  }

  back() {

    this.today = (this.now.getDate() - 1) + "." + (this.now.getMonth()) + "." + this.now.getFullYear();
    if (this.now.getDate() - 1 == 0) {
      // this.today = (this.now.getDate()-1)+ "."+ (this.now.getMonth())+"."+ this.now.getFullYear();
    }
    this.now.setDate(this.now.getDate() - 1);
    this.now.setMonth(this.now.getMonth());
    this.now.setFullYear(this.now.getFullYear());


    //   this.i = this.now.getDate()-1;
    // console.log(this.i)
  }

  forward() {
    this.today = (this.now.getDate() + 1) + "." + (this.now.getMonth()) + "." + this.now.getFullYear();

    this.now.setDate(this.now.getDate() + 1);
    this.now.setMonth(this.now.getMonth());
    this.now.setFullYear(this.now.getFullYear());
  }

  openDialog() {
    this.dialog.open(Dialog, {
      width: '250px',
    });
    console.log(Dialog)

  }


  openReservation(): void {
    const dialogRef = this.dialog.open(ReservationPageComponent, {
      width: '70%',
      height: '70%',
      data: {},
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }


}
@Component({
  templateUrl: 'dialog.html',
})
export class Dialog {
}
