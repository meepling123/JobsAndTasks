package com.example.jobsandtasks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class employeeOutsideView extends AppCompatActivity
{
    employee curEmp = new employee("Emerson", "Love", "superStraight@straight.com", "555-141-4141", "meepling10"
            ,"Syria", "85086", "Anthem", "Hitman", "Boulder Creek", "none", true, 20);

    /*
     *      THIS WILL ADD THE EMPLOYEES INFO ONTO THERE PROFILE
     */
    int curUser;
    int orgUser;
    employeeDataBase dataBase = new employeeDataBase();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_prof);


        Intent intent = getIntent();
        int curUserPosition = intent.getIntExtra("viewedUser",1);

        int originalUser = intent.getIntExtra("curUser", 0);
        orgUser = originalUser;


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

    public void goHome(View view)
    {
        Intent intent= new Intent(this ,employeeHomeMaker.class);
        intent.putExtra("currentUser", orgUser);
        startActivity(intent);
    }

    public void addContact(View view)
    {
        dataBase.getEmployeeBylogin(orgUser).addContact(dataBase.getEmployeeBylogin(curUser).getEmpEmail());
    }
}
