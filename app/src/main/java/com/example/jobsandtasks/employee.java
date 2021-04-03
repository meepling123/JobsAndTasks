package com.example.jobsandtasks;
import android.widget.ImageView;
import android.widget.LinearLayout;

import org.jetbrains.annotations.NotNull;
import java.util.ArrayList;

import java.util.stream.*;
public class employee
{
    String fName, lName, empEmail, empPhone, empPassword, empCountry, empPostal, empArea, empprevJob, school, degree;
    int age;

    String Bio = "No Biography";
    ArrayList<String> skills = new ArrayList<String>();
    ArrayList<String> contacts = new ArrayList<String>();
    boolean isStudent = false;

          
    public employee(String firstName, String lastName, String Email, String phone, String password
            , String Country, String PostalCode, String locArea, String preJob,String School, String Degree, boolean student, int age)
    {
        if (preJob.equals("")) {preJob = "No previous work experience";}
        if (Degree.equals("")) {Degree = "Not yet graduated";}
           fName = firstName;
           lName = lastName;
        empEmail = Email;
        empPhone = phone;
     empPassword = password;
      empCountry = Country;
       empPostal = PostalCode;
         empArea = locArea;
          school = School;
          degree = Degree;
      empprevJob = preJob;
       isStudent = student;
       this.age = age;
    }

    public String getFName(){return fName;}
    public String getlName(){return lName;}
    public String getEmpEmail(){return empEmail;}
    public String getEmpPhone(){return empPhone;}
    public String getEmpPassword(){return empPassword;}
    public String getEmpCountry(){return empCountry;}
    public String getEmpPostal(){return empPostal;}
    public String getEmpLocalArea(){return empArea;}
    public String getemprevJob(){return empprevJob;}
    public String getSchool(){return school;}
    public String getDegree(){return degree;}
    public String getBio(){return Bio;}
    public boolean isStudent(){return isStudent;}
    public int getAge(){return age;}
    public ArrayList getSkill(){return skills;}
    public String getSpecSkill(int i){return skills.get(i);}
    public ArrayList<String> getContacts() {return contacts;}
    public String getContactByLoop(int i) {return contacts.get(i);}

    public void setFName(String change){this.fName = change;}
    public void setlName(String change){this.lName = change;}
    public void setEmpEmail(String change){this.empEmail = change;}
    public void setEmpPhone(String change){this.empPhone = change;}
    public void setEmpPassword(String change){this.empPassword = change;}
    public void setEmpCountry(String change){this.empCountry = change;}
    public void setEmpPostal(String change){this.empPostal = change;}
    public void setEmpLocalArea(String change){this.empArea = change;}
    public void setemprevJob(String change){this.empprevJob = change;}
    public void setSchool(String change){this.school = change;}
    public void setDegree(String change){this.degree = change;}
    public void setBio(String change){this.Bio = change;}
    public void addSkill(String skill){this.skills.add(skill);}
    public void setAge(int change) {this.age = change;}
    public void addContact(String contact) {contacts.add(contact);}

    public int getSkillSize() {return skills.size();}

    public @NotNull String toString()
    {
        return  fName+lName+empEmail+empPhone+empPassword+empCountry+empPostal+empArea+school+degree+empprevJob+age;
    }

}
