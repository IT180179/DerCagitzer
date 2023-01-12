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

  @Output()
  dateSelected: EventEmitter<Date> = new EventEmitter();


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

  constructor(private renderer: Renderer2) { }

  ngAfterViewInit(): void {
    const buttons = document
      .querySelectorAll('.mat-calendar-previous-button, .mat-calendar-next-button');

    if (buttons) {
      Array.from(buttons).forEach(button => {
        this.renderer.listen(button, 'click', () => {
          console.log(button)

          //this.calendar.activeDate.setMonth(this.calendar.activeDate.getMonth()+1);
        });
      });
    }

  }



  dateChanged(dateString: String) {
      if(dateString == 'date1'){
        this.calendar.activeDate = this.firstDate;
        this.secondDate = undefined
        this.thirdDate = undefined
        this.dateSelected.emit(this.firstDate);
      }
      if(dateString == 'date2'){
      this.calendar.activeDate = this.secondDate;
      this.firstDate = undefined
      this.thirdDate = undefined
      this.dateSelected.emit(this.secondDate);
     }
      if(dateString == 'date3'){
      this.calendar.activeDate = this.thirdDate;
      this.firstDate = undefined
      this.secondDate = undefined
      this.dateSelected.emit(this.thirdDate);
     }
  }


}
