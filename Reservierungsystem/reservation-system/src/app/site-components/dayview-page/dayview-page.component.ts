import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {Timetable} from "../../shared/timetable";

@Component({
  selector: 'app-dayview-page',
  templateUrl: './dayview-page.component.html',
  styleUrls: ['./dayview-page.component.scss']
})
export class DayviewPageComponent implements OnInit {

  constructor() {
    this.timetable = new Timetable();
  }

  @ViewChild('timetable') element: ElementRef;
  timetable: Timetable;

  locations = [];
  events = [];

  ngOnInit(): void {
  }

}
