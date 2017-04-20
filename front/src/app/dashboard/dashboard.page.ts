import {Component, AfterViewInit} from '@angular/core';
import {Title}     from '@angular/platform-browser';
import {TdLoadingService, TdDigitsPipe} from '@covalent/core';

@Component({
  selector: 'pams-dashboard',
  templateUrl: './dashboard.page.html',
  styleUrls: ['./dashboard.page.scss'],
  viewProviders: [],
})
export class DashboardPage implements AfterViewInit {

  constructor(private _titleService: Title,
              private _loadingService: TdLoadingService) {
  }

  ngAfterViewInit(): void {
    this._titleService.setTitle('PAMS Universiti Malaysia Kelantan');
  }
}
