package com.bbit2.Models;

import javax.persistence.*;

@Entity
@Table(name= "universities")
public class University {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
   @Column(name = "university_name")
    private String universityName;
   @Column(name = "location")
    private String location;

    public University(String universityName, String location) {
        this.universityName = universityName;
        this.location = location;
    }
    private University(){

    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



}
