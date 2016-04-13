package com.js.inappfeedback.widgets;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

/**
 * Created by sowmi on 14/04/16.
 */
public class AFEditText extends EditText {

    public AFEditText(Context context) {
        super(context);
    }

    public AFEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AFEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void closeKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getWindowToken(), 0);
    }

    public String getTextString(){
        return getText().toString();
    }

    public void clear(){
        setText("");
    }
}
