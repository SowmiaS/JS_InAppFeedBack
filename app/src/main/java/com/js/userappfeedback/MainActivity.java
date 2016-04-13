package com.js.userappfeedback;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.js.inappfeedback.core.AFInAppFeedback;

public class MainActivity extends FragmentActivity {

    private ImageView imgResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AFInAppFeedback feedback = AFInAppFeedback.initialise(this, "sowmiasundar@gmail.com");
        feedback.showFeedBackOptions(this, (LinearLayout) findViewById(R.id.container));
//        JSInAppFeedBack.initialise(this);
//        JSInAppFeedBack.setupEmailId("sowmia.sundararajan@bnpparibasfortis.com");
    }

    @Override
    protected void onResume() {
        super.onResume();
//        imgResult = (ImageView)findViewById(R.id.resultimg);
//        findViewById(R.id.btnGoToBug).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                imgResult.setImageBitmap(AndroidBaseUtils.captureScreenShotOfApp(MainActivity.this));
//                File file = new File("/storage/emulated/0/InAppFeedBack/abc.png");
//                Uri myUri = Uri.fromFile(file);
//                EmailStructure emailStructure = new EmailStructure(JSInAppFeedBack.getEmailId(),"IMP App FeedBack", "Some times the securities account page is empyt", myUri);
//
//
//                AndroidBaseUtils.sendEmail(MainActivity.this,emailStructure);
//            }
//        });
    }

}
