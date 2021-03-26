package com.example.jobsandtasks;
import org.jetbrains.annotations.NotNull;

import java.util.stream.*;
public class employee
{
    String fName, lName, empEmail, empPhone, empPassword, empCountry, empPostal, empArea, empprevJob, school, degree;


    boolean isStudent = false;

          
    public employee(String firstName, String lastName, String Email, String phone, String password
            , String Country, String PostalCode, String locArea, String preJob,String School, String Degree, boolean student)
    {
        if (preJob == null) {preJob = "No previous work experience";}
        if (Degree == null) {Degree = "Not yet graduated";}
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

    public void setFName(String change){fName = change;}
    public void setlName(String change){lName = change;}
    public void setEmpEmail(String change){empEmail = change;}
    public void setEmpPhone(String change){empPhone = change;}
    public void setEmpPassword(String change){empPassword = change;}
    public void setEmpCountry(String change){empCountry = change;}
    public void setEmpPostal(String change){empPostal = change;}
    public void setEmpLocalArea(String change){empArea = change;}
    public void setemprevJob(String change){empprevJob = change;}
    public void setSchool(String change){school = change;}
    public void setDegree(String change){degree = change;}

    public @NotNull String toString()
    {
        return  fName+lName+empEmail+empPhone+empPassword+empCountry+empPostal+empArea+school+degree+empprevJob;
    }

}
