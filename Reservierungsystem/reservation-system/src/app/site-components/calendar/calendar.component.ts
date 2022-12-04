import {Component, EventEmitter, OnInit, Output, ViewChild} from '@angular/core';
import {MatCalendar} from "@angular/material/datepicker";


@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.scss']
})
export class CalendarComponent implements OnInit {

  @ViewChild('calendar', { static: true })
  calendar: MatCalendar<Date>;

  @Output()
  dateSelected: EventEmitter<Date> = new EventEmitter();


  firstDate = new Date();

  secondDate = new Date();
  month2 = this.firstDate.getMonth()+1;

  setSecondMonthRight = this.secondDate.setMonth(this.month2);

  thirdDate = new Date();
  month3 = this.secondDate.getMonth()+1;
  setThirdMonthRight = this.thirdDate.setMonth(this.month3);


  weekendsDatesFilter = (d: Date): boolean => {
    const day = d.getDay();

    /* Prevent Monday and Tueasday for select. */
    return day !== 1 && day !== 2 ;
  }

  constructor() { }

  ngOnInit(): void {


  }

  dateChanged() {

      this.calendar.activeDate = this.firstDate;
      this.dateSelected.emit(this.firstDate);

      console.log(this.firstDate)


  }
}
