import { TestBed } from '@angular/core/testing';

import { SideOverviewService } from './side-overview.service';

describe('SideOverviewService', () => {
  let service: SideOverviewService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SideOverviewService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
