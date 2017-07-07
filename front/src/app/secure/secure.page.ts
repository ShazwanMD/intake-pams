import {Component, ViewContainerRef, OnInit, AfterViewInit} from '@angular/core';
import {Router} from '@angular/router';
import {AuthenticationService} from '../../services/authentication.service';

@Component({
  selector: 'pams-secure',
  templateUrl: './secure.page.html',
})
export class SecurePage implements OnInit {

  constructor(private _router: Router,
              private authnService: AuthenticationService) {
  }

  ngOnInit(): void {
    // no op
  }

  logout(): void {
    this.authnService.logout();
    this._router.navigate(['/login']);
  }
}
