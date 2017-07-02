import {StoreDevtoolsModule} from '@ngrx/store-devtools';
export const environment: { production: boolean, endpoint: string, imports: any[] } = {
  production: false,
  endpoint: '/intake',
  imports: [
    StoreDevtoolsModule.instrumentOnlyWithExtension({maxAge: 5}),
  ],
};
