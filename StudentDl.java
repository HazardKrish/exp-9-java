package com.example.springdi;

public class StudentDI {
    private Course course;

    public StudentDI(Course course) {
        this.course = course;
    }

    public void startStudying() {
        System.out.println("Student is starting...");
        course.study();
    }
}
