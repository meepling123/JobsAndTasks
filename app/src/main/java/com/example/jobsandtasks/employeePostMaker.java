package com.example.jobsandtasks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class employeePostMaker extends AppCompatActivity
{
    employee curUser;
    int userPosition;
    employeeDataBase dataBase = new employeeDataBase();
    int userSize = dataBase.userBaseSize();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_layout);

        Intent intent = getIntent();
        int curUserPosition = intent.getIntExtra("currentUser",0);
        userPosition = curUserPosition;
        curUser = dataBase.getEmployeeBylogin(curUserPosition);

    }

    public void viewHome(View view)
    {
        Intent intent= new Intent(this ,employeeHomeMaker.class);
        intent.putExtra("currentUser", userPosition);
        startActivity(intent);
    }

    public void viewNetwork(View view)
    {
        Intent intent= new Intent(this ,employeeMakeNetwork.class);
        intent.putExtra("currentUser", userPosition);
        startActivity(intent);
    }

    public void viewPost(View view)
    {

    }

    public void viewNotifications(View view)
    {
        Intent intent= new Intent(this ,employeeNotificationMaker.class);
        intent.putExtra("currentUser", userPosition);
        startActivity(intent);
    }

    public void viewJobs(View view)
    {
        Intent intent= new Intent(this ,employeeJobListMaker.class);
        intent.putExtra("currentUser", userPosition);
        startActivity(intent);
    }
}
