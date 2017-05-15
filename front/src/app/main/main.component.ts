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
  }, 
   {
    title: 'Code Setup',
    route: '/setup',
    icon: 'label',
  }, {
    title: 'Applicant Registration',
    route: '/registration',
    icon: 'label',
  }, {
    title: 'Intake Manager',
    route: '/policy',
    icon: 'label',
  }, {
    title: 'Intake Application',
    route: '/application',
    icon: 'label',
  }, {
    title: 'Candidate Admission',
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
