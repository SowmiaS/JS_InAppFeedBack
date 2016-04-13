package com.js.inappfeedback.ui;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.js.inappfeedback.R;

/**
 * Created by sowmi on 13/04/16.
 */
public class AFUserFeedBackMainView extends LinearLayout implements View.OnClickListener, AFInputBoxView.AFInputBoxActionListener{

    private AFDrawingView drawingView;
    private AFInputBoxView inputBoxView;
    private IAFUserFeedBackMainViewActionListener listener;

    public AFUserFeedBackMainView(Context context) {
        super(context);
        initView(context);
    }

    public AFUserFeedBackMainView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public AFUserFeedBackMainView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.js_af_layout_userfeedbackoption_main, null, false);
        addView(view);
        drawingView = (AFDrawingView)view.findViewById(R.id.js_af_ll_userfeedback_main_screenshotimg);
        inputBoxView = (AFInputBoxView) view.findViewById(R.id.js_af_ll_userfeedback_main_inputbox);
        inputBoxView.setListener(this);
        view.findViewById(R.id.af_button_topbar_cancel).setOnClickListener(this);
        view.findViewById(R.id.af_button_topbar_send).setOnClickListener(this);
        view.findViewById(R.id.af_imgbutton_bottombar_draw).setOnClickListener(this);
        view.findViewById(R.id.af_imgbutton_bottombar_text).setOnClickListener(this);
        view.findViewById(R.id.af_imgbutton_bottombar_delete).setOnClickListener(this);
    }

    public void setScreenshotImage(Bitmap bitmap){
        drawingView.setScreenshotImg(bitmap);
    }


    @Override
    public void onClick(View v) {
        drawingView.setmEnableDrawing(false);
        if(v.getId() == R.id.af_button_topbar_cancel){
            if (listener != null) {
                listener.onCancelBtnClick();
            }
        }else if (v.getId() == R.id.af_button_topbar_send){
            if (listener != null) {
                listener.onSendBtnClick();
            }
        }else if (v.getId() == R.id.af_imgbutton_bottombar_draw) {
            drawingView.setmEnableDrawing(true);
        }else if (v.getId() == R.id.af_imgbutton_bottombar_text) {
            showInputBoxView();
        }else if (v.getId() == R.id.af_imgbutton_bottombar_delete) {
            drawingView.clearDrawing();
        }
    }

    public void setListener(IAFUserFeedBackMainViewActionListener listener) {
        this.listener = listener;
    }

    private void showInputBoxView(){
        final ObjectAnimator inputBoxAnimator = ObjectAnimator.ofFloat(inputBoxView, View.TRANSLATION_Y,  inputBoxView.getY(), 0);
        inputBoxAnimator.setDuration(300);
        inputBoxAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                inputBoxView.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        inputBoxAnimator.start();
    }

    private void closeInputBoxView(){
        final ObjectAnimator inputBoxAnimator = ObjectAnimator.ofFloat(inputBoxView, View.TRANSLATION_Y,  0, inputBoxView.getY());
        inputBoxAnimator.setDuration(300);
        inputBoxAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                inputBoxView.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
        inputBoxAnimator.start();
    }

    @Override
    public void onSave(String text) {
        closeInputBoxView();
    }

    @Override
    public void onclose() {
        closeInputBoxView();
    }

    public interface IAFUserFeedBackMainViewActionListener{
        public void onCancelBtnClick();
        public void onSendBtnClick();
    }


    public String getInputString(){
        return inputBoxView.getInputText();
    }

    public Bitmap getScreenshot(){
        return drawingView.getBitmap();
    }
}
