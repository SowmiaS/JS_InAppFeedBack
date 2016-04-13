package com.js.inappfeedback.core;

import android.content.Context;

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

    private static AFUserFeedBackFactory userFeedbackFactory;

    private AFUserFeedBackFactory(Context context, String emailId) {
        userFeedBackMainView = new AFUserFeedBackMainView(context);
        sender = new AFMailUserFeedbackSender(emailId);
    }

    private AFUserFeedBackFactory(Context context) {
        userFeedBackMainView = new AFUserFeedBackMainView(context);
        sender = new AFServiceUserFeedbackSender();
    }


    public static AFUserFeedBackFactory getInstance(Context context){
        if(userFeedbackFactory == null){
            userFeedbackFactory = new AFUserFeedBackFactory(context);
        }
        return userFeedbackFactory;
    }

    public static AFUserFeedBackFactory getInstance(Context context, String emailId){
        if(userFeedbackFactory == null){
            userFeedbackFactory = new AFUserFeedBackFactory(context, emailId);
        }
        return userFeedbackFactory;
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
