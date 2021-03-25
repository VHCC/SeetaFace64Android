package com.seetatech.seetaverify.camera;

import android.hardware.Camera;

@SuppressWarnings("deprecation")
public interface CameraCallbacks extends Camera.PreviewCallback{

    void onCameraUnavailable(int errorCode);
}
