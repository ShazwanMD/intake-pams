import {Component, Output, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {AuthorizationService} from '../../../services/authorization.service';

@Component({
  selector: 'pams-applicant-dashboard',
  templateUrl: './applicant-dashboard.page.html',
  styleUrls: ['./applicant-dashboard.page.scss'],
})

export class ApplicantDashboardPage implements OnInit {

  private items: Object[];

  constructor(private router: Router,
              private  route: ActivatedRoute,
              private authz:AuthorizationService
  ) {
  }

  ngOnInit(): void {
    console.log('auth:' + JSON.stringify(this.authz.data));
    {
      this.items = [{
        title: 'Application',
        route: '/secure/applicant/application',
        icon: 'contacts',
        color: 'blue-700',
        description: 'Intake Application',
      },
        // {
        //   title: 'Manager',
        //   route: '/secure/applicant/policy',
        //   icon: 'assignment',
        //   color: 'blue-700',
        //   description: 'Intake Manager',
        // }
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
          route: '/secure/applicant/admission',
          icon: 'assignment',
          color: 'blue-700',
          description: 'Candidate Admission',
        },
        // {
        //   title: 'Setup',
        //   route: '/secure/applicant/setup',
        //   icon: 'assignment',
        //   color: 'blue-700',
        //   description: 'Intake Setup',
        // },
      ];
    }
    ;
  }
}
