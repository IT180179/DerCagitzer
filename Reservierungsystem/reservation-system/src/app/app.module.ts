import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ReactiveFormsModule } from '@angular/forms';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {DayviewPageComponent, Dialog} from './site-components/dayview-page/dayview-page.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {NgWfTimetableModule} from "ng2-wf-timetable";
import { ReservationPageComponent } from './site-components/reservation-page/reservation-page.component';
import { CreateReservationComponent } from './site-components/create-reservation/create-reservation.component';
import {HttpClientModule} from "@angular/common/http";
import {MatIconModule} from "@angular/material/icon";
import {MatDialogModule} from "@angular/material/dialog";
import {MatButtonModule} from "@angular/material/button";
import { CalendarModule, DatePickerModule, TimePickerModule, DateRangePickerModule, DateTimePickerModule } from '@syncfusion/ej2-angular-calendars';
import { SideOverviewComponent } from './site-components/side-overview/side-overview.component';
import { TimetableComponent } from './site-components/timetable/timetable.component';
import { FooterComponent } from './site-components/footer/footer.component';



@NgModule({
  declarations: [
    AppComponent,
    DayviewPageComponent,
    ReservationPageComponent,
    CreateReservationComponent,
    Dialog,
    SideOverviewComponent,
    TimetableComponent,
    FooterComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    NgWfTimetableModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatIconModule,
    MatDialogModule,
    MatButtonModule,
    CalendarModule, DatePickerModule, TimePickerModule, DateRangePickerModule, DateTimePickerModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
