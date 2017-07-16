import { User } from './../../identity/user.interface';
import { Observable } from 'rxjs/Observable';

import {Component, Input, ChangeDetectionStrategy} from '@angular/core';


@Component({
  selector: 'pams-user',
  templateUrl: './user.component.html',
  changeDetection: ChangeDetectionStrategy.OnPush,
})
export class UserComponent {
    
 @Input() user: User;

}
