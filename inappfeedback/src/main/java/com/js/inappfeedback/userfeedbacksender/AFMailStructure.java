package com.js.inappfeedback.userfeedbacksender;

import android.net.Uri;

/**
 * Created by sowmi on 14/04/16.
 */
public class AFMailStructure {

    private static final String IMP_INSTABUG_REPORT = "IMP_INSTABUG_REPORT";
    private String emailId;
    private String subject = IMP_INSTABUG_REPORT;
    private String emailBody = "Kindly find the attachment for the feedback.";
    private Uri mUri;


    public AFMailStructure(String emailId, String emailBody) {
        this.emailId = emailId;
        this.emailBody = emailBody;
    }

    public AFMailStructure(String emailId, Uri myUri) {
        this.emailId = emailId;
        this.emailBody = emailBody;
    }

    public AFMailStructure(String emailId, String emailBody, Uri myUri) {
        this.emailId = emailId;
        this.subject = subject;
        this.emailBody = emailBody;
        this.mUri = myUri;
    }

    public String getEmailBody() {
        return emailBody;
    }

    public String getEmailId() {
        return emailId;
    }

    public String getSubject() {
        return subject;
    }

    public Uri getmUri() {
        return mUri;
    }

}
