package com.akoca.mvc.model;

import com.akoca.mvc.annotation.CourseCode;

import java.util.ArrayList;

public class Student {

    private String firstName;
    private String lastName;
    private String country;
    private String favoriteLanguage;

    private ArrayList<String> operatingSystems;

    @CourseCode(value = {"BIL" , "CSE"} , message = "Course Code Must Start With BIL or CSE")
    private String courseCode;

    public Student () {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public ArrayList<String> getOperatingSystems() {
        return operatingSystems;
    }

    public void setOperatingSystems(ArrayList<String> operatingSystems) {
        this.operatingSystems = operatingSystems;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }
}