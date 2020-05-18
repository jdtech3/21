package io.bitbucket.team_21.app.recycler;

import java.util.ArrayList;

public class Assignment {
    int days;
    String name;
    int points;
    String subject;
    boolean overdue;

    Assignment(int days, String name, int points, String subject, boolean overdue) {
        this.days = days;
        this.name = name;
        this.points = points;
        this.subject = subject;
        this.overdue = overdue;
    }

    // Method for creating dummy assignments (returns as ArrayList)
    public static ArrayList<Assignment> createDummyAssignments(String type) {
        ArrayList<Assignment> assignments = new ArrayList<>();
        if (type.equals("upcoming")) {
            assignments.add(new Assignment(2, "Annotated Bibliography", 500, "English 10", false));
            assignments.add(new Assignment(5, "Week 8 Homework", 300, "Mandarin 11", false));
            assignments.add(new Assignment(7, "Game of Apps - Pitch Presentation", 350, "GoA S3", false));
            assignments.add(new Assignment(9, "Ch. 6 - Section 6.3", 200, "Pre-Cal. 11", false));
        }
        else if (type.equals("overdue")) {
            assignments.add(new Assignment(3, "Daily Physical Activity Log", 25, "PE 10", true));
            assignments.add(new Assignment(4, "Spaceship Design - Pt. 1", 75, "Robotics 10", true));
        }

        return assignments;
    }

    // --- Getters ---
    public int getDays() {
        return days;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public String getSubject() {
        return subject;
    }

    public boolean getOverdue() {
        return overdue;
    }
}
