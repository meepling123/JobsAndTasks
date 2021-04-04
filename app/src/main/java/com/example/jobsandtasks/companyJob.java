package com.example.jobsandtasks;

import java.util.ArrayList;

public class companyJob {

    String jobTitle;
    String postalCode;
    String locArea;
    String country;
    String description;
    ArrayList<String> skills;
    boolean isOnline;
    int age;
    company c;

    public companyJob(String jobTitle, String country,String postalCode, String locArea, ArrayList<String> skills, boolean isOnline, int age, String desc, company c) {
        this.jobTitle = jobTitle;
        this.postalCode = postalCode;
        this.locArea = locArea;
        this.skills = skills;
        this.isOnline = isOnline;
        this.age = age;
        this.country = country;
        this.description = desc;
        this.c = c;
    }

    public String getJobTitle() {return jobTitle;}
    public String getPostalCode() {return postalCode;}
    public String getRegion() {return  locArea;}
    public String getDescription() {return description;}
    public ArrayList<String> getSkills() {return skills;}
    public String getSpecSkills(int i) {return skills.get(i);}
    public boolean isOnline() {return isOnline;}
    public int getAge() {return age;}
    public company getCompany() {return c;}
}
