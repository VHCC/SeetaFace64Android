package com.seetatech.seetaverify.mvp;

import android.graphics.Bitmap;
import android.view.TextureView;

import org.opencv.core.Mat;
import org.opencv.core.Rect;

public interface VerificationContract {

    interface View {

        void drawFaceRect(Rect faceRect);

        void drawFaceImage(Bitmap faceBmp);

        void toastMessage(String msg);

        void showCameraUnavailableDialog(int errorCode);

        void setStatus(int status, Mat matBgr, Rect faceRect);

        void setName(String name, Mat matBgr, Rect faceRect);

        void FaceRegister(String tip);

        void showSimpleTip(String tip);

        void setBestImage(Bitmap bitmap);

        void setPresenter(Presenter presenter);

        TextureView getTextureView();
        boolean isActive();
    }

    interface Presenter {

        void detect(byte[] data, int width, int height, int rotation);

        void destroy();

    }
}
