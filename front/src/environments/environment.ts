// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.

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
