package com.example.jobsandtasks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        /*
            THIS IS THE FBLA PROJECT
            THIS IS MEANT TO BE THE NEXT LINKEDIN OR
            WHATEVER CAREER FINDING APP
         */
    employeeDataBase dataBase = new employeeDataBase();
  /// USER IS NOT TRANSFERING


    employee emp1 = new employee("Daniel", "Austin", "djaus564@gmail.com", "555-141-4141", "meepling10"
            ,"AMERICA", "85086", "Anthem", "Hitman", "Boulder Creek", "High School diploma", true);
    employee emp2 = new employee("Emerson", "Light", "emerson123@gmail.com", "602-363-6420", "meepling10"
            ,"AMERICA", "85086", "Anthem", "Waiter", "Boulder Creek", "none", true);
    employee emp3 = new employee("Christian", "Heal", "cmhea774@dvusd.org", "612-738-9090", "meepling10"
            ,"AMERICA", "85086", "Anthem", "Walmart Assistant", "Boulder Creek", "PH.d in Physics", true);
    employee emp4 = new employee("Noah", "Jameson", "ntjam@useless.com", "733-887-4012", "meepling10"
            ,"AMERICA", "85086", "Anthem", "Priest", "Anthem Prep", "Participation Trophy", false);
    employee emp5 = new employee("Joe", "Sherk", "jda2012@gmail.com", "654-232-7777", "meepling10"
            ,"AMERICA", "83786", "Anthem", "Travel Agent", "Harvard University", "none", false);
    employee emp6 = new employee("Gordan", "Neeas", "djaus564@gmail.com", "555-141-4141", "meepling10"
            ,"Brazil", "85086", "Anthem", "Hitman", "Boulder Creek", "none", true);
    employee emp7 = new employee("Daniel", "Austin", "djaus564@gmail.com", "555-141-4141", "meepling10"
            ,"AMERICA", "85062", "Tuscan", "Hitman", "Boulder Creek", "none", true);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataBase.addEmployee(emp1);
        //dataBase.addEmployee(emp2);
        //dataBase.addEmployee(emp3);

    }


    public void createAccount(View view)
    {
       // Intent intent = new Intent(this, signupclass.class);
       // startActivity(intent);

        startActivity(new Intent(this, signupclass.class));

    }

    employee curUser;

    public void loginToAccount(View view)
    {
        boolean worked = false;
        EditText editText=findViewById(R.id.editTextTextPersonEmail);
        String attEmail=editText.getText().toString().replaceAll(" ", "");

        EditText editText2=findViewById(R.id.editTextTextPassword);
        String attPassword=editText2.getText().toString().replaceAll(" ", "");

        for(int i = 0; i < dataBase.userBaseSize(); i++)
        {

            if (dataBase.getEmployeeBylogin(i).getEmpEmail().equals(attEmail) && dataBase.getEmployeeBylogin(i).getEmpPassword().equals(attPassword))
            {
//                curUser = dataBase.getEmployeeBylogin(i);
//                worked = true;
//                startActivity(new Intent(this, employeeProfile.class));

                curUser = dataBase.getEmployeeBylogin(i);
                worked = true;
                Intent intent= new Intent(this ,employeeProfile.class);
                intent.putExtra("currentUser", i);
                startActivity(intent);
                break;
            }

        }
        if (worked == false) {
            Toast toast = Toast.makeText(getApplicationContext(), "Incorrect Information", Toast.LENGTH_LONG);
            toast.show();
        }
    }



    public employee getCurUser()
    {
        return curUser;
    }
}