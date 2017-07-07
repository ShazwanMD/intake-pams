import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthenticationService} from '../../services/authentication.service';

@Component({
  selector: 'pams-secure',
  templateUrl: './secure.page.html',
})
export class SecurePage implements OnInit {

  constructor(private authnService: AuthenticationService) {
    // no op
  }

  ngOnInit(): void {
    this.authnService.currentUsername();
  }
}
