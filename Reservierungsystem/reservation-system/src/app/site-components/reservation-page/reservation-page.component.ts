import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';


@Component({
  selector: 'app-reservation-page',
  templateUrl: './reservation-page.component.html',
  styleUrls: ['./reservation-page.component.scss']
})
export class ReservationPageComponent implements OnInit {

  title = 'ReactiveForms';
  reactiveForm: FormGroup;

  constructor() { }

  ngOnInit(){

    this.reactiveForm = new FormGroup({
      nachname: new FormControl(null),
      telefonnummer: new FormControl(null),
      tischnummer: new FormControl('2'),
      datum: new FormControl(null),
      personenanzahl: new FormControl('2'),
      zeit: new FormControl(null)


    });

  }

}
