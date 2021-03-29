package com.example.jobsandtasks;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

public class employeeHomeMaker extends AppCompatActivity
{
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_home_layout);

        LinearLayout ll = new LinearLayout(this);
        RelativeLayout prof = new RelativeLayout(this);


    }
}
