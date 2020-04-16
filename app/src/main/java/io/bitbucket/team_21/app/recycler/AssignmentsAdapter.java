package io.bitbucket.team_21.app.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import io.bitbucket.team_21.app.R;

public class AssignmentsAdapter extends RecyclerView.Adapter<AssignmentsAdapter.ViewHolder> {

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView subjectTextView;
        public TextView dueDateTextView;
        public TextView nameTextView;
        public TextView pointsTextView;

        // Constructor
        public ViewHolder(View itemView) {
            super(itemView);

            subjectTextView = (TextView) itemView.findViewById(R.id.assignmentSubject);
            dueDateTextView = (TextView) itemView.findViewById(R.id.assignmentDueDate);
            nameTextView = (TextView) itemView.findViewById(R.id.assignmentName);
            pointsTextView = (TextView) itemView.findViewById(R.id.assignmentPoints);
        }
    }

    // Member vars  +  constructor
    private ArrayList<Assignment> assignments;

    public AssignmentsAdapter(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    // Required methods
    @NonNull
    @Override
    public AssignmentsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Define
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate + return
        View assignmentView = inflater.inflate(R.layout.assignment_card, parent, false);
        return new ViewHolder(assignmentView);
    }

    @Override
    public void onBindViewHolder(AssignmentsAdapter.ViewHolder holder, int position) {
        // Get data
        Assignment assignment = assignments.get(position);

        // Set views
        holder.subjectTextView.setText(String.valueOf(assignment.getSubject()));
        holder.dueDateTextView.setText(String.valueOf("D-" + assignment.getDaysLeft()));
        holder.nameTextView.setText(String.valueOf(assignment.getName()));
        holder.pointsTextView.setText(String.valueOf(assignment.getPoints()));
    }

    @Override
    public int getItemCount() {
        return assignments.size();
    }
}
