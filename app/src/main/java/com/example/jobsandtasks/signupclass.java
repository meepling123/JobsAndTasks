package com.example.jobsandtasks;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class signupclass extends AppCompatActivity
{
    employeeDataBase dataBase = new employeeDataBase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void onCheckboxClicked(View view) {
        LinearLayout l = findViewById(R.id.studentLinear);
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch (view.getId()) {
            case R.id.stuCheckBox:
                if (checked)
                {
                    l.setVisibility(View.VISIBLE);

//                    Toast toast = Toast.makeText(getApplicationContext(), "LE BOX IS CHECKED", Toast.LENGTH_LONG);
//                    toast.show();
                } else if (checked == false)
                {

                    l.setVisibility(View.INVISIBLE);
//                    Toast toast = Toast.makeText(getApplicationContext(), "The box is not checked", Toast.LENGTH_LONG);
//                    toast.show();
                }
             break;
        }
    }



    public void createAccount(View view)
    {
        String fName, lName, empEmail, empPhone, empPassword, empCountry, empPostal, empArea, empprevJob, school, degree;

        EditText editText=findViewById(R.id.firstNameEnt);
        fName=editText.getText().toString().replaceAll(" ", "");

        EditText editText2=findViewById(R.id.lastNameEnt);
        lName=editText2.getText().toString().replaceAll(" ", "");

        EditText editText3=findViewById(R.id.emailEnt);
        empEmail=editText3.getText().toString().replaceAll(" ", "");

        EditText editText4=findViewById(R.id.phoneEnt);
        empPhone=editText4.getText().toString().replaceAll(" ", "");

        EditText editText5=findViewById(R.id.passwordEnt);
        empPassword=editText5.getText().toString().replaceAll(" ", "");

        EditText editText6=findViewById(R.id.countryEnt);
        empCountry=editText6.getText().toString().replaceAll(" ", "");

        EditText editText7=findViewById(R.id.postalCodeEnt);
        empPostal=editText7.getText().toString().replaceAll(" ", "");

        EditText editText8=findViewById(R.id.locationEnt);
        empArea=editText8.getText().toString().replaceAll(" ", "");

        EditText editText9=findViewById(R.id.prevJobEnt);
        empprevJob=editText9.getText().toString().replaceAll(" ", "");

        EditText editText10=findViewById(R.id.schoolEnt);
        school=editText10.getText().toString().replaceAll(" ", "");

        EditText editText11=findViewById(R.id.degreeEnt);
        degree=editText11.getText().toString().replaceAll(" ", "");

        CheckBox StudentCheck = findViewById(R.id.stuCheckBox);
        boolean isStudent = StudentCheck.isChecked();

        //recent job is not required if they are a student
        //String fName, lName, empEmail, empPhone, empPassword, empCountry, empPostal, empArea, empprevJob, school, degree;
        if (fName != "" && lName != "" && empEmail != "" && empPhone != "" && empPassword != "" && empCountry != "" && empPostal != "" &&
                                    empArea != "" && empprevJob != "" && school != "" && degree != "")
        {
            employee newEmp = new employee(fName, lName, empEmail, empPhone, empPassword, empCountry, empPostal, empArea, empprevJob, school, degree, isStudent);
            dataBase.addEmployee(newEmp);
            startActivity(new Intent(this, MainActivity.class));

        }
        else if (fName != "" && lName != "" && empEmail != "" && empPhone != "" && empPassword != "" && empCountry != "" && empPostal != "" &&
                empArea != "" && isStudent == true && school != "" && degree != "")
        {
            employee newEmp = new employee(fName, lName, empEmail, empPhone, empPassword, empCountry, empPostal, empArea, "No previous work experience", school, degree, isStudent);
            dataBase.addEmployee(newEmp);
            startActivity(new Intent(this, MainActivity.class));
        }

        Toast toast = Toast.makeText(getApplicationContext(), "Please Enter all required fields", Toast.LENGTH_LONG);
        toast.show();
    }
}
