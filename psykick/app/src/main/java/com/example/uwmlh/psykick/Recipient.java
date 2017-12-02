package com.example.uwmlh.psykick;

/**
 * Created by nngo1 on 02-Dec-17.
 */

/**
 * Describes a recipient of an excusal and how to send an email to them
 */
public class Recipient {
    private String courseName;
    private String code;
    private String profName;
    private String email;

    public Recipient(String courseName, String code, String profName, String email) {
        this.courseName = courseName;
        this.code = code;
        this.profName = profName;
        this.email = email;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCode() {
        return code;
    }

    public String getProf() {
        return profName;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return courseName + " " + code + " " + profName + " " + email;
    }

    public void sendEmail() {

    }
}
