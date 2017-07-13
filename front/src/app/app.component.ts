import {Component, ViewContainerRef} from '@angular/core';
import {DomSanitizer} from '@angular/platform-browser';
import {Store} from '@ngrx/store';
import {Observable} from 'rxjs/Observable';
import {MdIconRegistry} from '@angular/material';
import {MdSnackBar, MdSnackBarRef, MdSnackBarConfig, SimpleSnackBar} from '@angular/material';
import {ApplicationContextState} from './application-context.reducer';
import {ApplicationContextActions} from './application-context.action';

@Component({
  selector: 'pams-app',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})
export class AppComponent {

  private APPLICATION_CONTEXT: string = 'applicationContextState';
  private errorSnackBarRef: MdSnackBarRef<SimpleSnackBar>;
  private applicationContext$: Observable<ApplicationContextState>;

  constructor(private snackBar: MdSnackBar,
              private viewContainerRef: ViewContainerRef,
              private _iconRegistry: MdIconRegistry,
              private _domSanitizer: DomSanitizer,
              private store: Store<ApplicationContextState>,
              private ctxActions: ApplicationContextActions) {
    this._iconRegistry.addSvgIconInNamespace('assets', 'covalent',
      this._domSanitizer.bypassSecurityTrustResourceUrl('assets/icons/covalent.svg'));
    this._iconRegistry.addSvgIconInNamespace('assets', 'covalent-mark',
      this._domSanitizer.bypassSecurityTrustResourceUrl('assets/icons/covalent-mark.svg'));

    // setup context
    this.applicationContext$ = this.store.select(this.APPLICATION_CONTEXT);
    this.applicationContext$
      .filter((ctx: ApplicationContextState) => ctx.hasError === true)
      .subscribe((ctx: ApplicationContextState) => this.openErrorMessage(ctx.errorMessage));
  }

  openErrorMessage(errorMessage: string): void {
    let config: MdSnackBarConfig = new MdSnackBarConfig();
    config.viewContainerRef = this.viewContainerRef;
    config.announcementMessage = 'Hello';
    this.errorSnackBarRef = this.snackBar.open(errorMessage, 'Ok');
    // this.errorSnackBarRef.afterDismissed().subscribe(() => {
    //   this.store.dispatch(this.ctxActions.removeErrorMessage());
    // });
  }
}
