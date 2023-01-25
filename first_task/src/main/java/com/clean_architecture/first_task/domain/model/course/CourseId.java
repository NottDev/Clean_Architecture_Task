package com.clean_architecture.first_task.domain.model.course;

public class CourseId {
    private final Long value;

    public CourseId(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}
