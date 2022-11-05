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

  data: any;
  tablenr: any;
  ngOnInit(): void {

    this.data = [
      {
        time: 11,
        name: 'Powers Schneider',
        reservation: false
      },
      {
        time: 12,
        name: 'Adrian Lawrence',
        reservation: false
      },
      {
        time: 13,
        name: 'Boyer Stanley',
        reservation: false
      },
      {
        time: 14,
        name: 'Powers Schneider',
        reservation: false
      },
      {
        time: 15,
        name: 'Adrian Lawrence',
        reservation: false
      },
      {
        time: 16,
        name: 'Boyer Stanley',
        reservation: false
      },
      {
        time: 17,
        name: 'Powers Schneider',
        reservation: false
      },
      {
        time: 18,
        name: 'Adrian Lawrence',
        reservation: false
      },
      {
        time: 19,
        name: 'Boyer Stanley',
        reservation: false
      },
      {
        time: 20,
        name: 'Adrian Lawrence',
        reservation: false
      },
      {
        time: 21,
        name: 'Boyer Stanley',
        reservation: false
      },
      {
        time: 22,
        name: 'Boyer Stanley',
        reservation: false
      },
    ]

    this.tablenr = [
      {
        nr: 1
      },
      {
        nr: 2
      },
      {
        nr: 3
      },
      {
        nr: 4
      },
      {
        nr: 5
      },
      {
        nr: 6
      },
      {
        nr: 7
      },
      {
        nr: 8
      },
      {
        nr: 9
      },
      {
        nr: 10
      },
      {
        nr: 11
      },
      {
        nr: 12
      },
      {
        nr: 1
      },
      {
        nr: 2
      },
      {
        nr: 3
      },
      {
        nr: 4
      },
      {
        nr: 5
      },
      {
        nr: 6
      },
      {
        nr: 7
      },
      {
        nr: 8
      },
      {
        nr: 9
      },
      {
        nr: 10
      },
      {
        nr: 11
      },
      {
        nr: 12
      },
    ]
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
