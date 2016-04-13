package com.js.inappfeedback.userfeedbacksender;

import android.content.Context;
import android.graphics.Bitmap;

/**
 * Created by sowmi on 11/04/16.
 */
public interface IAFUserFeedbackSender {

    public void sendFeedBack(Context context, Bitmap screenshot , String feedbackText);
    public void sendFeedBack(Context context, Bitmap screenshot);
    public void sendFeedBack(Context context, String feedbackText);

}
