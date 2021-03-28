package com.example.jobsandtasks;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class employeeProfile extends AppCompatActivity
{
    employee curEmp = new employee("Emerson", "Love", "superStraight@straight.com", "555-141-4141", "meepling10"
            ,"Syria", "85086", "Anthem", "Hitman", "Boulder Creek", "none", true);

    /*
     *      THIS WILL ADD THE EMPLOYEES INFO ONTO THERE PROFILE
     *      IMPLEMENT THIS ON MONDAY OR I WILL HANG YOU
     */
    int curUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_prof);

        Intent intent = getIntent();
        int curUserPosition = intent.getIntExtra("currentUser",0);
        employeeDataBase dataBase = new employeeDataBase();
        curEmp = dataBase.getEmployeeBylogin(curUserPosition);

        curUser = curUserPosition;

        TextView empName = findViewById(R.id.employeeNameLabel);
        empName.setText(curEmp.getFName() + " " + curEmp.getlName());

        TextView EducationPlace = findViewById(R.id.educationLabel);
        EducationPlace.setText(curEmp.getSchool());

        TextView location = findViewById(R.id.locationText);
        location.setText(curEmp.getEmpCountry() + " in " + curEmp.getEmpLocalArea() + " in Postal Code " + curEmp.getEmpPostal());

        TextView experience = findViewById(R.id.experienceLabel);
        experience.setText("Went to " + curEmp.getSchool() + " and has recieved " + curEmp.getDegree() + " Previous experience:  " + curEmp.getemprevJob());

        TextView Contact = findViewById(R.id.contactLabel);
        Contact.setText("Email: " + curEmp.getEmpEmail() + "\n" + "Phone: " + curEmp.getEmpPhone());

        TextView bio = findViewById(R.id.bioView);
        bio.setText(curEmp.getBio());

    }

    public void editAccount(View view)
    {
        Intent intent= new Intent(this ,employeeEdit.class);
        intent.putExtra("currentUser", curUser);
        startActivity(intent);
    }
}
