package com.serenity.hospital.ormcoursework.view.tdm;

public class TherapyProgramTM {
    private String programID;
    private String programName;
    private String description;
    private int duration;
    private double cost;
    private String therapistName;

    public TherapyProgramTM(String programID, String programName, String description, int duration, double cost, String therapistName) {
        this.programID = programID;
        this.programName = programName;
        this.description = description;
        this.duration = duration;
        this.cost = cost;
        this.therapistName = therapistName;
    }

    public String getProgramID() {
        return programID;
    }

    public String getProgramName() {
        return programName;
    }

    public String getDescription() {
        return description;
    }

    public int getDuration() {
        return duration;
    }

    public double getCost() {
        return cost;
    }

    public String getTherapistName() {
        return therapistName;
    }
}
