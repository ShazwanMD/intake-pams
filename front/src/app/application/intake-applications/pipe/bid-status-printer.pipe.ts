import {Pipe, PipeTransform} from '@angular/core';
import {BidStatus} from "../bid-status.enum";


@Pipe({
  name: 'bidStatusPrinter'
})
export class BidStatusPrinter implements PipeTransform {
  transform(val) {
    switch (BidStatus[val.toString()]) {
      case BidStatus.DRAFTED:
        return "Drafted";
      case BidStatus.SUBMITTED:
        return "Drafted";
    }
  }
}
