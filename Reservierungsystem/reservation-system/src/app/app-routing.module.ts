import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DayviewPageComponent} from "./site-components/dayview-page/dayview-page.component";
import {ReservationPageComponent} from "./site-components/reservation-page/reservation-page.component";

const routes: Routes = [
  {path: '', component: DayviewPageComponent},
  {path: 'reservation', component: ReservationPageComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
