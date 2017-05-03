import { Pipe, PipeTransform } from '@angular/core';


@Pipe({
  name: 'molek'
})
export class PrettyPrintPipe implements PipeTransform {
  transform(val) {
    return JSON.stringify(val, null, 2)
      .replace(' ', 'molekmolek;')
      .replace('\n', '<br/>');
  }
}