import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {DayviewPageComponent} from "./site-components/dayview-page/dayview-page.component";

const routes: Routes = [
  {path: '', component: DayviewPageComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
