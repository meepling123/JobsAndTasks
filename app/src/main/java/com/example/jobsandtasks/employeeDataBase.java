package com.example.jobsandtasks;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import java.util.Random;

import androidx.annotation.Nullable;

import java.util.*;

public class employeeDataBase
{
        public static ArrayList<employee> employees = new ArrayList<employee>();


        SQLiteDatabase db;

        @Nullable
        public static employee getEmployeeByEmail(String email)
        {
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

        public ArrayList<employee> getList() {return employees;}

        public void addEmployee(employee emp) { employees.add(emp); }
        public void removeEmployee(employee emp) {employees.remove(emp);}
}
