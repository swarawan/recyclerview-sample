package com.swarawan.recyclerview_sample.model;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rioswarawan on 10/26/17.
 */

public class Student {

    public int id;
    public String name;
    public String email;

    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    /**
     * Dummy data
     *
     */
    public static List<Student> getAll() {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Rio Swarawan", "swarawan.rio@gmail.com"));
        students.add(new Student(2, "Dian Ma'ruf", "dianmaruf1997@gmail.com"));
        students.add(new Student(3, "Qisthia Kattania", "kattania.q@gmail.com"));

        return students;
    }
}
