package com.swarawan.recyclerview_sample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.swarawan.recyclerview_sample.R;
import com.swarawan.recyclerview_sample.model.Student;

import java.util.List;

/**
 * Created by rioswarawan on 10/26/17.
 */

public class StudentMultiAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<Student> students;
    private LayoutInflater inflater;

    public StudentMultiAdapter(Context context, List<Student> students) {
        this.context = context;
        this.students = students;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = null;
        if (viewType == 1) {
            view = inflater.inflate(R.layout.item_right, parent, false);
        } else {
            view = inflater.inflate(R.layout.item_left, parent, false);
        }
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Student model = students.get(position);
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.populate(model);
    }

    @Override
    public int getItemViewType(int position) {
        if (position % 2 == 0) {
            return 0;
        }
        return 1;
    }

    @Override
    public int getItemCount() {
        return students.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView email;

        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.student_name);
            email = itemView.findViewById(R.id.student_email);
        }

        void populate(Student student) {
            name.setText(student.name);
            email.setText(student.email);
        }
    }
}
