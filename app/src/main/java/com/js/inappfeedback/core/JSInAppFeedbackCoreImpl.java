package inappfeedback.imp.com.inappfeedback.core;

import android.content.Context;
import android.graphics.PixelFormat;
import android.view.WindowManager;

import inappfeedback.imp.com.inappfeedback.shakedetectsensor.DeviceShakeDetector;
import inappfeedback.imp.com.inappfeedback.views.JSMainOptionsView;

/**
 * Created by sowmia on 17/12/15.
 */
public class JSInAppFeedbackCoreImpl implements JSIInAppFeedBackCore, DeviceShakeDetector.DeviceShakeListener , JSMainOptionsView.IMPINstaBugMainOptionsActions{

    private DeviceShakeDetector mDeviceShakeDetector;
    private Context mContext;
    private JSMainOptionsView mImpInstaBugMainOptionsView;

    @Override
    public void intialise(Context context) {
        this.mContext = context;
        mDeviceShakeDetector = new DeviceShakeDetector(context, this);
    }

    private void launchImpInstaBugMainOptionsView(Context context) {
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                400,
                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                0 | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        WindowManager wm = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        mImpInstaBugMainOptionsView = new JSMainOptionsView(context , this);
        wm.addView( mImpInstaBugMainOptionsView, params);
    }

    @Override
    public void onShakeOfDevice() {
        launchImpInstaBugMainOptionsView(mContext);
    }

    private void remomveViewFromWindow(Context context){
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.MATCH_PARENT,
                400,
                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                0 | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        WindowManager wm = (WindowManager) context.getSystemService(context.WINDOW_SERVICE);
        wm.removeViewImmediate(mImpInstaBugMainOptionsView);
    }

    @Override
    public void onClickOfReportBug() {

    }

    @Override
    public void onClickOfFeedBack() {

    }

    @Override
    public void onClickOfDismiss() {
        remomveViewFromWindow(mContext);
    }
}
