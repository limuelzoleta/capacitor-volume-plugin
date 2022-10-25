package com.logmaster.plugins.capacitor.volume;

import com.getcapacitor.JSArray;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import org.json.JSONException;

@CapacitorPlugin(name = "VolumeInfo")
public class VolumeInfoPlugin extends Plugin {

    private VolumeInfo implementation;

    @Override
    public void load(){
        implementation = new VolumeInfo(getContext());
    }

    @PluginMethod
    public void getSystemVolume(PluginCall call) {
        int systemVolume = implementation.getSystemVolume();
        JSObject ret = new JSObject();
        ret.put("volume", systemVolume);
        call.resolve(ret);
    }

    @PluginMethod
    public void getMediaVolume(PluginCall call) {
        int mediaVolume = implementation.getMediaVolume();
        JSObject ret = new JSObject();
        ret.put("volume", mediaVolume);
        call.resolve(ret);
    }


    @PluginMethod
    public void getVolume(PluginCall call) {
        try {
            int streamType = call.getInt("streamType");
            int mediaVolume = implementation.getVolume(streamType);
            JSObject ret = new JSObject();
            ret.put("volume", mediaVolume);
            call.resolve(ret);
        } catch (NullPointerException e) {
            call.reject(e.getMessage());
        }

    }


    @PluginMethod
    public void getStreamTypes(PluginCall call){
        try {
            JSArray streamTypes = implementation.getStreamTypes();
            JSObject ret = new JSObject();
            ret.put("streamTypes", streamTypes);
            call.resolve(ret);
        } catch (JSONException e) {
            call.reject("Cannot get stream types");
        }
    }


}
