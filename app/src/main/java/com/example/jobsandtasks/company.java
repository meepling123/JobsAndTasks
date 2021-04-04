package com.example.jobsandtasks;

import android.annotation.TargetApi;

import com.google.android.material.shape.CornerFamily;

import org.intellij.lang.annotations.Pattern;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.TestOnly;

import java.util.ArrayList;

public class company {

    String Name;
    String Country;
    String postalCode;
    String Region;
    String description;
    ArrayList<companyJob> jobs = new ArrayList<companyJob>();
    String email = "company@gmail.com";

    public company(String name, String Country, String postalCode, String region, String description)
    {
        this.Name = name;
        this.Country = Country;
        this.postalCode = postalCode;
        this.Region = region;
        this.description = description;
    }

    public String makeEmail()
    {
        email = "" + Name.substring(0,2) + Country.substring(0,1) + postalCode.substring(0,2) + "@gmail.com";
        return email;
    }

    public String getName(){return Name;}
    public String getCountry(){return Country;}
    public String getPostalCode(){return postalCode;}
    public String getRegion(){return Region;}
    public String getDescription(){return description;}
    public String getEmail() {return email;}

    public void setName(String change){Name = change;}
    public void setCountry(String change){Country = change;}
    public void setPostalCode(String change){postalCode = change;}
    public void setRegion(String change){Region = change;}
    public void setDescription(String change){description = change;}


    public void addJob(companyJob job)
    {
        jobs.add(job);
    }

    public ArrayList<companyJob> getJobs(){return jobs;}

    public companyJob getJob(int i)
    {
        return jobs.get(i);
    }

    public int getNumJobs() {return jobs.size();}

    public companyJob getSpecificJob(employee e, int start)
    {
        int i = 0;
        int j = 0;
        int k = 0;
        boolean matchSkills = false;
        boolean oldEnough = false;
        boolean canAccessJob = false;

        for (i = start; i < jobs.size(); i++)
        {
            for (j = 0; j < e.getSkillSize(); j++)
            {
                for (k = 0; k < jobs.get(i).getSkills().size(); k++)
                {
                    if (e.getSpecSkill(j).equals(jobs.get(i).getSpecSkills(k)))
                    {
                        matchSkills = true;
                    }
                    if (e.getAge() >= jobs.get(i).getAge())
                    {
                        oldEnough = true;
                    }
                    if (jobs.get(i).isOnline() == true || jobs.get(i).postalCode.equals(e.getEmpPostal()) || jobs.get(i).locArea.equals(e.getEmpLocalArea()))
                    {
                        canAccessJob = true;
                    }
                    if (matchSkills == true && oldEnough == true && canAccessJob == true)
                    {
                        return jobs.get(i);
                    }
                }
            }
        }

        return null;
    }

    public @NotNull String toString()
    {
        return Name+Country+postalCode+Region+description;
    }

}
