import {Injectable} from '@angular/core';
import {
  CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot,
} from '@angular/router';
import {AuthenticationService} from '../../../services/authentication.service';

@Injectable()
export class AuthenticationGuard implements CanActivate {
  constructor(route: ActivatedRouteSnapshot, state: RouterStateSnapshot,
              private router: Router,
              private authnService: AuthenticationService) {
  }

  canActivate(): boolean {
    if (this.authnService.isLoggedIn()) {
      return true;
    } else {
      this.router.navigate(['/login']);
      // todo: capture attempted URL for redirecting
      // todo: this.authnService.redirectUrl = state. url
      return false;
    }
  }
}
