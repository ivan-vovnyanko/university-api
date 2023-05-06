package com.test.universityapi.model;

public enum Degree {

    ASSISTANT("assistants"),
    ASSOCIATE_PROFESSOR("associate professors"),
    PROFESSOR("professors");

    private String degreeName;

    public String getDegreeName() {
        return degreeName;
    }

    Degree(String degreeName) {
        this.degreeName = degreeName;
    }
}
