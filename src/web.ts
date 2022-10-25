import { WebPlugin } from '@capacitor/core';

import type { Volume, VolumeInfoPlugin } from './definitions';

export class VolumeInfoWeb extends WebPlugin implements VolumeInfoPlugin {
  async getSystemVolume(): Promise<Volume> {
    console.warn('[VolumeInfoPlugin] not supported by web platform');
    return { volume: -1 };
  }
  async getMediaVolume(): Promise<Volume> {
    console.warn('[VolumeInfoPlugin] not supported by web platform');
    return { volume: -1 };
  }
  async getVolume(options: { streamType: number; }): Promise<Volume> {
    console.warn('[VolumeInfoPlugin] not supported by web platform');
    return { volume: -1 };
  }
}
