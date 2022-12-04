import { Component, OnInit } from '@angular/core';
import {DataService} from "../../services/data.service";
import {SideOverviewService} from "../../shared/side-overview.service";

@Component({
  selector: 'app-tabs',
  templateUrl: './tabs.component.html',
  styleUrls: ['./tabs.component.scss']
})
export class TabsComponent implements OnInit {

  constructor(public dataservice: DataService) { }

  rooms: any;
  tabels: any;

  ngOnInit(): void {
    this.rooms = this.dataservice.getRooms()
      .subscribe((result)=>{
        this.rooms = result
        console.log(this.rooms)
      });
  }

  getTabels(room_id: any) {
    console.log("in")
      this.tabels = this.dataservice.getTabels(room_id)
        .subscribe((result) => {
          this.tabels = result
          console.log(this.tabels)
        });
    }

  isWinter(summer_winter: any) {
    if(summer_winter == "Sommer"){
      return true
    }else {
      return false
    }
  }
}
