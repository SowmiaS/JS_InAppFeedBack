package com.js.inappfeedback.userfeedbacksender;

import android.content.Context;

import com.js.inappfeedback.userfeedbackformat.UserFeedBack;

/**
 * Created by sowmi on 11/04/16.
 */
public interface IAFUserFeedbackSender {

    public void sendFeedBack(Context context, UserFeedBack userFeedBack);

}
