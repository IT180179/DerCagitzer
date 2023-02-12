import {Component, OnDestroy, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-tableplan',
  templateUrl: './tableplan.component.html',
  styleUrls: ['./tableplan.component.scss']
})
export class TableplanComponent implements OnInit, OnDestroy{

  tableno: number;
  private sub: any;

  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.sub = this.route.params.subscribe(params => {
      this.tableno = +params['tableno'];
    });
  }

  ngOnDestroy() {
    this.sub.unsubscribe();
  }

}
