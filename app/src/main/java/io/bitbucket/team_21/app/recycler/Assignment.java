package io.bitbucket.team_21.app.recycler;

import java.util.ArrayList;

public class Assignment {
    int daysLeft;
    String name;
    int points;
    String subject;

    Assignment(int daysLeft, String name, int points, String subject) {
        this.daysLeft = daysLeft;
        this.name = name;
        this.points = points;
        this.subject = subject;
    }

    // Method for creating dummy assignments (returns as ArrayList)
    public static ArrayList<Assignment> createDummyAssignments() {
        ArrayList<Assignment> assignments = new ArrayList<>();
        assignments.add(new Assignment(2, "assignment 1", 100, "IT"));
        assignments.add(new Assignment(5, "assignment 2", 500, "IT"));
        assignments.add(new Assignment(7, "assignment 3", 300, "IT"));
        assignments.add(new Assignment(9, "assignment 4", 200, "IT"));

        return assignments;
    }

    // --- Getters ---
    public int getDaysLeft() {
        return daysLeft;
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
}
