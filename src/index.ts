import { registerPlugin } from '@capacitor/core';

import type { VolumeInfoPlugin } from './definitions';

const VolumeInfo = registerPlugin<VolumeInfoPlugin>('VolumeInfo', {
  web: () => import('./web').then(m => new m.VolumeInfoWeb()),
});

export * from './definitions';
export { VolumeInfo };
