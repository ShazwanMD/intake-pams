import { FlowState } from './flow-state.enum';
import { Observable } from 'rxjs/Observable';
import { Pipe, PipeTransform } from '@angular/core';


@Pipe({name: 'candidateFlowStatePipe'})
export class CandidateFlowStatePipe implements PipeTransform{
    
    transform(value: FlowState): any {
        if(!value){
            return value;
        }

        switch(FlowState[value.toString()]){
            case FlowState.DRAFTED:{
                return 'Pre-Approved';
            }
            case FlowState.VERIFIED:{
                return 'Approved';
            }
            case FlowState.PUBLISHED:{
                return 'Offered';
            }
            case FlowState.COMPLETED:{
                return 'Registered';
            }
            default:{
                return value;
            }
        }
    }
}