package com.swarawan.recyclerview_sample.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.swarawan.recyclerview_sample.R;
import com.swarawan.recyclerview_sample.adapter.StudentAdapter;
import com.swarawan.recyclerview_sample.callback.RecyclerViewCallback;
import com.swarawan.recyclerview_sample.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rioswarawan on 10/26/17.
 */

public class HorizontalListActivity extends AppCompatActivity {

    private StudentAdapter studentAdapter;
    private List<Student> students;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        students = new ArrayList<>();
        studentAdapter = new StudentAdapter(this, students, callback);

        ((RecyclerView) findViewById(R.id.list)).setAdapter(studentAdapter);
        ((RecyclerView) findViewById(R.id.list)).setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        loadData();
    }

    private void loadData() {
        students.addAll(Student.getAll());
        studentAdapter.notifyDataSetChanged();
    }

    private RecyclerViewCallback callback = new RecyclerViewCallback() {
        @Override
        public void onSelectedItem(int position) {
            Student student = students.get(position);
            Toast.makeText(HorizontalListActivity.this, "Selected: " + student, Toast.LENGTH_SHORT).show();
        }
    };
}
