package com.js.inappfeedback;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;

import java.io.File;

import com.js.inappfeedback.R;
import com.js.inappfeedback.core.JSInAppFeedBack;
import com.js.inappfeedback.utils.AndroidBaseUtils;
import com.js.inappfeedback.utils.model.EmailStructure;

public class MainActivity extends FragmentActivity {

    private ImageView imgResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        JSInAppFeedBack.initialise(this);
        JSInAppFeedBack.setupEmailId("sowmia.sundararajan@bnpparibasfortis.com");
    }

    @Override
    protected void onResume() {
        super.onResume();
        imgResult = (ImageView)findViewById(R.id.resultimg);
        findViewById(R.id.btnGoToBug).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imgResult.setImageBitmap(AndroidBaseUtils.captureScreenShotOfApp(MainActivity.this));
                File file = new File("/storage/emulated/0/InAppFeedBack/abc.png");
                Uri myUri = Uri.fromFile(file);
                EmailStructure emailStructure = new EmailStructure(JSInAppFeedBack.getEmailId(),"IMP App FeedBack", "Some times the securities account page is empyt", myUri);


                AndroidBaseUtils.sendEmail(MainActivity.this,emailStructure);
            }
        });
    }

}
