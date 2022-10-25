export interface VolumeInfoPlugin {
  /**
   * Gets Native System volume information.
   */
  getSystemVolume(): Promise<Volume>

  getMediaVolume(): Promise<Volume>

  getVolume(options: {
    streamType: number
  }): Promise<Volume>


}

export interface Volume {
  volume: number
}