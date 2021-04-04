package com.example.jobsandtasks;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class employeeJobListMaker extends AppCompatActivity
{
    employee curUser;
    int userPosition;
    employeeDataBase dataBase = new employeeDataBase();
    int userSize = dataBase.userBaseSize();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.job_list_layout);

        Intent intent = getIntent();
        int curUserPosition = intent.getIntExtra("currentUser",0);
        userPosition = curUserPosition;
        curUser = dataBase.getEmployeeBylogin(curUserPosition);

        LinearLayout mainLl = findViewById(R.id.homeLinearLayout);

        for (int i = 0; i < curUser.getNumJobs(); i++)
        {


            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(24, 24);
            ll.setLayoutParams(llParams);
            mainLl.addView(ll);


            LinearLayout job = new LinearLayout(this);
            job.setOrientation(LinearLayout.VERTICAL);
            job.setBackgroundColor(Color.LTGRAY);
            LinearLayout.LayoutParams llParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            LinearLayout imgAndName = new LinearLayout(this);
            imgAndName.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams llParams3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            ImageView img = new ImageView(this);
            img.setImageResource(R.drawable.ic_place_holder);
            LinearLayout.LayoutParams imgParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            img.setLayoutParams(imgParams);

            TextView comName = new TextView(this);
            comName.setText(curUser.getJob(i).getCompany().getName());
            comName.setLayoutParams(imgParams);
            comName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);

            imgAndName.addView(comName);
            imgAndName.addView(img);

            job.addView(imgAndName);

            TextView jobTitle = new TextView(this);
            jobTitle.setText(curUser.getJob(i).getJobTitle());
            jobTitle.setLayoutParams(imgParams);
            jobTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

            job.addView(jobTitle);

            TextView jobTitleDesc = new TextView(this);
            jobTitleDesc.setText(curUser.getJob(i).getDescription());
            jobTitleDesc.setLayoutParams(imgParams);
            jobTitleDesc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);

            job.addView(jobTitleDesc);
            mainLl.addView(job);
        }
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
        Intent intent= new Intent(this ,employeePostMaker.class);
        intent.putExtra("currentUser", userPosition);
        startActivity(intent);
    }

    public void viewNotifications(View view)
    {
        Intent intent= new Intent(this ,employeeNotificationMaker.class);
        intent.putExtra("currentUser", userPosition);
        startActivity(intent);
    }

    public void viewJobs(View view)
    {

    }
}
