package com.example.jobsandtasks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class employeeNotificationMaker extends AppCompatActivity
{
    int orgUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notification_layout);

        Intent intent = getIntent();
        int originalUser = intent.getIntExtra("curUser", 0);
        orgUser = originalUser;
    }

    public void viewHome(View view)
    {
        Intent intent= new Intent(this ,employeeHomeMaker.class);
        intent.putExtra("currentUser", orgUser);
        startActivity(intent);
    }

    public void viewNetwork(View view)
    {
        Intent intent= new Intent(this ,employeeMakeNetwork.class);
        intent.putExtra("currentUser", orgUser);
        startActivity(intent);
    }

    public void viewPost(View view)
    {
        Intent intent= new Intent(this ,employeePostMaker.class);
        intent.putExtra("currentUser", orgUser);
        startActivity(intent);
    }

    public void viewNotifications(View view)
    {

    }

    public void viewJobs(View view)
    {
        Intent intent= new Intent(this ,employeeJobListMaker.class);
        intent.putExtra("currentUser", orgUser);
        startActivity(intent);
    }
}
