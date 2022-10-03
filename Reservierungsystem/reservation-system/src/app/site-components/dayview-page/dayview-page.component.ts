import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {TimetableEvent, TimetableLocation, TimetableSchedule, TimetableScope} from "ng2-wf-timetable";


@Component({
  selector: 'app-dayview-page',
  templateUrl: './dayview-page.component.html',
  styleUrls: ['./dayview-page.component.scss']
})
export class DayviewPageComponent implements OnInit {


  scope!: TimetableScope;
  schedules!: Array<TimetableSchedule>;

  constructor() {
  }

  ngOnInit(): void {
    /*
    The timetable scope which contain params in the following order:
    1. Timetable start time: Date
    2. Timetable end time: Date
    3. (Optional) Number of pixels that should represent 5 minutes (32px by default): number
    */
    const timetableStartTime = new Date(new Date().setHours(8, 0, 0));
    const timetableEndTime = new Date(new Date().setHours(16, 0, 0));

    this.scope = new TimetableScope(timetableStartTime, timetableEndTime);

    /*
    Each timetable schedule contains:
    1. Timetable location: TimetableLocation;

    - Timetable location contains the following params in order:
    `id: string`, `name: string`
    e.g new TimetableLocation('0', 'Room 1')


    2. Array of Timetable events: Array<TimetableEvent>

    - Timetable event contains the following params in order:
    `id: string`, `startTime: Date`, `endTime: Date`, `title: string`, `(optional) details: string`, `(optional) color: string`
    */

    this.schedules = [
      new TimetableSchedule(
        new TimetableLocation('0', 'Room 1'),
        /* Timetable location contains the following params in order: `id: string`, `name: string`*/
        [
          new TimetableEvent('01',
            new Date(new Date().setHours(8, 0, 0)),
            new Date(new Date().setHours(8, 30, 0)), 'Event 1', 'Staff meeting', '#ff0000')
        ]
      ),

      new TimetableSchedule(
        new TimetableLocation('1', 'Room 2'),
        [
          new TimetableEvent('02',
            new Date(new Date().setHours(9, 0, 0)),
            new Date(new Date().setHours(9, 30, 0)), 'Event 2', 'Student meeting')
        ]
      )
    ];
  }

  eventClicked(event: TimetableEvent): void {
    window.alert(event.title);
  }

}
