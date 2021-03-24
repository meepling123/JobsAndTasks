package com.example.jobsandtasks;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.Nullable;

import java.util.*;

public class employeeDataBase
{
        public static ArrayList<employee> employees = new ArrayList<employee>();

        //String fName, lName, empEmail, empPhone, empPassword, empCountry, empPostal, empArea, empprevJob, school, degree;

        static employee emp3 = new employee("Gay", "Bowser", "epic@gmail.com", "555-141-4141", "meepling"
                ,"Brazil", "85086", "Anthem", "Hitman", "Boulder Creek", "none", true);


        SQLiteDatabase db;

        @Nullable
        public static employee getEmployeeByEmail(String email)
        {
                employees.add(emp3);
                for(int i = 0; i < employees.size(); i++)
                {
                        if (employees.get(i).getEmpEmail().equals(email))
                        {
                                return employees.get(i);
                        }
                }
                return null;
        }

        public employee getEmployeeBylogin(int i)
        {
                return employees.get(i);
        }

        public int userBaseSize()
        {
                return employees.size();
        }

        public void addEmployee(employee emp) { employees.add(emp); }
        public void removeEmployee(employee emp) {employees.remove(emp);}
}
