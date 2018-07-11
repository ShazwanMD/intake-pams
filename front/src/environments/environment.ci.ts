import {StoreDevtoolsModule} from '@ngrx/store-devtools';
export const environment: { production: boolean, endpoint: string, imports: any[] } = {
  production: true,
  endpoint: 'http://localhost:8080',
  // endpoint: 'http://10.20.5.90:8082',
  // endpoint: 'http://pams.umk.edu.my:8082',
  imports: [
    StoreDevtoolsModule.instrumentOnlyWithExtension({maxAge: 5}),
  ],
};
