package com.js.inappfeedback.ui;

import android.content.Context;

/**
 * Created by sowmi on 11/04/16.
 */
public interface IAFFeedbackUI {

    public void showFeedBackOption(Context context);

    public void takeCurrentScreenshot(Context context);

    public void drawTopBar(Context context);

    public void drawBottomBar(Context context);

    public void closeFeedBackOption(Context context);

    public void drawAsPerUserTouch(Context context);

    public void showInputDialog(Context context);

    public void eraseDrawn(Context context);

    public void eraseText(Context context);
}
