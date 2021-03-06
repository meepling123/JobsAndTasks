package com.example.jobsandtasks;

import android.annotation.SuppressLint;
import android.content.Context;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.media.Image;

import android.os.Bundle;
import android.os.Parcelable;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.widget.*;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class employeeHomeMaker extends AppCompatActivity {
    private int home_prof_view;

    employee curUser;
    int userPosition;
    employeeDataBase dataBase = new employeeDataBase();
    int userSize = dataBase.userBaseSize();

    companyDataBase companyDataBase = new companyDataBase();

    //rating 5 - 0    5 is shown first 4 later on until 1, 0 is not shown
    int[] rating = new int[dataBase.userBaseSize()];
    int[] cRating = new int[companyDataBase.userBaseSize()];

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_home_layout);

        Intent intent = getIntent();
        int curUserPosition = intent.getIntExtra("currentUser",0);
        userPosition = curUserPosition;
        curUser = dataBase.getEmployeeBylogin(curUserPosition);

        LinearLayout mainLl = findViewById(R.id.homeLinearLayout);
        //Determine Priority of which employees is viewed
        for (int i = 0; i < dataBase.userBaseSize(); i++)
        {
            if (curUser.getEmpCountry().equals(dataBase.getEmployeeBylogin(i).getEmpCountry())  &&
                    curUser.getEmpLocalArea().toLowerCase().equals(dataBase.getEmployeeBylogin(i).getEmpLocalArea().toLowerCase()) &&
                    (curUser.getEmpPostal().equals(dataBase.getEmployeeBylogin(i).getEmpPostal()) &&
                        curUser.getSchool().equals(dataBase.getEmployeeBylogin(i).getSchool()))
            )
            {
                rating[i] = 5;
            }

            if (curUser.getEmpCountry().equals(dataBase.getEmployeeBylogin(i).getEmpCountry())  &&
                    curUser.getEmpLocalArea().equals(dataBase.getEmployeeBylogin(i).getEmpLocalArea()) &&
                    (curUser.getEmpPostal().equals(dataBase.getEmployeeBylogin(i).getEmpPostal()) &&
                            curUser.getlName().equals(dataBase.getEmployeeBylogin(i).getlName()))
            )
            {
                rating[i] = 5;
            }

            if (curUser.getEmpCountry().equals(dataBase.getEmployeeBylogin(i).getEmpCountry())  &&
                    curUser.getEmpLocalArea().equals(dataBase.getEmployeeBylogin(i).getEmpLocalArea())
                    && curUser.getEmpPostal().equals(dataBase.getEmployeeBylogin(i).getEmpPostal()) && rating[i] != 5 && curUser.getEmpPostal().equals(dataBase.getEmployeeBylogin(i).getEmpPostal())
            )
            {
                rating[i] = 4;
            }

            if (curUser.getEmpCountry().equals(dataBase.getEmployeeBylogin(i).getEmpCountry())  &&
                    curUser.getEmpLocalArea().equals(dataBase.getEmployeeBylogin(i).getEmpLocalArea())
                    && rating[i] != 5 && rating[i] != 4
            )
            {
                rating[i] = 3;
            }

            if (curUser.getEmpCountry().equals(dataBase.getEmployeeBylogin(i).getEmpCountry())  &&
                    curUser.getemprevJob().equals(dataBase.getEmployeeBylogin(i).getemprevJob())
                    && rating[i] != 4 && rating[i] != 5  && rating[i] != 3
            )
            {
                rating[i] = 2;
            }

            if (curUser.getEmpCountry().equals(dataBase.getEmployeeBylogin(i).getEmpCountry())
             && rating[i] != 4 && rating[i] != 5  && rating[i] != 3 && rating[i] != 2)
            {
                rating[i] = 1;
            }

            if ((curUser.getEmpCountry().equals(dataBase.getEmployeeBylogin(i).getEmpCountry()) == false))
            {
                rating[i] = 0;
            }

            if (curUser == dataBase.getEmployeeBylogin(i))
            {
                rating[i] = 0;
            }

        }

        //Determines which company ads will be viewed
        for (int i = 0; i < companyDataBase.userBaseSize(); i++)
        {

            if (companyDataBase.getCompany(i).getNumJobs() < i)
            {

            }
            else {
                if (companyDataBase.getCompany(i).getNumJobs() > 0) {
                    if (curUser.getEmpCountry().equals(companyDataBase.getCompany(i).getCountry()) &&
                            curUser.getEmpLocalArea().equals(companyDataBase.getCompany(i).getJob(i).getRegion()) &&
                            curUser.getEmpPostal().equals(companyDataBase.getCompany(i).getJob(i).getPostalCode())) {
                        cRating[i] = 5;
                    }
                    if (curUser.getEmpCountry().equals(companyDataBase.getCompany(i).getCountry()) &&
                            companyDataBase.getCompany(i).getJob(i).isOnline == true && cRating[i] != 5) {
                        cRating[i] = 4;
                    }
                    if (curUser.getEmpCountry().equals(companyDataBase.getCompany(i).getCountry()) == false) {
                        cRating[i] = 0;
                    }
                }
            }
        }

        int total = 0;
        ArrayList<companyJob> usedJobs = new ArrayList<companyJob>();
        ArrayList<Integer> positions = new ArrayList<Integer>();

        for (int j = 5; j > 0; j--)
        {
            for (int k = 0; k < dataBase.userBaseSize(); k++)
            {
                int size = dataBase.userBaseSize();
                if (rating[k] == j)
                {
                    total++;
                    mainLl.addView(makeEmploy(dataBase.getEmployeeBylogin(k), k));

                    //This is just a divider
                    LinearLayout ll = new LinearLayout(this);
                    ll.setOrientation(LinearLayout.HORIZONTAL);
                    LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(24, 24);
                    ll.setLayoutParams(llParams);
                    mainLl.addView(ll);


                }

                if (total % 5 == 0 &&  positions.contains(total) == false && total != 0) // positions.contains(total) == false &&
                {
                    positions.add(total);
                    boolean didAdd = false;
                    for (int i = 0; i < companyDataBase.userBaseSize(); i++)
                    {
                        for (int q = 0; q < companyDataBase.getCompany(i).getNumJobs(); q++)
                        {
                            if (usedJobs.contains(companyDataBase.getCompany(i).getSpecificJob(curUser,q)))
                            {

                            }
                            else {
                                mainLl.addView(makeCompany(companyDataBase.getCompany(i), companyDataBase.getCompany(i).getSpecificJob(curUser, q)));
                                usedJobs.add(companyDataBase.getCompany(i).getSpecificJob(curUser, q));
                                didAdd = true;

                                LinearLayout ll = new LinearLayout(this);
                                ll.setOrientation(LinearLayout.HORIZONTAL);
                                LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(24, 24);
                                ll.setLayoutParams(llParams);
                                mainLl.addView(ll);

                                break;
                            }

                        }
                        if (didAdd){break;}
                    }
                }
            }
        }

    }

    public View makeEmploy(employee e, int position)
    {
        //int[] sentInfo = {position, curUser};
        int pos = position;
        if (e == null)
        {
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(24, 24);
            ll.setLayoutParams(llParams);
            return ll;
        }

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);

        ll.setBackgroundColor(Color.LTGRAY);
        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ll.setLayoutParams(llParams);


        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.ic_person_place_holder);
        LinearLayout.LayoutParams imgParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        img.setLayoutParams(imgParams);

        ll.addView(img);

        LinearLayout nameLocLL = new LinearLayout(this);
        nameLocLL.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams llParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        llParams2.setMargins(8,12,8,8);
        nameLocLL.setLayoutParams(llParams2);

        TextView name = new TextView(this);
        name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        name.setText(e.getFName() + " " + e.getlName());

        TextView loc = new TextView(this);
        loc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        loc.setText(e.getEmpCountry() + ", " + e.getEmpLocalArea());

        nameLocLL.addView(name);
        nameLocLL.addView(loc);

        ll.addView(nameLocLL);

        Button button = new Button(this);
        button.setLayoutParams(llParams2);

        button.setBackgroundColor(Color.DKGRAY);
        button.setTextColor(Color.WHITE);
        button.setText("View Profile");
        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                goToProf(pos);

            }
        });

        ll.addView(button);

        ll.setPadding(16,8,8,8);

        return ll;
    }
    public void goToProf(int pos)
    {
        Intent intent = new Intent(this, employeeOutsideView.class);
        intent.putExtra("viewedUser", pos);
        intent.putExtra("curUser", userPosition);
        startActivity(intent);
    }

    public View makeCompany(company c, companyJob job)
    {
        if (c == null || job == null)
        {
            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(24, 24);
            ll.setLayoutParams(llParams);
            return ll;
        }
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.setBackgroundColor(Color.rgb(124,140,227));


        LinearLayout nameLocLL = new LinearLayout(this);
        nameLocLL.setOrientation(LinearLayout.HORIZONTAL);

        nameLocLL.setBackgroundColor(Color.GRAY);
        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT - 16, 112);
        nameLocLL.setLayoutParams(llParams);

        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.ic_place_holder);
        LinearLayout.LayoutParams imgParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        img.setLayoutParams(imgParams);
        nameLocLL.addView(img);

        LinearLayout.LayoutParams llParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        llParams2.setMargins(8,12,8,8);
        nameLocLL.setLayoutParams(llParams2);

        TextView name = new TextView(this);
        name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        name.setText(c.getName());

        TextView loc = new TextView(this);
        loc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        loc.setText(c.getRegion());

        nameLocLL.addView(name);
        nameLocLL.addView(loc);

        ll.addView(nameLocLL);

        LinearLayout jobLinearLayout = new LinearLayout(this);
        jobLinearLayout.setOrientation(LinearLayout.HORIZONTAL);

        TextView jobName = new TextView(this);
        jobName.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        jobName.setText(job.getJobTitle());
        ll.addView(jobName);

        TextView jobDesc = new TextView(this);
        jobDesc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        jobDesc.setText(job.getDescription());
        ll.addView(jobDesc);

        Button button = new Button(this);
        button.setLayoutParams(llParams2);

        button.setBackgroundColor(Color.DKGRAY);
        button.setTextColor(Color.WHITE);
        button.setText("Add job to list");
        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                addJob(c, job);
                button.setText("Job added");
            }
        });

        ll.addView(button);

        return ll;
    }

    public void addJob(company c, companyJob job)
    {
        curUser.addJob(job);
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

    public void viewHome(View view)
    {

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
        Intent intent= new Intent(this ,employeeJobListMaker.class);
        intent.putExtra("currentUser", userPosition);
        startActivity(intent);
    }
}
