package com.clean_architecture.first_task.domain.model.student;

public class StudentName {
    private final String value;

    public StudentName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
