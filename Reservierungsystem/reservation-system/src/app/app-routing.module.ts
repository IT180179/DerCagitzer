import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router'; // CLI imports router

import {DayviewPageComponent} from "./site-components/dayview-page/dayview-page.component";
import {ReservationPageComponent} from "./site-components/reservation-page/reservation-page.component";
import {RoomCardsComponent} from "./site-components/room-cards/room-cards.component";

const routes: Routes = [
  { path: 'dashboard', component: DayviewPageComponent },
  { path: 'reservation', component: ReservationPageComponent },
  { path: 'cards', component: RoomCardsComponent },
  { path: '', redirectTo: '/cards', pathMatch: 'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
