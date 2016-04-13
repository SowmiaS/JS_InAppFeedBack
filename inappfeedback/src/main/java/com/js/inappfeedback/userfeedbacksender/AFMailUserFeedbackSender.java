package com.js.inappfeedback.userfeedbacksender;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

/**
 * Created by sowmi on 11/04/16.
 */
public class AFMailUserFeedbackSender implements IAFUserFeedbackSender {

    private IAFUserFeedbackSendListener listener;
    private String emailId;

    public AFMailUserFeedbackSender(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public void sendFeedBack(Context context, Bitmap screenshot, String feedbackText) {
        sendEmail(context, new AFMailStructure(emailId, feedbackText , getImageUri(context,screenshot)));
    }

    @Override
    public void sendFeedBack(Context context, Bitmap screenshot) {
        sendFeedBack(context, screenshot, "");
    }

    @Override
    public void sendFeedBack(Context context, String feedbackText) {
        sendFeedBack(context, null , feedbackText);
    }

    public void setListener(IAFUserFeedbackSendListener listener) {
        this.listener = listener;
    }

    public static void sendEmail(Context context, AFMailStructure emailStructure){
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

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG,100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "Title", null);
        return Uri.parse(path);
    }
}
