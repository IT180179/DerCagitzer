import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router'; // CLI imports router

import {DayviewPageComponent} from "./site-components/dayview-page/dayview-page.component";
import {ReservationPageComponent} from "./site-components/reservation-page/reservation-page.component";
import {RoomCardsComponent} from "./site-components/room-cards/room-cards.component";

const routes: Routes = [
  { path: '', component: DayviewPageComponent },
  { path: 'reservation', component: ReservationPageComponent },
  { path: '', redirectTo: '/', pathMatch: 'full'},
  {path: 'rooms', component: RoomCardsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
