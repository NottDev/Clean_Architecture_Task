package com.clean_architecture.first_task.domain.model.student;

public class StudentId {

    private final Long value;

    public StudentId(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}
