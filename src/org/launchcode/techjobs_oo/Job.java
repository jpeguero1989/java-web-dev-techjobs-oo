package org.launchcode.techjobs_oo;

import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job(){
        id = nextId;
        nextId++;
    }

    public Job(String name,Employer emp,Location loc, PositionType pos, CoreCompetency core){
        this();
        this.name = name;
        this.employer=emp;
        this.location = loc;
        this.positionType =pos;
        this.coreCompetency = core;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Job job = (Job) o;
        return id == job.id &&
                Objects.equals(employer.getId(), job.employer.getId()) &&
                Objects.equals(location.getId(), job.location.getId()) &&
                Objects.equals(positionType.getId(), job.positionType.getId()) &&
                Objects.equals(coreCompetency.getId(), job.coreCompetency.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, employer.getId(), location.getId(), positionType.getId(), coreCompetency.getId());
    }

    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

    @Override
    public String toString() {

        if (name =="" && location.getValue() =="" && employer.getValue() =="" && positionType.getValue()=="" && coreCompetency.getValue() =="")
        {
            return "OOPS! This job does not seem to exist.";
        }

        return "\n" +
                "ID: " + ((id > 0) ? id : "Data not available") +  "\n" +
                "Name: " + ((name != "") ? name : "Data not available") + "\n" +
                "Employer: " + ((employer.getValue() != "") ? employer : "Data not available") + "\n" +
                "Location: " + ((location.getValue() != "") ? location : "Data not available") + "\n" +
                "Position Type: " + ((positionType.getValue() != "") ? positionType : "Data not available") + "\n" +
                "Core Competency: " + ((coreCompetency.getValue() != "") ? coreCompetency : "Data not available") + "\n";
    }
}
