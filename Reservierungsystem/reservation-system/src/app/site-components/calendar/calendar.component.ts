import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-calendar',
  templateUrl: './calendar.component.html',
  styleUrls: ['./calendar.component.scss']
})
export class CalendarComponent implements OnInit {

  today = new Date();
  month2 = this.today.getMonth()+1;
  secondDate = new Date(2022, 12,0);
  month3 = this.today.getMonth()+2;
  thirdDate = new Date(2023,1,0);

  weekendsDatesFilter = (d: Date): boolean => {
    const day = d.getDay();

    /* Prevent Monday and Tueasday for select. */
    return day !== 1 && day !== 2 ;
  }



  constructor() { }

  ngOnInit(): void {



  }

}
