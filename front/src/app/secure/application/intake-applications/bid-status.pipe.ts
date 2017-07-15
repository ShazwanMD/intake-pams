import {Pipe, PipeTransform} from '@angular/core';
import {BidStatus} from '../../../shared/model/application/bid-status.enum';

@Pipe({
  name: 'bidStatusPipe',
})
export class BidStatusPipe implements PipeTransform {

  transform(val: BidStatus) {
    switch (val) {
      case BidStatus.DRAFTED:
        return 'Drafted';
      case BidStatus.SUBMITTED:
        return 'Submitted';
    }
  }
}
