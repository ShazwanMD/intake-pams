import {Component, Output, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';
import {AuthorizationService} from '../../services/authorization.service';

@Component({
  selector: 'pams-management-dashboard-panel',
  templateUrl: './management-dashboard.panel.html',
})

export class ManagementDashboardPanel implements OnInit {

  private items: Object[];

  constructor(private router: Router,
              private  route: ActivatedRoute,
              private authz: AuthorizationService) {
  }

  ngOnInit(): void {
    {

    }
    ;
  }
}
