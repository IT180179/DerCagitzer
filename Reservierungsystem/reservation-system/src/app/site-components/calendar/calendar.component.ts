import {AfterViewInit, Component, EventEmitter, OnInit, Output, Renderer2, ViewChild} from '@angular/core';
import {MatCalendar} from "@angular/material/datepicker";


@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.scss']
})
export class CalendarComponent implements AfterViewInit {

  @ViewChild('calendar', { static: true })
  calendar: MatCalendar<Date>;

  @ViewChild('calender2', { static: true })
  calendar2: MatCalendar<Date>;

  @ViewChild('calendar3', { static: true })
  calendar3: MatCalendar<Date>;

  @Output()
  dateSelected: EventEmitter<Date> = new EventEmitter();

  @Output()
  monthSelected: EventEmitter<Date> = new EventEmitter();


  firstDate = new Date();
  start0 = new Date()
  start1 = new Date()

  start2 = new Date(this.start0.setMonth(this.firstDate.getMonth()+1));
  start3 = new Date(this.start1.setMonth(this.firstDate.getMonth()+2));
  secondDate?: Date
  thirdDate?: Date

  //secondDate = new Date();
//  month2 = this.firstDate.getMonth()+1;

 // setSecondMonthRight = this.secondDate.setMonth(this.month2);

 // thirdDate = new Date();
 // month3 = this.secondDate.getMonth()+1;
 // setThirdMonthRight = this.thirdDate.setMonth(this.month3);


  weekendsDatesFilter = (d: Date): boolean => {
    const day = d.getDay();

    /* Prevent Monday and Tueasday for select. */
    return day !== 1 && day !== 2 ;

  }

  dateClass = (d: Date) => {
      console.log(d < new Date())


    return (d < new Date()) ? 'highlight-dates' : undefined;
  }

  constructor(private renderer: Renderer2) { }

  ngAfterViewInit(): void {

  }

  prevMonth(){
    const startDate = new Date()
    startDate.setMonth(this.calendar.activeDate.getMonth()-1)
    const startDate2 = new Date()
    startDate2.setMonth(this.calendar2.activeDate.getMonth()-1)
    const startDate3 = new Date()
    startDate3.setMonth(this.calendar3.activeDate.getMonth()-1)


    this.calendar.activeDate = startDate
    this.calendar2.activeDate = startDate2
    this.calendar3.activeDate = startDate3
    this.monthChanged(this.calendar.activeDate)
    this.month2Changed(this.calendar2.activeDate)
    this.month3Changed(this.calendar3.activeDate)

  }

  nextMonth(){
    const startDate = new Date()
    startDate.setMonth(this.calendar.activeDate.getMonth()+1)
    const startDate2 = new Date()
    startDate2.setMonth(this.calendar2.activeDate.getMonth()+1)
    const startDate3 = new Date()
    startDate3.setMonth(this.calendar3.activeDate.getMonth()+1)


    this.calendar.activeDate = startDate
    this.calendar2.activeDate = startDate2
    this.calendar3.activeDate = startDate3
    this.monthChanged(this.calendar.activeDate)
    this.month2Changed(this.calendar2.activeDate)
    this.month3Changed(this.calendar3.activeDate)
  }

  monthChanged(date1: Date){
    this.calendar.activeDate
    this.monthSelected.emit(date1)

  }
  month2Changed(date2: Date){
    this.calendar2.activeDate = date2
    this.monthSelected.emit(date2)
  }
  month3Changed(date3: Date){
    this.calendar3.activeDate = date3
    this.monthSelected.emit(date3)

  }

  dateChanged(dateString: String) {
      if(dateString == 'date1'){
        this.calendar.activeDate = this.firstDate;
        this.secondDate = undefined
        this.thirdDate = undefined
        this.dateSelected.emit(this.firstDate);
      }
      if(dateString == 'date2'){
      this.calendar2.activeDate = this.secondDate;
      this.firstDate = undefined
      this.thirdDate = undefined
      this.dateSelected.emit(this.secondDate);
     }
      if(dateString == 'date3'){
      this.calendar3.activeDate = this.thirdDate;
      this.firstDate = undefined
      this.secondDate = undefined
      this.dateSelected.emit(this.thirdDate);
     }
  }


}
