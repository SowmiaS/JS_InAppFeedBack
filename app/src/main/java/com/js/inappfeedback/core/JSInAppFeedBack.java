package inappfeedback.imp.com.inappfeedback.core;

import android.content.Context;

/**
 * Created by sowmia on 17/12/15.
 */
public class JSInAppFeedBack {

    private static  String emailId ;

    public static void initialise(Context context){
        new JSInAppFeedbackCoreImpl().intialise(context);
    }

    public static void setupEmailId(String EmailId){
        emailId = EmailId;
    }

    public static  String getEmailId(){
        return emailId;
    }


}
