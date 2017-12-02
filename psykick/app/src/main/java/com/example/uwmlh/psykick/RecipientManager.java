package com.example.uwmlh.psykick;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nngo1 on 02-Dec-17.
 */

public class RecipientManager {
    private static String TEST_EMAIL = "ngonathanieldean@gmail.com";
    /**
     * Hard coded list of courses, should retrieve from student timetable in the future
     */
    private List<Recipient> recipients;

    public List<Recipient> getList() {
        recipients = new ArrayList<>();
        recipients.add(new Recipient("Algorithms", "CS341", "Dr. Dhuque", TEST_EMAIL));
        recipients.add(new Recipient("Concurrent and Parallel Programming", "CS343", "Dr. Doge", TEST_EMAIL));
        recipients.add(new Recipient("Introduction to Database Management", "CS348", "Dr. Kaht", TEST_EMAIL));
        recipients.add(new Recipient("User Interfaces", "CS349", "Dr. Fawkes", TEST_EMAIL));
        recipients.add(new Recipient("Operating Systems", "CS350", "Dr. Swann", TEST_EMAIL));

        return recipients;
    }
}