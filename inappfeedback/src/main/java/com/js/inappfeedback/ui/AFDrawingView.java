package com.js.inappfeedback.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Created by sowmi on 12/04/16.
 */
public class AFDrawingView extends ImageView{


    public AFDrawingView(Context context) {
        super(context);
    }

    public AFDrawingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AFDrawingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    private void drawOnTouch(MotionEvent event){

    }
}
