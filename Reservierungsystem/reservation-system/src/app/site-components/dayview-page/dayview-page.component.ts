import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {TimetableEvent, TimetableLocation, TimetableSchedule, TimetableScope} from "ng2-wf-timetable";
import {ReservationService} from "../../shared/reservation.service";
import {Reservation} from "../../shared/reservation";


@Component({
  selector: 'app-dayview-page',
  templateUrl: './dayview-page.component.html',
  styleUrls: ['./dayview-page.component.scss']
})
export class DayviewPageComponent implements OnInit {
  reservations: Reservation[] = [];

  today = new Date().toLocaleDateString();
  now = new Date()

  scope!: TimetableScope;
  schedules!: Array<TimetableSchedule>;

  constructor(private rs: ReservationService) {
  }

  ngOnInit(): void {



    this.rs.getAll().subscribe(res=> this.reservations = res);
    /*
    The timetable scope which contain params in the following order:
    1. Timetable start time: Date
    2. Timetable end time: Date
    3. (Optional) Number of pixels that should represent 5 minutes (32px by default): number
    */
    const timetableStartTime = new Date(new Date().setHours(11, 0, 0));
    const timetableEndTime = new Date(new Date().setHours(22, 0, 0));

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
        new TimetableLocation('0', '1'),
        /* Timetable location contains the following params in order: `id: string`, `name: string`*/
        [
          new TimetableEvent('01',
            new Date(new Date().setHours(11, 30, 0)),
            new Date(new Date().setHours(14, 30, 0)), 'Hoflehner', 'Staff meeting', '#265F19')
        ]
      ),

      new TimetableSchedule(
        new TimetableLocation('1', '2'),
        [
          new TimetableEvent('02',
            new Date(new Date().setHours(12, 0, 0)),
            new Date(new Date().setHours(15, 0, 0)), 'Bauer', 'Student meeting', '#265F19'),

          new TimetableEvent('03',
            new Date(new Date().setHours(17, 0, 0)),
            new Date(new Date().setHours(19, 0, 0)), 'Mair', 'Student meeting', '#265F19')
        ]
      ),

      new TimetableSchedule(
        new TimetableLocation('2', '3'),
        [
          new TimetableEvent('04',
            new Date(new Date().setHours(9, 0, 0)),
            new Date(new Date().setHours(9, 30, 0)), 'Event 3', 'Student meeting', '#265F19')
        ]
      ),

      new TimetableSchedule(
        new TimetableLocation('3', '4'),
        [
          new TimetableEvent('05',
            new Date(new Date().setHours(11, 0, 0)),
            new Date(new Date().setHours(13, 30, 0)), 'Hofer', 'Student meeting','#265F19'),

          new TimetableEvent('06',
            new Date(new Date().setHours(18, 30, 0)),
            new Date(new Date().setHours(20, 30, 0)), 'Smith', 'Student meeting', '#265F19')
        ]
      ),

      new TimetableSchedule(
        new TimetableLocation('4', '5'),
        [
          new TimetableEvent('07',
            new Date(new Date().setHours(9, 0, 0)),
            new Date(new Date().setHours(9, 30, 0)), 'Event 4', 'Student meeting')
        ]
      )
      ,

      new TimetableSchedule(
        new TimetableLocation('5', '6'),
        [
          new TimetableEvent('08',
            new Date(new Date().setHours(9, 0, 0)),
            new Date(new Date().setHours(9, 30, 0)), 'Event 4', 'Student meeting')
        ]
      ),

      new TimetableSchedule(
        new TimetableLocation('6', '7'),
        [
          new TimetableEvent('09',
            new Date(new Date().setHours(9, 0, 0)),
            new Date(new Date().setHours(9, 30, 0)), 'Event 4', 'Student meeting')
        ]
      )
      ,

      new TimetableSchedule(
        new TimetableLocation('7', '8'),
        [
          new TimetableEvent('10',
            new Date(new Date().setHours(9, 0, 0)),
            new Date(new Date().setHours(9, 30, 0)), 'Event 4', 'Student meeting')
        ]
      ),

      new TimetableSchedule(
        new TimetableLocation('8', '9'),
        [
          new TimetableEvent('11',
            new Date(new Date().setHours(9, 0, 0)),
            new Date(new Date().setHours(9, 30, 0)), 'Event 4', 'Student meeting')
        ]
      ),

      new TimetableSchedule(
        new TimetableLocation('9', '10'),
        [
          new TimetableEvent('12',
            new Date(new Date().setHours(9, 0, 0)),
            new Date(new Date().setHours(9, 30, 0)), 'Event 4', 'Student meeting')
        ]
      ),

      new TimetableSchedule(
        new TimetableLocation('10', '11'),
        [
          new TimetableEvent('13',
            new Date(new Date().setHours(9, 0, 0)),
            new Date(new Date().setHours(9, 30, 0)), 'Event 4', 'Student meeting')
        ]
      ),

      new TimetableSchedule(
        new TimetableLocation('11', '12'),
        [
          new TimetableEvent('14',
            new Date(new Date().setHours(9, 0, 0)),
            new Date(new Date().setHours(9, 30, 0)), 'Event 4', 'Student meeting')
        ]
      ),

      new TimetableSchedule(
        new TimetableLocation('13', '14'),
        [
          new TimetableEvent('15',
            new Date(new Date().setHours(9, 0, 0)),
            new Date(new Date().setHours(9, 30, 0)), 'Event 4', 'Student meeting')
        ]
      ),

      new TimetableSchedule(
        new TimetableLocation('14', '15'),
        [
          new TimetableEvent('16',
            new Date(new Date().setHours(9, 0, 0)),
            new Date(new Date().setHours(9, 30, 0)), 'Event 4', 'Student meeting')
        ]
      ),

      new TimetableSchedule(
        new TimetableLocation('15', '16'),
        [
          new TimetableEvent('17',
            new Date(new Date().setHours(9, 0, 0)),
            new Date(new Date().setHours(9, 30, 0)), 'Event 4', 'Student meeting')
        ]
      ),

      new TimetableSchedule(
        new TimetableLocation('16', '17'),
        [
          new TimetableEvent('18',
            new Date(new Date().setHours(9, 0, 0)),
            new Date(new Date().setHours(9, 30, 0)), 'Event 4', 'Student meeting')
        ]
      ),

      new TimetableSchedule(
        new TimetableLocation('18', '19'),
        [
          new TimetableEvent('20',
            new Date(new Date().setHours(9, 0, 0)),
            new Date(new Date().setHours(9, 30, 0)), 'Event 4', 'Student meeting')
        ]
      ),

      new TimetableSchedule(
        new TimetableLocation('19', '20'),
        [
          new TimetableEvent('21',
            new Date(new Date().setHours(9, 0, 0)),
            new Date(new Date().setHours(9, 30, 0)), 'Event 4', 'Student meeting')
        ]
      )
      ,

      new TimetableSchedule(
        new TimetableLocation('20', '21'),
        [
          new TimetableEvent('22',
            new Date(new Date().setHours(9, 0, 0)),
            new Date(new Date().setHours(9, 30, 0)), 'Event 4', 'Student meeting')
        ]
      )
    ];
  }

  eventClicked(event: TimetableEvent): void {
    window.alert(event.title);
  }

  back() {

  }
  forward() {
    
  }
}
