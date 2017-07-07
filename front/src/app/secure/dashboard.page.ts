import {Component, Output, OnInit} from '@angular/core';
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
        title: 'Profile',
        route: '/profile',
        icon: 'contacts',
        color: 'blue-700',
        description: '',
      },
        {
          title: 'Planner',
          // route: '/planner/academic-sessions',
          route: '/planner',
          icon: 'assignment',
          color: 'blue-700',
          description: '',
        }
        ,
        {
          title: 'Term',
          route: '/term',
          icon: 'description',
          color: 'blue-700',
          description: '',
        },
        {
          title: 'Graduation',
          route: '/graduation',
          icon: 'assignment',
          color: 'blue-700',
          description: '',
        },
        {
          title: 'Setup',
          route: '/setup',
          icon: 'assignment',
          color: 'blue-700',
          description: ' ',
        },
         /*{
          title: 'Subject Registration',
          route: '/term',
          icon: 'assignment',
          color: 'blue-700',
          description: ' ',
        }, */

      ];
    }
    ;
  }
}
