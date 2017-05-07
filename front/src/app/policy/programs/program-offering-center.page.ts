import {Component, OnInit} from '@angular/core';
import {Router, ActivatedRoute} from '@angular/router';

@Component({
  selector: 'pams-program-offering-center',
  templateUrl: './program-offering-center.page.html',
})

export class ProgramOfferingCenterPage implements OnInit {
constructor(private router: Router,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
     this.route.params.subscribe(() => {
    });
  }
}


