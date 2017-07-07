import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'pams-dashboard',
  templateUrl: './dashboard.page.html',
  styleUrls: ['./dashboard.page.scss'],
})

export class DashboardPage implements OnInit {

  private items: Object[];

  constructor(private router: Router,
              private  route: ActivatedRoute) {
  }

  ngOnInit(): void {
    {
      this.items = [{
        title: 'Application',
        route: '/secure/application',
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
          route: '/secure/admission',
          icon: 'assignment',
          color: 'blue-700',
          description: 'Candidate Admission',
        },
        {
          title: 'Setup',
          route: '/secure/setup',
          icon: 'assignment',
          color: 'blue-700',
          description: 'Intake Setup',
        },
      ];
    }
  }
}
