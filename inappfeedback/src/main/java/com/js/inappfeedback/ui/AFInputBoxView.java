package com.js.inappfeedback.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.js.inappfeedback.R;
import com.js.inappfeedback.widgets.AFEditText;

/**
 * Created by sowmi on 13/04/16.
 */
public class AFInputBoxView extends LinearLayout implements View.OnClickListener{

    private AFInputBoxActionListener listener;
    private AFEditText mInputEditTetView;

    public AFInputBoxView(Context context) {
        super(context);
        init(context);
    }

    public AFInputBoxView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public AFInputBoxView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context){
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.js_af_layout_inputtxtbox, null, false);
        addView(view);
        mInputEditTetView = (AFEditText)findViewById(R.id.af_inputbox_edittext_feedbackdesc);
        view.findViewById(R.id.af_inputbox_button_save).setOnClickListener(this);
        view.findViewById(R.id.af_inputbox_button_close).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mInputEditTetView.closeKeyboard();
        if(v.getId() == R.id.af_inputbox_button_save){
           if(listener !=null ){
             listener.onSave(mInputEditTetView.getTextString());
           }
        }else if(v.getId() == R.id.af_inputbox_button_close){
            mInputEditTetView.clear();
            if(listener !=null ){
              listener.onclose();
            }
        }
    }

    public void setListener(AFInputBoxActionListener listener) {
        this.listener = listener;
    }

    public String getInputText() {
        return mInputEditTetView.getTextString();
    }

    public interface AFInputBoxActionListener{
        public void onSave(String text);
        public void onclose();
    }

}
