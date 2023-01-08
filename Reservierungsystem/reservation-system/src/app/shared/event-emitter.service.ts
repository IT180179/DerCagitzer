import {EventEmitter, Injectable} from '@angular/core';
import {Subscription} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class EventEmitterService {

  invokefunction = new EventEmitter
  sub: Subscription

  constructor() { }

  onDelete() {
    this.invokefunction.emit()
  }

}
