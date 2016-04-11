package com.js.inappfeedback.userfeedbackformat;

import android.graphics.Bitmap;

/**
 * Created by sowmi on 11/04/16.
 */
public class UserFeedBack {

    private Bitmap mUserFeedbackScreenshot;

    private String mUserFeedbackDesc;

    private String mUserId;

    public String getmUserFeedbackDesc() {
        return mUserFeedbackDesc;
    }

    public void setmUserFeedbackDesc(String mUserFeedbackDesc) {
        this.mUserFeedbackDesc = mUserFeedbackDesc;
    }

    public Bitmap getmUserFeedbackScreenshot() {
        return mUserFeedbackScreenshot;
    }

    public void setmUserFeedbackScreenshot(Bitmap mUserFeedbackScreenshot) {
        this.mUserFeedbackScreenshot = mUserFeedbackScreenshot;
    }

    public String getmUserId() {
        return mUserId;
    }

    public void setmUserId(String mUserId) {
        this.mUserId = mUserId;
    }
}
