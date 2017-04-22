import {Component} from '@angular/core';
import {Router} from '@angular/router';

@Component({
  selector: 'pams-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss'],
})
export class MainComponent {

  routes: Object[] = [{
    title: 'Dashboard',
    route: '/',
    icon: 'dashboard',
  }, {
    title: 'Regisration',
    route: '/registration',
    icon: 'label',
  }, {
    title: 'Policy',
    route: '/policy',
    icon: 'label',
  }, {
    title: 'Application',
    route: '/application',
    icon: 'label',
  }, {
    title: 'Admission',
    route: '/admission',
    icon: 'label',
  }
  ];

  constructor(private _router: Router) {
  }

  logout(): void {
    this._router.navigate(['/login']);
  }
}
