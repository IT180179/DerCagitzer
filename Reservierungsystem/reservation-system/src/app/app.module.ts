import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { DayviewPageComponent } from './site-components/dayview-page/dayview-page.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {NgWfTimetableModule} from "ng2-wf-timetable";

@NgModule({
  declarations: [
    AppComponent,
    DayviewPageComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        BrowserAnimationsModule,
        NgWfTimetableModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
