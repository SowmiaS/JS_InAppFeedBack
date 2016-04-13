package com.js.inappfeedback.userfeedbacksender;

/**
 * Created by sowmi on 13/04/16.
 */
public interface IAFUserFeedbackSendListener {

    public void onSuccess();

    public void onFail(String errorMessage);

    public void onConnectionTimeOut();

}
