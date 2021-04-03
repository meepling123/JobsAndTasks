package com.example.jobsandtasks;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class employeeMakeNetwork extends AppCompatActivity
{
    int userPosition;
    employee curUser;
    employeeDataBase dataBase = new employeeDataBase();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        Intent intent = getIntent();
        int curUserPosition = intent.getIntExtra("currentUser", 0);
        userPosition = curUserPosition;
        curUser = dataBase.getEmployeeBylogin(curUserPosition);



    }

    public View makeContact(employee e)
    {
        LinearLayout ll = new LinearLayout(this);

        ll.setOrientation(LinearLayout.HORIZONTAL);

        ll.setBackgroundColor(Color.LTGRAY);
        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 24);
        ll.setLayoutParams(llParams);

        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.ic_person_place_holder);
        LinearLayout.LayoutParams imgParams = new LinearLayout.LayoutParams(24, 24);

        img.setLayoutParams(imgParams);

        ll.addView(img);

        TextView name = new TextView(this);
        name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        name.setText(e.getFName() + " " + e.getlName());

        LinearLayout.LayoutParams llParams2 = new LinearLayout.LayoutParams(36, 24);
        Button button = new Button(this);
        button.setLayoutParams(llParams2);

        button.setBackgroundColor(Color.DKGRAY);
        button.setTextColor(Color.WHITE);

        button.setText("Message");
        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

            }
        });

        return ll;
    }

    public void viewHome(View view)
    {
        Intent intent= new Intent(this ,employeeHomeMaker.class);
        intent.putExtra("currentUser", userPosition);
        startActivity(intent);
    }

    public void viewNetwork(View view)
    {

    }

    public void viewPost(View view)
    {

    }

    public void viewNotifications(View view) {
    }

    public void viewJobs(View view) {
    }
}
