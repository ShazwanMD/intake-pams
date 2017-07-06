import {Directive, ElementRef, Input, OnInit, Renderer} from '@angular/core';
import {AuthorizationService} from '../../../services/authorization.service';

@Directive({selector: '[aclShow]'})
export class AclShowDirective implements OnInit {

  @Input() aclShow: string;

  constructor(private el: ElementRef, private renderer: Renderer, private authzService: AuthorizationService) {
    console.log('initing directive');
  }

  ngOnInit(): void {
    console.log('checking for permission: ' + this.aclShow);
    if (!this.authzService.can(this.aclShow)) {
      this.renderer.setElementStyle(this.el.nativeElement, 'display', 'none');
    }
  }
}
