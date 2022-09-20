import { TestBed } from '@angular/core/testing';

import { TerminalserviceService } from './terminal.service';

describe('TerminalservicesService', () => {
  let service: TerminalserviceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TerminalserviceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
