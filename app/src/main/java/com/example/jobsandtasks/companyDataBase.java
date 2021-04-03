package com.example.jobsandtasks;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.util.*;

public class companyDataBase
{

        public static ArrayList<company> companies = new ArrayList<company>();


        SQLiteDatabase db;

        @Nullable
        public static company getEmployeeByEmail(String name)
        {
            for(int i = 0; i < companies.size(); i++)
            {
                if (companies.get(i).getName().equals(name))
                {
                    return companies.get(i);
                }
            }
            return null;
        }

        public company getCompany(int i)
        {
            return companies.get(i);
        }

        public int userBaseSize()
        {
            return companies.size();
        }

        public void addCompany(company emp) { companies.add(emp); }
        public void removeCompany(company emp) {companies.remove(emp);}

}
