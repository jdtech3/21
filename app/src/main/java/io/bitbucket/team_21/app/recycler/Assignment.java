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
            assignments.add(new Assignment(2, "assignment 1", 100, "IT", false));
            assignments.add(new Assignment(5, "assignment 2", 500, "English", false));
            assignments.add(new Assignment(7, "assignment 3", 300, "GoA", false));
            assignments.add(new Assignment(9, "assignment 4", 200, "ICE CREAM", false));
        }
        else if (type.equals("overdue")) {
            assignments.add(new Assignment(3, "overdue assignment 1", 25, "IT", true));
            assignments.add(new Assignment(4, "overdue assignment 2", 125, "English", true));
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
