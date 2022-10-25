import AVFoundation

@objc public class VolumeInfo: NSObject {
    let audioSession = AVAudioSession.sharedInstance()
    
    @objc public func echo(_ value: String) -> String {
        print(value)
        return value
    }
    
    @objc public func getSystemVolume() -> Int {
        try audioSession.setActive(true);
        volume = audioSession.outputVolume
        return Int(volume * 100)
    }
}
