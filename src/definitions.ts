export interface VolumeInfoPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
}
