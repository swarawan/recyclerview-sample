package com.swarawan.recyclerview_sample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.swarawan.recyclerview_sample.R;
import com.swarawan.recyclerview_sample.callback.RecyclerViewCallback;
import com.swarawan.recyclerview_sample.model.Student;

import java.util.List;

/**
 * Created by rioswarawan on 10/26/17.
 */

public class StudentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Student> students;
    private LayoutInflater inflater;
    private RecyclerViewCallback callback;

    public StudentAdapter(Context context, List<Student> students, RecyclerViewCallback callback) {
        this.context = context;
        this.students = students;
        this.inflater = LayoutInflater.from(context);
        this.callback = callback;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_simple, parent, false);
        return new StudentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        StudentViewHolder viewHolder = (StudentViewHolder) holder;
        Student student = students.get(position);

        // add data to view
        viewHolder.name.setText(student.name);
        viewHolder.email.setText(student.email);

        viewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onSelectedItem(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    /**
     * Inner class : StudentViewHolder
     */
    class StudentViewHolder extends RecyclerView.ViewHolder {

        LinearLayout layout;
        TextView name, email;

        public StudentViewHolder(View itemView) {
            super(itemView);

            layout = itemView.findViewById(R.id.layout);
            name = itemView.findViewById(R.id.student_name);
            email = itemView.findViewById(R.id.student_email);
        }
    }
}
