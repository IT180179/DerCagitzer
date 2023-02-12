import {LOCALE_ID, NgModule} from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
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
import { CalendarModule, DatePickerModule, TimePickerModule, DateRangePickerModule, DateTimePickerModule } from '@syncfusion/ej2-angular-calendars';
import { SideOverviewComponent } from './site-components/side-overview/side-overview.component';
import { CalendarComponent } from './site-components/calendar/calendar.component';
import {MbscModule} from "@mobiscroll/angular-lite";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatInputModule} from "@angular/material/input";
import {MatCardModule} from "@angular/material/card";
import {MAT_DATE_FORMATS, MAT_DATE_LOCALE, MatNativeDateModule} from "@angular/material/core";
import {MatSelectModule} from "@angular/material/select";
import {AngularDraggableModule} from "angular2-draggable";
import { ResizableModule } from 'angular-resizable-element';
import {RoomCardsComponent} from "./site-components/room-cards/room-cards.component";
import {MatButtonModule} from '@angular/material/button';
import {MatProgressBarModule} from "@angular/material/progress-bar";
import { TabsComponent } from './site-components/tabs/tabs.component';
import {MatTabsModule} from "@angular/material/tabs";
import {EventEmitterService} from "./shared/event-emitter.service";
import { ConfigComponent } from './site-components/config/config.component';
import { TableplanComponent } from './site-components/tableplan/tableplan.component';


@NgModule({
  declarations: [
    AppComponent,
    DayviewPageComponent,
    ReservationPageComponent,
    CreateReservationComponent,
    Dialog,
    SideOverviewComponent,
    CalendarComponent,
    CalendarComponent,
    RoomCardsComponent,
    TabsComponent,
    ConfigComponent,
    TableplanComponent
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
    MatDatepickerModule,
    MatNativeDateModule,
    CalendarModule, DatePickerModule, TimePickerModule, DateRangePickerModule, DateTimePickerModule,
    MbscModule, FormsModule, MatDatepickerModule, MatFormFieldModule, MatSelectModule,
    AngularDraggableModule,
    ResizableModule,
    MatCardModule,
    MatInputModule,
    HttpClientModule,
    MatButtonModule, MatProgressBarModule, MatTabsModule
  ],
  providers: [
    {provide: LOCALE_ID, useValue: 'de'},
    MatDatepickerModule,
    MatNativeDateModule,
    EventEmitterService,
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
