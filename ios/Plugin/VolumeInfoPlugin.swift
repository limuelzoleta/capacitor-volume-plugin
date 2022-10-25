import Foundation
import Capacitor

/**
 * Please read the Capacitor iOS Plugin Development Guide
 * here: https://capacitorjs.com/docs/plugins/ios
 */
@objc(VolumeInfoPlugin)
public class VolumeInfoPlugin: CAPPlugin {
    private let implementation = VolumeInfo()

    @objc func echo(_ call: CAPPluginCall) {
        let value = call.getString("value") ?? ""
        call.resolve([
            "value": implementation.echo(value)
        ])
    }
    
    @objc func getSystemVolume(_ call: CAPPluginCall) {
        let volume = implementation.getSystemVolume();
        call.resolve(["volume":volume]);
        
    }
}
