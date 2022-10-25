package com.logmaster.plugins.capacitor.volume;

import android.content.Context;
import android.media.AudioManager;

import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;

import org.json.JSONException;

import java.util.ArrayList;

public class VolumeInfo {

    private final AudioManager audioManager;

    VolumeInfo(Context context){
        this.audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
    }

    public int getSystemVolume(){
        return this.getVolume(AudioManager.STREAM_SYSTEM);
    }

    public int getMediaVolume(){
        return this.getVolume(AudioManager.STREAM_MUSIC);
    }

    public int getVolume(int streamType){
        return this.audioManager.getStreamVolume(streamType);
    }

    public JSArray getStreamTypes() throws JSONException {
        ArrayList<JSObject> streamTypes = new ArrayList<>();

        streamTypes.add(new JSObject().put("STREAM_VOICE_CALL", AudioManager.STREAM_VOICE_CALL));
        streamTypes.add(new JSObject().put("STREAM_SYSTEM", AudioManager.STREAM_SYSTEM));
        streamTypes.add(new JSObject().put("STREAM_RING", AudioManager.STREAM_RING));
        streamTypes.add(new JSObject().put("STREAM_MUSIC", AudioManager.STREAM_MUSIC));
        streamTypes.add(new JSObject().put("STREAM_ALARM", AudioManager.STREAM_ALARM));
        streamTypes.add(new JSObject().put("STREAM_NOTIFICATION", AudioManager.STREAM_NOTIFICATION));
        streamTypes.add(new JSObject().put("STREAM_DTMF", AudioManager.STREAM_DTMF));
        streamTypes.add(new JSObject().put("STREAM_ACCESSIBILITY", AudioManager.STREAM_ACCESSIBILITY));
        return JSArray.from(streamTypes.toArray());
    }
}
