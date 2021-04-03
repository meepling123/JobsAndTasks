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


    public company(String name, String Country, String postalCode, String region, String description)
    {
        this.Name = name;
        this.Country = Country;
        this.postalCode = postalCode;
        this.Region = region;
        this.description = description;
    }

    public String getName(){return Name;}
    public String getCountry(){return Country;}
    public String getPostalCode(){return postalCode;}
    public String getRegion(){return Region;}
    public String getDescription(){return description;}

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

    public @NotNull String toString()
    {
        return Name+Country+postalCode+Region+description;
    }

}
