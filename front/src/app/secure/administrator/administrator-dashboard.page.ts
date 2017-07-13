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
              private authz:AuthorizationService,
  ) {
  }

  ngOnInit(): void {
    console.log('auth:' + JSON.stringify(this.authz.data));
    {
      this.items = [{
        title: 'Application',
        route: '/secure/administrator/application',
        icon: 'contacts',
        color: 'blue-700',
        description: 'Intake Application',
      },
        {
          title: 'Manager',
          route: '/secure/policy',
          icon: 'assignment',
          color: 'blue-700',
          description: 'Intake Manager',
        }
        ,
        {
          title: 'Registration',
          route: '/registration',
          icon: 'description',
          color: 'blue-700',
          description: 'Applicant Registration',
        },
        {
          title: 'Admission',
          route: '/secure/administrator/admission',
          icon: 'assignment',
          color: 'blue-700',
          description: 'Candidate Admission',
        },
        {
          title: 'Setup',
          route: '/secure/administrator/setup',
          icon: 'assignment',
          color: 'blue-700',
          description: 'Intake Setup',
        },
      ];
    }
    ;
  }
}
