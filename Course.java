package com.example.springdi;

public class Course {
    private String name = "Computer Science";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void study() {
        System.out.println("Studying " + name);
    }
}
