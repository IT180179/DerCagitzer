import {Component, ElementRef, Inject, OnInit, ViewChild} from '@angular/core';
import {TimetableEvent, TimetableLocation, TimetableSchedule, TimetableScope} from "ng2-wf-timetable";
import {ReservationService} from "../../shared/reservation.service";
import {Reservation} from "../../shared/reservation";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {ReservationPageComponent} from "../reservation-page/reservation-page.component";


@Component({
  selector: 'app-dayview-page',
  templateUrl: './dayview-page.component.html',
  styleUrls: ['./dayview-page.component.scss']
})

export class DayviewPageComponent implements OnInit {

  reservations: Reservation[] = [];

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
  date = new Date();


  ngOnInit(): void {
    this.loadReservations(this.date)


    this.data = [
      {
        time: 11,
        fulltime: '11:00',
        name: 'Powers Schneider',
        reservation: false
      },
      {
        time: 12,
        fulltime: '12:00',
        name: 'Adrian Lawrence',
        reservation: false
      },
      {
        time: 13,
        fulltime: '13:00',
        name: 'Boyer Stanley',
        reservation: false
      },
      {
        time: 14,
        fulltime: '14:00',
        name: 'Powers Schneider',
        reservation: false
      },
      {
        time: 15,
        fulltime: '15:00',
        name: 'Adrian Lawrence',
        reservation: false
      },
      {
        time: 16,
        fulltime: '16:00',
        name: 'Boyer Stanley',
        reservation: false
      },
      {
        time: 17,
        fulltime: '17:00',
        name: 'Powers Schneider',
        reservation: false
      },
      {
        time: 18,
        fulltime: '18:00',
        name: 'Adrian Lawrence',
        reservation: false
      },
      {
        time: 19,
        fulltime: '19:00',
        name: 'Boyer Stanley',
        reservation: false
      },
      {
        time: 20,
        fulltime: '20:00',
        name: 'Adrian Lawrence',
        reservation: false
      },
      {
        time: 21,
        fulltime: '21:00',
        name: 'Boyer Stanley',
        reservation: false
      },
      {
        time: 22,
        fulltime: '22:00',
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
        nr: 13
      },
      {
        nr: 14
      },
      {
        nr: 15
      },
      {
        nr: 16
      },
      {
        nr: 17
      },
      {
        nr: 18
      },
      {
        nr: 19
      },
      {
        nr: 20
      },
      {
        nr: 21
      },
      {
        nr: 22
      },
      {
        nr: 23
      },
      {
        nr: 24
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


  openReservation(tablenr: number, data: string, date: Date): void {
    console.log(date)
    const dialogRef = this.dialog.open(ReservationPageComponent, {
      width: '70%',
      height: '70%',
      data: {tablenr: tablenr, data: data, date: date},
    });

    dialogRef.afterClosed().subscribe(result => {
      console.log('The dialog was closed');
    });
  }

  loadReservations(date: Date){
    this.rs.getAll().subscribe(
      (r: Reservation[]) => {

        for (let i = 0; i < r.length; i++) {

          if (Array.from(r[i].reservation_date.toLocaleString())[0] == "0"){
             var checkdate = "0" + this.date.toLocaleDateString()
          }else{
              checkdate = this.date.toLocaleDateString()
          }

          if (r[i].reservation_date.toLocaleString() == checkdate) {
            this.reservations.push(r[i]);
            console.log("tes")
            console.log(this.reservations)
          }

        }
      }
    )
  }

  dateSelected(value: Date) {
      this.date = value
      console.log(value)
      this.loadReservations(this.date)
      this.reservations = [];
  }

  resInfo(reservation: Reservation) {
    console.log(reservation)
    this.dialog.open(Dialog, {
      data: {
        name: reservation.customer_name,
        persons: reservation.person_amount
      },
    });
  }
}


@Component({
  templateUrl: 'dialog.html',
})
export class Dialog {
  constructor(@Inject(MAT_DIALOG_DATA) public data: any) {}
}
