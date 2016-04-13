package com.js.inappfeedback.core;

import android.content.Context;
import android.view.ViewGroup;

import com.js.inappfeedback.ui.AFUserFeedBackMainView;

/**
 * Created by sowmi on 14/04/16.
 */
public class AFInAppFeedback implements AFUserFeedBackMainView.IAFUserFeedBackMainViewActionListener{

    private static Context mContext;
    private static  AFInAppFeedback inAppFeedback = new AFInAppFeedback();
    private static AFUserFeedBackFactory factory = null;
    private String senderEmailId = "";

    public static AFInAppFeedback initialise(Context context){
        mContext = context;
        factory = AFUserFeedBackFactory.getInstance(context);
        return inAppFeedback;
    }

    public static AFInAppFeedback initialise(Context context, String senderEmailId){
        mContext = context;
        factory = AFUserFeedBackFactory.getInstance(context, senderEmailId);
        return inAppFeedback;
    }


    public void showFeedBackOptions(Context context, ViewGroup container){
        AFUserFeedBackMainView mainView = factory.getUserFeedBackMainView();
        mainView.setListener(this);
        container.addView(mainView);
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
}
