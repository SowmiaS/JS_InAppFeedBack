package com.js.inappfeedback.utils.model;

import android.net.Uri;

/**
 * Created by sowmia on 17/12/15.
 */
public class EmailStructure {

    private static final String IMP_INSTABUG_REPORT =  "IMP_INSTABUG_REPORT";
    private String emailId;
    private String subject;
    private String emailBody;
    private Uri mUri;


    public EmailStructure(String emailId, String emailBody) {
        this.emailId = emailId;
        this.emailBody = emailBody;
        this.subject = IMP_INSTABUG_REPORT;
    }

    public EmailStructure(String emailId, String subject, String emailBody) {
        this.emailId = emailId;
        this.subject = subject;
        this.emailBody = emailBody;
    }

    public EmailStructure(String emailId, String subject, String emailBody, Uri myUri) {
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
