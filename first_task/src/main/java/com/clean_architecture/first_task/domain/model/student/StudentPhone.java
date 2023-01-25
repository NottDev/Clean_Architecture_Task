package com.clean_architecture.first_task.domain.model.student;

public class StudentPhone {
    private final Integer value;

    public StudentPhone(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }
}
