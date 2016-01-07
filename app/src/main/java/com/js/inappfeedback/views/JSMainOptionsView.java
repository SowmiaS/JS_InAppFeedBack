package com.js.inappfeedback.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.js.inappfeedback.R;
import com.js.inappfeedback.utils.AndroidBaseUtils;

/**
 * Created by sowmia on 17/12/15.
 */
public class JSMainOptionsView extends LinearLayout implements View.OnClickListener{

    private JSMainOptionsActions mJSMainOptionsAction;

    private JSMainOptionsView(Context context) {
        super(context);
        init(context);
    }

    public JSMainOptionsView(Context context, JSMainOptionsActions mImpInstaBugMainOptionsAction) {
        super(context);
        init(context);
        this.mJSMainOptionsAction = mImpInstaBugMainOptionsAction;
    }


    private JSMainOptionsView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private JSMainOptionsView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        setOrientation(VERTICAL);
        AndroidBaseUtils.inflateLayout(context, R.layout.js_mainoptions, this);
        setClickListeners();
    }

    private void setClickListeners() {
        findViewById(R.id.txt_instabug_mainoptions_reportbug).setOnClickListener(this);
        findViewById(R.id.txt_instabug_mainoptions_feedback).setOnClickListener(this);
        findViewById(R.id.txt_instabug_mainoptions_dismiss).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d("IMP_InstaBug","Report a Bug");
        if(v.getId() == R.id.txt_instabug_mainoptions_reportbug){
            Log.d("IMP_InstaBug","Report a Bug");
            if(mJSMainOptionsAction !=null){
                mJSMainOptionsAction.onClickOfReportBug();
            }
        }else if(v.getId() == R.id.txt_instabug_mainoptions_feedback){
            Log.d("IMP_InstaBug","FeedBack");

            if(mJSMainOptionsAction !=null){
                mJSMainOptionsAction.onClickOfFeedBack();
            }
        }else if(v.getId() == R.id.txt_instabug_mainoptions_dismiss){
            Log.d("IMP_InstaBug","Dismiss");
            if(mJSMainOptionsAction !=null){
                mJSMainOptionsAction.onClickOfDismiss();
            }
        }
    }


    public interface JSMainOptionsActions{
        public void onClickOfReportBug();
        public void onClickOfFeedBack();
        public void onClickOfDismiss();
    }
}
