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

        LinearLayout mainLl = findViewById(R.id.homeLinearLayout);

        Intent intent = getIntent();
        int curUserPosition = intent.getIntExtra("currentUser", 0);
        userPosition = curUserPosition;
        curUser = dataBase.getEmployeeBylogin(curUserPosition);

        for (int i = 0; i < curUser.contacts.size(); i++)
        {

            mainLl.addView(makeContact(curUser.getContactByLoop(i),dataBase.getEmployeePosByEmail(curUser.getContactByLoop(i).empEmail)));

            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(24, 16);
            ll.setLayoutParams(llParams);
            mainLl.addView(ll);
        }

    }

    public View makeContact(employee e, int i)
    {
        int id = i;
        LinearLayout ll = new LinearLayout(this);

        ll.setOrientation(LinearLayout.HORIZONTAL);

        ll.setBackgroundColor(Color.LTGRAY);
        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT , ViewGroup.LayoutParams.WRAP_CONTENT );
        ll.setLayoutParams(llParams);

        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.ic_person_place_holder);
        LinearLayout.LayoutParams imgParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        img.setLayoutParams(imgParams);

        ll.addView(img);

        TextView name = new TextView(this);
        name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
        name.setText(e.getFName() + " " + e.getlName());

        LinearLayout.LayoutParams llParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        llParams2.setMargins(8,12,8,8);
        Button button = new Button(this);
        button.setLayoutParams(llParams2);

        ll.addView(name);

        button.setBackgroundColor(Color.DKGRAY);
        button.setTextColor(Color.WHITE);
        button.setText("Message");
        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 24);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                viewMessages(id);
            }
        });
        ll.addView(button);
        ll.setPadding(16,8,8,8);

        return ll;
    }

    public void viewMessages(int pos)
    {

            Intent intent = new Intent(this, messengerSetUp.class);
            intent.putExtra("viewedUser", pos);
            intent.putExtra("curUser", userPosition);
            startActivity(intent);

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
