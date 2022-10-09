import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DayviewPageComponent } from './site-components/dayview-page/dayview-page.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {NgWfTimetableModule} from "ng2-wf-timetable";
import { ReservationPageComponent } from './site-components/reservation-page/reservation-page.component';

@NgModule({
  declarations: [
    AppComponent,
    DayviewPageComponent,
    ReservationPageComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        NgWfTimetableModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
