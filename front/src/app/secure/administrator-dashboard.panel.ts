import {Component, Output, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {AuthorizationService} from '../../services/authorization.service';

@Component({
  selector: 'pams-administrator-dashboard-panel',
  templateUrl: './administrator-dashboard.panel.html',
})

export class AdministratorDashboardPanel implements OnInit {

  private items: Object[];

  constructor(private router: Router,
              private  route: ActivatedRoute,
              private authz: AuthorizationService) {
  }

  ngOnInit(): void {
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
