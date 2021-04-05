package com.example.jobsandtasks;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class employeePostMaker extends AppCompatActivity
{
    employee curUser;
    int userPosition;
    employeeDataBase dataBase = new employeeDataBase();
    int userSize = dataBase.userBaseSize();

//    LinearLayout mainLl = findViewById(R.id.homeLinearLayout);

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.post_layout);

        Intent intent = getIntent();
        int curUserPosition = intent.getIntExtra("currentUser",0);
        userPosition = curUserPosition;
        curUser = dataBase.getEmployeeBylogin(curUserPosition);

//        LinearLayout job = new LinearLayout(this);
//        job.setOrientation(LinearLayout.VERTICAL);
//        job.setBackgroundColor(Color.LTGRAY);
//        LinearLayout.LayoutParams llParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//        LinearLayout imgAndName = new LinearLayout(this);
//        imgAndName.setOrientation(LinearLayout.HORIZONTAL);
//        LinearLayout.LayoutParams llParams3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//
//        ImageView img = new ImageView(this);
//        img.setImageResource(R.drawable.ic_place_holder);
//        LinearLayout.LayoutParams imgParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        img.setLayoutParams(imgParams);
//
//        TextView comName = new TextView(this);
//        comName.setText(dataBase.getEmployeeBylogin(3).getFName() + " " +dataBase.getEmployeeBylogin(3).getlName());
//        comName.setLayoutParams(imgParams);
//        comName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 36);
//
//        imgAndName.addView(comName);
//        imgAndName.addView(img);
//
//        job.addView(imgAndName);
//
//        TextView jobTitle = new TextView(this);
//        jobTitle.setText("Just got a Job at MicroSoft, going to begin working there tommorow");
//        jobTitle.setLayoutParams(imgParams);
//        jobTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
//
//        job.addView(jobTitle);
//
//        TextView comEmail = new TextView(this);
//        comEmail.setText(dataBase.getEmployeeBylogin(3).getEmpEmail());
//        comEmail.setLayoutParams(imgParams);
//        comEmail.setTextSize(TypedValue.COMPLEX_UNIT_SP, 18);
//
//        job.addView(comEmail);
//
//        mainLl.addView(job);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_profile) {
            Intent intent= new Intent(this ,employeeProfile.class);
            intent.putExtra("currentUser", userPosition);
            startActivity(intent);
            return true;

        }

        if (id == R.id.action_signout)
        {
            startActivity(new Intent(this, MainActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
