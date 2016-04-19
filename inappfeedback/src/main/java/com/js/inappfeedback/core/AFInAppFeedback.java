package com.js.inappfeedback.core;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.ViewGroup;

import com.js.inappfeedback.deviceshakesensor.AFDeviceShakeDetector;
import com.js.inappfeedback.ui.AFUserFeedBackMainView;

/**
 * Created by sowmi on 14/04/16.
 */
public class AFInAppFeedback implements AFUserFeedBackMainView.IAFUserFeedBackMainViewActionListener, AFDeviceShakeDetector.DeviceShakeListener{

    private static Context mContext;
    private static  AFInAppFeedback inAppFeedback ;
    private static AFUserFeedBackFactory factory = null;


    public AFInAppFeedback(Context context, String senderEmailId) {
        mContext = context;
        factory = AFUserFeedBackFactory.getInstance(context , senderEmailId);
        factory.getShakeDetector().setmDeviceShakeListener(this);
    }


    public static AFInAppFeedback initialise(Context context){
        if( inAppFeedback == null ){
            inAppFeedback = new AFInAppFeedback(context, null);
        }
        return inAppFeedback;
    }

    public static AFInAppFeedback initialise(Context context, String senderEmailId){
        if( inAppFeedback == null ){
            inAppFeedback = new AFInAppFeedback(context, senderEmailId);
        }
        return inAppFeedback;
    }

    public void showFeedBackOptions(){
        AFUserFeedBackMainView mainView = factory.getUserFeedBackMainView();
        mainView.setListener(this);
        final ViewGroup viewGroup = (ViewGroup) (( (FragmentActivity) mContext )
                .findViewById(android.R.id.content) );
        if(mainView.getParent() != null){
            ((ViewGroup)mainView.getParent()).removeView(mainView);
        }
        ((ViewGroup)viewGroup.getChildAt(0)).addView(mainView);
       // ((ViewGroup)((FragmentActivity)mContext).getWindow().getDecorView().getRootView()).addView(mainView);
        //container.addView(mainView);
        //TODO: Attach the view to current window
    }

    @Override
    public void onCancelBtnClick() {
        //TODO: Detach the view from current window and release the resources
    }

    @Override
    public void onSendBtnClick() {
        factory.getSender().sendFeedBack(mContext,factory.getUserFeedBackMainView().getScreenshot(), factory.getUserFeedBackMainView().getInputString());
    }

    @Override
    public void onShakeOfDevice() {
       showFeedBackOptions();
    }
}
