export class Timetable {
  locations = [];
  events = [];
  newLocations = [];
  scopeDurationHours: number;

  constructor() {
    scope: Scope;
    this.scope = {
      hourStart: 0,
      hourEnd: 24
    };
    this.locations = [];
    this.events = [];
    this.scopeDurationHours = this.getDurationHours(this.scope.hourStart, this.scope.hourEnd);
  }
}
