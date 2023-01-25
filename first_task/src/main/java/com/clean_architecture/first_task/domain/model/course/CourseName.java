package com.clean_architecture.first_task.domain.model.course;

public class CourseName {
    private final String value;

    public CourseName(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
