package com.example.uwmlh.psykick;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by nngo1 on 02-Dec-17.
 */

public class RecipientManager {

    /**
     * Hard coded list of courses, should retrieve from student timetable in the future
     */
    private List<Recipient> recipients;

    public List<Recipient> getList() {
        recipients = new ArrayList<>();
        recipients.add(new Recipient("Algorithms", "CS341", "Dr. Dhuque", "dhuqued@gmail.com"));
        recipients.add(new Recipient("Concurrent and Parallel Programming", "CS343", "Dr. Doge", "doggo@gmail.com"));
        recipients.add(new Recipient("Introduction to Database Management", "CS348", "Dr. Kaht", "meowmeow@hotmail.com"));
        recipients.add(new Recipient("User Interfaces", "CS349", "Dr. Fawkes", "fawkesf@gmail.com"));
        recipients.add(new Recipient("Operating Systems", "CS350", "Dr. Swann", "swanns@gmail.com"));

        return recipients;
    }
}