import {AfterViewInit, Component, ElementRef, Inject, Input, OnInit, ViewChild} from '@angular/core';
import {TimetableEvent, TimetableLocation, TimetableSchedule, TimetableScope} from "ng2-wf-timetable";
import {ReservationService} from "../../shared/reservation.service";
import {Reservation} from "../../shared/reservation";
import {MAT_DIALOG_DATA, MatDialog, MatDialogRef} from "@angular/material/dialog";
import {ReservationPageComponent} from "../reservation-page/reservation-page.component";
import {ResizeEvent} from "angular-resizable-element";
import {DomSanitizer, SafeStyle} from "@angular/platform-browser";
import {Element} from "@angular/compiler";
import {DataService} from "../../services/data.service";
import {SideOverviewService} from "../../shared/side-overview.service";


@Component({
  selector: 'app-dayview-page',
  templateUrl: './dayview-page.component.html',
  styleUrls: ['./dayview-page.component.scss']
})

export class DayviewPageComponent implements AfterViewInit{

  @ViewChild('resize') resize: ElementRef;

  @Input() Room: any;


  style: SafeStyle;

  reservations: Reservation[] = [];

  today = new Date().toLocaleDateString();
  now = new Date()
  current = new Date().toLocaleDateString();
  i = 0;

  scope!: TimetableScope;
  schedules!: Array<TimetableSchedule>;

  resizeObserver = new ResizeObserver(() =>{
    /*
    if (this.resize.nativeElement.offsetWidth % 50 != 0){
      this.resize.nativeElement.offsetWidth = this.resize.nativeElement.offsetWidth - (this.resize.nativeElement.offsetWidth % 50);

    }*/
    console.log(this.resize.nativeElement.offsetWidth )
  })

  constructor(private rs: ReservationService, public dialog: MatDialog, public dataService: DataService, public sos: SideOverviewService) {
  }

  infoReservation: Reservation;

  getInformation(reservation: Reservation) {
    this.infoReservation = reservation;
  }

  data: any;
  tablenr: any;
  date = new Date();
  alltabels: any;

  ngAfterViewInit() {
    console.log(this.resize)
    this.resizeObserver.observe(this.resize.nativeElement)

  }

  tabels: any;

  ngOnInit(): void {

    console.log(this.Room)

    this.tabels = this.dataService.getTabels(this.Room)
      .subscribe((result)=>{
        this.tabels = result
        console.log(this.tabels)
      });

    console.log("All Tabels")
    this.alltabels = this.dataService.getAllTabels()
      .subscribe((result)=>{
        this.alltabels = result
        console.log(this.alltabels)
      });

    this.getTablesperRoom();
    this.getReservationperRoom();

    this.loadReservations()


    this.data = [
      {
        time: 1,
        fulltime: '11:00',
        reservation: false
      },
      {
        time: 2,
        fulltime: '11:30',
        reservation: false
      },
      {
        time: 3,
        fulltime: '12:00',
        reservation: false
      },
      {
        time: 4,
        fulltime: '12:30',
        reservation: false
      },
      {
        time: 5,
        fulltime: '13:00',
        reservation: false
      },
      {
        time: 6,
        fulltime: '13:30',
        reservation: false
      },
      {
        time: 7,
        fulltime: '14:00',
        reservation: false
      },
      {
        time: 8,
        fulltime: '14:30',
        reservation: false
      },
      {
        time: 9,
        fulltime: '15:00',
        reservation: false
      },
      {
        time: 10,
        fulltime: '15:30',
        reservation: false
      },
      {
        time: 11,
        fulltime: '16:00',
        reservation: false
      },
      {
        time: 12,
        fulltime: '16:30',
        reservation: false
      },
      {
        time: 13,
        fulltime: '17:00',
        reservation: false
      },
      {
        time: 14,
        fulltime: '17:30',
        reservation: false
      },
      {
        time: 15,
        fulltime: '18:00',
        reservation: false
      },
      {
        time: 16,
        fulltime: '18:30',
        reservation: false
      },
      {
        time: 17,
        fulltime: '19:00',
        reservation: false
      },
      {
        time: 18,
        fulltime: '19:30',
        reservation: false
      },
      {
        time: 19,
        fulltime: '20:00',
        reservation: false
      },
      {
        time: 20,
        fulltime: '20:30',
        reservation: false
      },
      {
        time: 21,
        fulltime: '21:00',
        reservation: false
      },
      {
        time: 22,
        fulltime: '21:30',
        reservation: false
      },
      {
        time: 23,
        fulltime: '22:00',
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
    this.sos.room(this.Room)
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


  openReservation(time: number, table: number, date: Date): void {
    console.log(date)
  /*
    var style = window.getComputedStyle(element.target);
    var matrix = new WebKitCSSMatrix(style.webkitTransform);
    var width = element.target.offsetWidth / 50 + 1;

    var table = (matrix.m42 / 50) + 1
    var time = (matrix.m41 / 50) + 1

   */
    var endtime = time + 4 ;
    for (let i = 0; i < this.data.length; i++){
      if (this.data[i].time == time){
        var t = this.data[i].fulltime;

      }
      if (this.data[i].time == endtime){
        var et = this.data[i].fulltime;

      }
    }
    console.log('translateX: ', table);
    console.log('translateY: ', t);


    const dialogRef = this.dialog.open(ReservationPageComponent, {
      width: '75%',
      height: '95%',
      data: {tablenr: table, starttime: t, endtime: et, date: date},
      backdropClass: 'backdropBackground'
    });

    dialogRef.afterClosed().subscribe(result => {
      this.loadReservations()
    });


  }


  loadReservations(){
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
      this.loadReservations()
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

  convertToNumber(endtime: String, starttime: String): number{
    for (let i = 0; i < this.data.length; i++) {
      if (this.data[i].fulltime == starttime) {
        var st = this.data[i].time;

      }
      if (this.data[i].fulltime == endtime) {
        var et = this.data[i].time;

      }
    }
    return (et-st);
  }
  updateReservation(element, reservation: Reservation){
    console.log(element)

    for (let i = 0; i < this.data.length; i++) {
      if (this.data[i].fulltime == reservation.start_time) {
        var st = this.data[i].time;

      }
      if (this.data[i].fulltime == reservation.end_time) {
        var et = this.data[i].time;

      }
    }

    var starttime = st * 50 + element.x
    var endtime = et * 50 + element.x

    console.log(starttime)

    for (let i = 0; i < this.data.length; i++){
      if (this.data[i].time == (starttime / 50)){
        var st_full = this.data[i].fulltime;

      }
      if (this.data[i].time == (endtime/ 50)){
        var et_full = this.data[i].fulltime;

      }
    }

    reservation.tableEntity.tableno = reservation.tableEntity.tableno + element.y / 50;
    reservation.start_time = st_full;
    reservation.end_time = et_full;

    this.rs.update(reservation).subscribe(() =>{
      console.log(reservation)
      this.loadReservations();
    })


  }

  public getReservationperRoom() {

  }

  public getTablesperRoom() {

  }
}

@Component({
  templateUrl: 'dialog.html',
})
export class Dialog {
  constructor(@Inject(MAT_DIALOG_DATA) public data: any) {}
}
