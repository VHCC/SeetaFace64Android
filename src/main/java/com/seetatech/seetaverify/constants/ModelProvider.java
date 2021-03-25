package com.seetatech.seetaverify.constants;

import android.os.Environment;

import java.io.File;

public class ModelProvider {

    public static File getViplDir() {
        File viplDir = new File(Environment.getExternalStorageDirectory(), "/seeta");
        if (!viplDir.exists()) {
            //noinspection ResultOfMethodCallIgnored
            viplDir.mkdirs();
        }

        return viplDir;
    }

    public static File getDetectorModelFile() {
        return new File(getViplDir(), Constants.MODEL_DETECTOR_FILE_NAME);
    }

    public static File getPointerModelFile() {
        return new File(getViplDir(), Constants.MODEL_POINTER_FILE_NAME);
    }
}
