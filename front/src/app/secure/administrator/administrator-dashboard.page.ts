import {Component, Output, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {AuthorizationService} from '../../../services/authorization.service';

@Component({
  selector: 'pams-administrator-dashboard',
  templateUrl: './administrator-dashboard.page.html',
  styleUrls: ['./administrator-dashboard.page.scss'],
})

export class AdministratorDashboardPage implements OnInit {

  private items: Object[];

  constructor(private router: Router,
              private  route: ActivatedRoute,
              private authz: AuthorizationService) {
  }

  ngOnInit(): void {
    console.log('auth:' + JSON.stringify(this.authz.data));
    {
      this.items = [{
        title: 'Profile',
        route: '/profile',
        icon: 'contacts',
        color: 'blue-700',
        description: '',
      },
        {
          title: 'Intake Manager',
          route: '/secure/administrator/policy',
          icon: 'description',
          color: 'blue-700',
          description: '',
        },
        {
          title: 'Candidate Admission',
          route: '/secure/administrator//admission',
          icon: 'assignment',
          color: 'blue-700',
          description: '',
        },
        {
          title: 'Intake Application',
          route: '/secure/administrator//application',
          icon: 'assignment',
          color: 'blue-700',
          description: '',
        },
        {
          title: 'Setup',
          route: '/secure/administrator/setup',
          icon: 'assignment',
          color: 'blue-700',
          description: ' ',
        },
      ];
    }
    ;
  }
}
