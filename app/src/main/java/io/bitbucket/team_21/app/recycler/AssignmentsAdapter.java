package io.bitbucket.team_21.app.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import io.bitbucket.team_21.app.R;

public class AssignmentsAdapter extends RecyclerView.Adapter<AssignmentsAdapter.ViewHolder> {

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView subjectTextView;
        TextView dueDateTextView;
        TextView nameTextView;
        TextView pointsTextView;
        TextView durationTextView;

        // Constructor
        ViewHolder(View itemView) {
            super(itemView);

            subjectTextView = (TextView) itemView.findViewById(R.id.assignmentSubject);
            dueDateTextView = (TextView) itemView.findViewById(R.id.assignmentDueDate);
            nameTextView = (TextView) itemView.findViewById(R.id.assignmentName);
            pointsTextView = (TextView) itemView.findViewById(R.id.assignmentPoints);
            durationTextView = (TextView) itemView.findViewById(R.id.assignmentDuration);
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

        // Preprocessing on the due date text
        String dueDatePrefix;
        if (assignment.getOverdue()) {
            dueDatePrefix = "D+";
        }
        else {
            dueDatePrefix = "D-";
        }

        // Set views
        holder.subjectTextView.setText(String.valueOf(assignment.getSubject()));
        holder.dueDateTextView.setText(String.valueOf(dueDatePrefix + assignment.getDays()));
        holder.nameTextView.setText(String.valueOf(assignment.getName()));
        holder.pointsTextView.setText(String.valueOf(assignment.getPoints()));
        holder.durationTextView.setText(String.valueOf("~" + assignment.getDuration() + " minutes"));

        // Animations
//        AlphaAnimation aAnim = new AlphaAnimation(0.0f, 1.0f);
//        TranslateAnimation tAnim = new TranslateAnimation(0.0f, 0.0f, -20.0f, 0.0f);
//        ScaleAnimation sAnim = new ScaleAnimation(1.00f, 1.00f,  1.05f,  1.00f,  0.50f,  0.50f);
//        aAnim.setDuration(500);
//        tAnim.setDuration(500);
//        sAnim.setDuration(500);
//        holder.itemView.startAnimation(aAnim);
//        holder.itemView.startAnimation(tAnim);
//        holder.itemView.startAnimation(sAnim);
    }

    @Override
    public int getItemCount() {
        return assignments.size();
    }
}
