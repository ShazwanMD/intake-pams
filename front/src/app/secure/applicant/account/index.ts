import {Result} from '../../../shared/model/application/result.interface';
import {SupervisorOffering} from '../../../shared/model/policy/supervisor-offering.interface';
import {Referee} from '../../../shared/model/application/referee.interface';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../../../app.routes';
import {CovalentCoreModule} from '@covalent/core';
import {CommonService} from '../../../../services';
import {IdentityService} from '../../../../services';
import {ApplicationService} from '../../../../services/application.service';
import {PolicyService} from '../../../../services/policy.service';
import {IntakeApplicationSubModule} from '../application/intake-applications/index';
import {
  intakeApplicationReducer,
  IntakeApplicationState,
} from '../application/intake-applications/intake-application.reducer';
import {
  intakeApplicationListReducer,
  IntakeApplicationListState,
} from '../application/intake-applications/intake-application-list.reducer';
import {intakeListReducer, IntakeListState} from '../application/intake-applications/intake-list.reducer';
import {intakeReducer, IntakeState} from '../application/intake-applications/intake.reducer';
import {CommonModule} from '../../../common/index';
import {ProgramLevelSubModule} from '../../../policy/program-levels/index';
import {CpsIntakeApplicationSubModule} from '../application/intake-applications/cps/index';
import {
  intakeProgramOfferingListReducer,
  IntakeProgramOfferingListState,
} from '../application/intake-applications/intake-program-offering-list.reducer';
import {
  intakeStudyModeOfferingListReducer,
  IntakeStudyModeOfferingListState,
} from '../application/intake-applications/intake-study-mode-offering-list.reducer';
import {
  intakeSupervisorOfferingListReducer,
  IntakeSupervisorOfferingListState,
} from '../application/intake-applications/intake-supervisor-offering-list.reducer';
import {
  employmentListReducer,
  EmploymentListState,
} from '../application/intake-applications/employment-list.reducer';
import {Employment} from '../../../shared/model/application/employment.interface';
import {Intake} from '../../../shared/model/policy/intake.interface';
import {ProgramOffering} from '../../../shared/model/policy/program-offering.interface';
import {IntakeApplication} from '../../../shared/model/application/intake-application.interface';
import {refereeListReducer, RefereeListState} from '../application/intake-applications/referee-list.reducer';
import {resultListReducer, ResultListState} from '../application/intake-applications/result-list.reducer';
import {StudyModeOffering} from '../../../shared/model/policy/study-mode-offering.interface';
import {Language} from '../../../shared/model/application/language.interface';
import {languageListReducer, LanguageListState} from '../application/intake-applications/language-list.reducer';
import {
  attachmentListReducer,
  AttachmentListState,
} from '../application/intake-applications/attachment-list.reducer';
import {Attachment} from '../../../shared/model/application/attachment.interface';
import {ApplicationPage} from "../application/application.page";

export interface ApplicationModuleState {
  intakes: IntakeListState;
  intake: IntakeState;
  employments: EmploymentListState;
  languages: LanguageListState;
  referees: RefereeListState;
  attachments: AttachmentListState;
  programOfferings: IntakeProgramOfferingListState;
  supervisorOfferings: IntakeSupervisorOfferingListState;
  studyModeOfferings: IntakeStudyModeOfferingListState;
  intakeApplications: IntakeApplicationListState;
  intakeApplication: IntakeApplicationState;
  results: ResultListState;
}
;

export const INITIAL_APPLICATION_STATE: ApplicationModuleState = <ApplicationModuleState>{
  intakes: <Intake[]>[],
  intake: <Intake>{},
  employments: <Employment[]>[],
  languages: <Language[]>[],
  referees: <Referee[]>[],
  attachments: <Attachment[]>[],
  results: <Result[]>[],
  programOfferings: <ProgramOffering[]>[],
  supervisorOfferings: <SupervisorOffering[]>[],
  studyModeOfferings: <StudyModeOffering[]>[],
  intakeApplications: [],
  intakeApplication: <IntakeApplication>{},

};

export const applicationModuleReducers = {
  intakes: intakeListReducer,
  intake: intakeReducer,
  employments: employmentListReducer,
  languages: languageListReducer,
  referees: refereeListReducer,
  attachments: attachmentListReducer,
  results: resultListReducer,
  programOfferings: intakeProgramOfferingListReducer,
  supervisorOfferings: intakeSupervisorOfferingListReducer,
  studyModeOfferings: intakeStudyModeOfferingListReducer,
  intakeApplications: intakeApplicationListReducer,
  intakeApplication: intakeApplicationReducer,
};

@NgModule({
  imports: [
    appRoutes,
    BrowserModule,
    ReactiveFormsModule,
    CovalentCoreModule.forRoot(),
    IntakeApplicationSubModule.forRoot(),
    CommonModule.forRoot(),
    ProgramLevelSubModule.forRoot(),
    CpsIntakeApplicationSubModule.forRoot(),
  ],
  declarations: [
    // page
    ApplicationPage,
  ],
  exports: [],

  entryComponents: [],
})
export class ApplicationModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: ApplicationModule,
      providers: [
        appRoutingProviders,
        IdentityService,
        CommonService,
        PolicyService,
        ApplicationService,
      ],
    };
  }
}
