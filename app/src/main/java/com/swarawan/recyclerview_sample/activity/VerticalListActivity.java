package com.swarawan.recyclerview_sample.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.swarawan.recyclerview_sample.R;
import com.swarawan.recyclerview_sample.adapter.StudentAdapter;
import com.swarawan.recyclerview_sample.adapter.StudentMultiAdapter;
import com.swarawan.recyclerview_sample.model.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rioswarawan on 10/26/17.
 */

public class VerticalListActivity extends AppCompatActivity {

    private StudentAdapter studentAdapter;
    private List<Student> students;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        // setting up data
        students = new ArrayList<>();
        studentAdapter = new StudentAdapter(this, students);

        // setting up recycler view
        RecyclerView list = findViewById(R.id.list);
        list.setAdapter(studentAdapter);
        list.setLayoutManager(new LinearLayoutManager(this));

        loadData();
    }

    private void loadData() {
        students.addAll(Student.getAll());
        studentAdapter.notifyDataSetChanged();
    }
}
