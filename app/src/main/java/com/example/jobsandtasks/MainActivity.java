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
import android.widget.Switch;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
        /*
            THIS IS THE FBLA PROJECT
            THIS IS MEANT TO BE THE NEXT LINKEDIN OR
            WHATEVER CAREER FINDING APP
         */
    employeeDataBase dataBase = new employeeDataBase();
    companyDataBase comDataBase = new companyDataBase();

    employee emp1 = new employee("Daniel", "Austin", "djaus564@gmail.com", "555-141-4141", "meepling10"
            ,"AMERICA", "85086", "Anthem", "Hitman", "Boulder Creek", "High School diploma", true, 20);
    employee emp2 = new employee("Emerson", "Light", "emerson123@gmail.com", "602-363-6420", "meepling10"
            ,"AMERICA", "85086", "Anthem", "Waiter", "Boulder Creek", "none", true, 20);
    employee emp3 = new employee("Christian", "Heal", "cmhea774@dvusd.org", "612-738-9090", "meepling10"
            ,"AMERICA", "85086", "Anthem", "Walmart Assistant", "Boulder Creek", "PH.d in Physics", true, 20);
    employee emp4 = new employee("Noah", "Jameson", "ntjam@useless.com", "733-887-4012", "meepling10"
            ,"AMERICA", "85086", "Anthem", "Priest", "Anthem Prep", "Participation Trophy", false, 20);
    employee emp5 = new employee("Joe", "Sherk", "jda2012@gmail.com", "654-232-7777", "meepling10"
            ,"AMERICA", "83786", "Anthem", "Travel Agent", "Harvard University", "none", false, 20);
    employee emp6 = new employee("Gordan", "Neeas", "dj4us164@gmail.com", "555-141-4141", "meepling10"
            ,"Brazil", "85086", "Anthem", "Fire Fighter", "Boulder Creek", "none", true, 20);
    employee emp7 = new employee("Keith", "Nora", "ktnor564@gmail.com", "555-141-4141", "meepling10"
            ,"AMERICA", "85062", "Tuscan", "Fire Fighter", "Boulder Creek", "none", true, 20);
    employee emp8 = new employee("Seith", "Kira", "sykir564@gmail.com", "555-141-4141", "meepling10"
            ,"AMERICA", "85062", "Tuscan", "Hitman", "Boulder Creek", "Bachlors", true, 20);
    employee emp9 = new employee("seel", "tdanea", "setda@gmail.com", "513-141-5651", "meepling10"
            ,"AMERICA", "85086", "Anthem", "Fire Fighter", "Boulder Creek", "High School diploma", true, 20);
    employee emp10 = new employee("Derek", "Austin", "dtAus564@gmail.com", "555-141-4141", "meepling10"
            ,"AMERICA", "85085", "Anthem", "Police officer", "Boulder Creek", "High School diploma", false, 20);
    employee emp11 = new employee("Amasi", "Reyesh", "djaus909@gmail.com", "555-141-4141", "meepling10"
            ,"AMERICA", "85085", "Tuscan", "Hitman", "Boulder Creek", "High School diploma", true, 20);
    employee emp12 = new employee("Derek", "Austin", "djfic322@gmail.com", "555-141-4141", "meepling10"
            ,"Brazil", "85085", "Flagstaff", "Waiter", "Boulder Creek", "High School diploma", false, 20);
    employee emp13 = new employee("Selec", "teeqn", "sbtee930@gmail.com", "555-141-4141", "meepling10"
            ,"AMERICA", "85085", "Anthem", "Fire Fighter", "Boulder Creek", "High School diploma", false, 20);
    employee emp14 = new employee("Perkic", "yeas", "pbeas921@gmail.com", "555-141-4141", "meepling10"
            ,"AMERICA", "85085", "Anthem", "Funeral Director", "Boulder Creek", "High School diploma", true, 20);
    employee emp15 = new employee("Derek", "Austin", "djuus413@gmail.com", "555-141-4141", "meepling10"
            ,"AMERICA", "85085", "Phoenix", "Hitman", "Boulder Creek", "High School diploma", true, 20);
    employee emp16 = new employee("Perkic", "yeas", "pbeas921@gmail.com", "555-141-4141", "meepling10"
            ,"AMERICA", "85085", "Anthem", "Funeral Director", "Boulder Creek", "High School diploma", true, 20);
    employee emp17 = new employee("Derek", "Austin", "djuus413@gmail.com", "555-141-4141", "meepling10"
            ,"AMERICA", "85085", "Phoenix", "Hitman", "Boulder Creek", "High School diploma", true, 20);

    company com1 = new company("MicroSoft","America","85086","Anthem","Tech Company");
    company com2 = new company("Apple","America","85086","Anthem","Tech Company");
    company com3 = new company("Rio tinto","America","31930","New York","Mining company");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emp1.addSkill("Java");
        emp1.addSkill("Math");
        emp1.addSkill("Comprehension");

        emp1.addContact(emp2);
        emp1.addContact(emp15);

        dataBase.addEmployee(emp1);
        dataBase.addEmployee(emp2);
        dataBase.addEmployee(emp3);
        dataBase.addEmployee(emp4);
        dataBase.addEmployee(emp5);
        dataBase.addEmployee(emp6);
        dataBase.addEmployee(emp7);
        dataBase.addEmployee(emp8);
        dataBase.addEmployee(emp9);
        dataBase.addEmployee(emp10);
        dataBase.addEmployee(emp11);
        dataBase.addEmployee(emp12);
        dataBase.addEmployee(emp13);
        dataBase.addEmployee(emp14);
        dataBase.addEmployee(emp15);
        dataBase.addEmployee(emp16);
        dataBase.addEmployee(emp17);
        // ---------------------  \\
        dataBase.addEmployee(emp16);
        dataBase.addEmployee(emp17);
        dataBase.addEmployee(emp16);
        dataBase.addEmployee(emp17);

        comDataBase.addCompany(com1);
        comDataBase.addCompany(com2);
        comDataBase.addCompany(com3);
        ArrayList<String> job1Skills = new ArrayList<String>();
        job1Skills.add("Java");
        job1Skills.add("Math");

        companyJob microJob1 = new companyJob("Software Developer", "AMERICA","85086", "Anthem", job1Skills,
                false, 18, "Look for developers to make apps", com1);
        companyJob microJob2 = new companyJob("Software Tester", "AMERICA","93844", "Tuscan", job1Skills,
                true, 18, "Look for developers to test apps made by developers",com1);
        com1.addJob(microJob1);
        com1.addJob(microJob2);

        companyJob appleJob1 = new companyJob("Apple Eater", "AMERICA","85086", "Anthem", job1Skills,
                false, 18, "Look for developers to make apps",com2);
        companyJob appleJob2 = new companyJob("Apple developer", "AMERICA","93844", "Tuscan", job1Skills,
                true, 18, "Look for developers to test apps made by developers",com2);
        com2.addJob(appleJob1);
        com2.addJob(appleJob2);

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

    public void makeUsers(int b)
    {
        switch (b)
        {
            case 1 :
                dataBase.addEmployee(emp1);
                dataBase.addEmployee(emp2);
                dataBase.addEmployee(emp3);
                dataBase.addEmployee(emp4);
                dataBase.addEmployee(emp5);
                dataBase.addEmployee(emp6);
                dataBase.addEmployee(emp7);
                dataBase.addEmployee(emp8);
                dataBase.addEmployee(emp9);
                dataBase.addEmployee(emp10);
                dataBase.addEmployee(emp11);
                dataBase.addEmployee(emp12);
                dataBase.addEmployee(emp13);
                dataBase.addEmployee(emp14);
                dataBase.addEmployee(emp15);
            case 2 :
                dataBase.addEmployee(emp1);
                dataBase.addEmployee(emp2);
                dataBase.addEmployee(emp8);
                dataBase.addEmployee(emp9);
                dataBase.addEmployee(emp3);
                dataBase.addEmployee(emp4);
                dataBase.addEmployee(emp5);
                dataBase.addEmployee(emp11);
                dataBase.addEmployee(emp12);
                dataBase.addEmployee(emp13);
                dataBase.addEmployee(emp14);
                dataBase.addEmployee(emp6);
                dataBase.addEmployee(emp7);
                dataBase.addEmployee(emp10);
                dataBase.addEmployee(emp15);
            case 3 :
                dataBase.addEmployee(emp10);
                dataBase.addEmployee(emp13);
                dataBase.addEmployee(emp11);
                dataBase.addEmployee(emp2);
                dataBase.addEmployee(emp3);
                dataBase.addEmployee(emp9);
                dataBase.addEmployee(emp4);
                dataBase.addEmployee(emp12);
                dataBase.addEmployee(emp5);
                dataBase.addEmployee(emp1);
                dataBase.addEmployee(emp14);
                dataBase.addEmployee(emp15);
                dataBase.addEmployee(emp6);
                dataBase.addEmployee(emp7);
                dataBase.addEmployee(emp8);
        }
    }
}