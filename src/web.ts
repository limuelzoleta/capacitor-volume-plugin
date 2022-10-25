import { WebPlugin } from '@capacitor/core';

import type { VolumeInfoPlugin } from './definitions';

export class VolumeInfoWeb extends WebPlugin implements VolumeInfoPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }
}
