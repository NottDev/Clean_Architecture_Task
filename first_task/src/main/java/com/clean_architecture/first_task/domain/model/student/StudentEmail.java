package com.clean_architecture.first_task.domain.model.student;

public class StudentEmail {

    private final String value;

    public StudentEmail(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
