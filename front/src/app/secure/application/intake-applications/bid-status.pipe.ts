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
      case BidStatus.SELECTED:
          return 'Selected';
      case BidStatus.REJECTED:
          return 'Rejected';
      case BidStatus.WITHDRAW:
          return 'Withdraw';
      case BidStatus.APPEALED:
          return 'Appealed';
      case BidStatus.PRE_APPROVED:
          return 'Pre Approved';
      case BidStatus.APPROVED:
          return 'Approved';
      case BidStatus.OFFERED:
          return 'Offered';
    }
  }
}
