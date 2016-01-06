package inappfeedback.imp.com.inappfeedback.utils;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Environment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

import inappfeedback.imp.com.inappfeedback.utils.model.EmailStructure;

/**
 * Created by sowmia on 17/12/15.
 */
public class AndroidBaseUtils {

    public static final String DEST_PATH = Environment.getExternalStorageDirectory() + "/InAppFeedBack/";

    public static void sendEmail(Context context, EmailStructure emailStructure){
        Intent i = new Intent(Intent.ACTION_SEND);
//        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{emailStructure.getEmailId()});
        i.putExtra(Intent.EXTRA_SUBJECT, emailStructure.getSubject());
        i.putExtra(Intent.EXTRA_TEXT   , emailStructure.getEmailBody());
        i.setType("image/*");
        if(emailStructure.getmUri() != null) {
            i.putExtra(Intent.EXTRA_STREAM, emailStructure.getmUri());
        }
        try {
            context.startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(context, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }
    }


    public static void inflateLayout(Context context, int imp_instabug_mainoptions, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(imp_instabug_mainoptions, parent);
    }

    public static Bitmap captureScreenShotOfApp(FragmentActivity activity) {
        if(activity!=null && activity.findViewById(android.R.id.content) !=null) {
            View rootView = activity.findViewById(android.R.id.content);
    //            rootView.measure(View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED),
    //                    View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
    //            rootView.layout(0, 0, rootView.getMeasuredWidth(), rootView.getMeasuredHeight());
            rootView.setDrawingCacheEnabled(true);
            rootView.buildDrawingCache(true);
            Bitmap bitmap = Bitmap.createBitmap(rootView.getDrawingCache());
            try {
                storeBitmap(bitmap, "abc");
            }catch (Exception e){
                e.printStackTrace();
            }
            rootView.setDrawingCacheEnabled(false);
            return bitmap;
        }
        return null;
    }

    public static void storeBitmap(Bitmap bitmap, String filename) throws  Exception{

        File f = new File(Environment.getExternalStorageDirectory() + "/InAppFeedBack");
        Log.d("InAppDemo", "External Storage Directory:" + Environment.getExternalStorageDirectory().getAbsolutePath());

        if (!f.exists()) {
            f.mkdirs();
        }

        FileOutputStream out = new FileOutputStream(DEST_PATH+filename + ".png");
        bitmap.compress(Bitmap.CompressFormat.PNG, 90, out);
        out.flush();
        out.close();
    }






}
