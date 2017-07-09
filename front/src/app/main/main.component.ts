// deprecated
import {Component} from '@angular/core';
import {Router} from '@angular/router';
import {AuthenticationService} from '../../services/authentication.service';

@Component({
  selector: 'pams-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss'],
})
export class MainComponent {

  constructor(private _router: Router,
              private authnService: AuthenticationService) {
  }

  logout(): void {
    this.authnService.logout();
    this._router.navigate(['/login']);
  }
}
