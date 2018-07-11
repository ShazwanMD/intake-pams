import { AttachmentState, attachmentReducer } from './intake-applications/attachment.reducer';
import {Result} from '../../shared/model/application/result.interface';
import {SupervisorOffering} from '../../shared/model/policy/supervisor-offering.interface';
import {Referee} from '../../shared/model/application/referee.interface';
import {NgModule, ModuleWithProviders} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {appRoutes, appRoutingProviders} from '../../app.routes';
import {CovalentCoreModule} from '@covalent/core';
import {CommonService} from '../../../services';
import {IdentityService} from '../../../services';
import {ApplicationPage} from './application.page';
import {ApplicationService} from '../../../services/application.service';
import {PolicyService} from '../../../services/policy.service';
import {IntakeApplicationSubModule} from './intake-applications/index';
import {
  intakeApplicationReducer,
  IntakeApplicationState,
} from './intake-applications/intake-application.reducer';
import {
  intakeApplicationListReducer,
  IntakeApplicationListState,
} from './intake-applications/intake-application-list.reducer';
import {intakeListReducer, IntakeListState} from './intake-applications/intake-list.reducer';
import {intakeReducer, IntakeState} from './intake-applications/intake.reducer';
import {CommonModule} from '../../common/index';
import {ProgramLevelSubModule} from '../policy/program-levels/index';
import {CpsIntakeApplicationSubModule} from './intake-applications/cps/index';
import {
  intakeProgramOfferingListReducer,
  IntakeProgramOfferingListState,
} from './intake-applications/intake-program-offering-list.reducer';
import {
  intakeStudyModeOfferingListReducer,
  IntakeStudyModeOfferingListState,
} from './intake-applications/intake-study-mode-offering-list.reducer';
import {
  intakeSupervisorOfferingListReducer,
  IntakeSupervisorOfferingListState,
} from './intake-applications/intake-supervisor-offering-list.reducer';
import {
  employmentListReducer,
  EmploymentListState,
} from './intake-applications/employment-list.reducer';
import {Employment} from '../../shared/model/application/employment.interface';
import {Intake} from '../../shared/model/policy/intake.interface';
import {ProgramOffering} from '../../shared/model/policy/program-offering.interface';
import {IntakeApplication} from '../../shared/model/application/intake-application.interface';
import {refereeListReducer, RefereeListState} from './intake-applications/referee-list.reducer';
import {resultListReducer, ResultListState} from './intake-applications/result-list.reducer';
import {StudyModeOffering} from '../../shared/model/policy/study-mode-offering.interface';
import {Language} from '../../shared/model/application/language.interface';
import {languageListReducer, LanguageListState} from './intake-applications/language-list.reducer';
import {
  attachmentListReducer,
  AttachmentListState,
} from './intake-applications/attachment-list.reducer';
import {Attachment} from '../../shared/model/application/attachment.interface';
import { TabIndexState, tabIndexReducer } from './intake-applications/tab-index.reducer';
import { supervisorOfferingListReducer, SupervisorOfferingListState } from '../../common/supervisor-offerings/supervisor-offering-list.reducer';

export interface ApplicationModuleState {
  tabIndex: TabIndexState;
  intakes: IntakeListState;
  intake: IntakeState;
  employments: EmploymentListState;
  languages: LanguageListState;
  referees: RefereeListState;
  attachments: AttachmentListState;
  attachmentByTypes: AttachmentState;
  programOfferings: IntakeProgramOfferingListState;
  supervisorOfferings: SupervisorOfferingListState;
  studyModeOfferings: IntakeStudyModeOfferingListState;
  intakeApplications: IntakeApplicationListState;
  intakeApplication: IntakeApplicationState;
  results: ResultListState;
}
;

export const INITIAL_APPLICATION_STATE: ApplicationModuleState = <ApplicationModuleState>{
  tabIndex: 0,
  intakes: <Intake[]>[],
  intake: <Intake>{},
  employments: <Employment[]>[],
  languages: <Language[]>[],
  referees: <Referee[]>[],
  attachments: <Attachment[]>[],
  attachmentByTypes: <Attachment[]>[],
  results: <Result[]>[],
  programOfferings: <ProgramOffering[]>[],
  supervisorOfferings: <SupervisorOffering[]>[],
  studyModeOfferings: <StudyModeOffering[]>[],
  intakeApplications: [],
  intakeApplication: <IntakeApplication>{},

};

export const applicationModuleReducers = {
  tabIndex : tabIndexReducer,
  intakes: intakeListReducer,
  intake: intakeReducer,
  employments: employmentListReducer,
  languages: languageListReducer,
  referees: refereeListReducer,
  attachments: attachmentListReducer,
  attachmentByTypes: attachmentReducer,
  results: resultListReducer,
  programOfferings: intakeProgramOfferingListReducer,
  supervisorOfferings: supervisorOfferingListReducer,
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
