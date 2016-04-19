package com.js.inappfeedback.core;

import android.content.Context;

import com.js.inappfeedback.deviceshakesensor.AFDeviceShakeDetector;
import com.js.inappfeedback.ui.AFUserFeedBackMainView;
import com.js.inappfeedback.userfeedbacksender.AFMailUserFeedbackSender;
import com.js.inappfeedback.userfeedbacksender.AFServiceUserFeedbackSender;
import com.js.inappfeedback.userfeedbacksender.IAFUserFeedbackSender;

/**
 * Created by sowmi on 14/04/16.
 */
public class AFUserFeedBackFactory {

    private AFUserFeedBackMainView userFeedBackMainView;
    private IAFUserFeedbackSender sender;
    private AFDeviceShakeDetector shakeDetector;
    private static AFUserFeedBackFactory userFeedbackFactory;

    private AFUserFeedBackFactory(Context context, String emailId) {
        userFeedBackMainView = new AFUserFeedBackMainView(context);
        if (emailId != null && emailId != "")
            sender = new AFMailUserFeedbackSender(emailId);
        else
            sender = new AFServiceUserFeedbackSender();
        shakeDetector = new AFDeviceShakeDetector(context);
    }


    public static AFUserFeedBackFactory getInstance(Context context, String emailId) {
        if (userFeedbackFactory == null) {
            userFeedbackFactory = new AFUserFeedBackFactory(context, emailId);
        }
        return userFeedbackFactory;
    }


    public AFDeviceShakeDetector getShakeDetector() {
        return shakeDetector;
    }

    public AFUserFeedBackMainView getUserFeedBackMainView() {
        return userFeedBackMainView;
    }

    public void setUserFeedBackMainView(AFUserFeedBackMainView userFeedBackMainView) {
        this.userFeedBackMainView = userFeedBackMainView;
    }

    public IAFUserFeedbackSender getSender() {
        return sender;
    }

    public void setSender(IAFUserFeedbackSender sender) {
        this.sender = sender;
    }
}
