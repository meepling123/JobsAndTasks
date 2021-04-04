package com.example.jobsandtasks;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class messengerSetUp extends AppCompatActivity
{
    int orgUser;
    employee viewed;
    employeeDataBase dataBase = new employeeDataBase();

    ArrayList<String> messages = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messenger);



        Intent intent = getIntent();
        int curUserPosition = intent.getIntExtra("viewedUser", 0);
        viewed = dataBase.getEmployeeBylogin(curUserPosition);

        int originalUser = intent.getIntExtra("curUser", 0);
        orgUser = originalUser;

        TextView nameText = findViewById(R.id.homeViewText);
        nameText.setText(viewed.getFName() + " " + viewed.getlName());

    }

    public void sendMessage(View view)
    {
        LinearLayout mainLl = findViewById(R.id.homeLinearLayout);

        EditText edit = findViewById(R.id.messageBox);
        LinearLayout.LayoutParams llParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        TextView message = new TextView(this);
        message.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
        message.setText("  " + edit.getText());
        message.setLayoutParams(llParams2);
        message.setBackgroundColor(Color.rgb(113,166, 175));
        message.setBackgroundResource(R.drawable.rounded_corner_view);
        mainLl.addView(message);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(24, 16);
        ll.setLayoutParams(llParams);
        mainLl.addView(ll);
    }

    public void viewHome(View view)
    {
        Intent intent= new Intent(this ,employeeHomeMaker.class);
        intent.putExtra("currentUser", orgUser);
        startActivity(intent);
    }

    public void viewNetwork(View view)
    {

    }

    public void viewPost(View view)
    {

    }

    public void viewNotifications(View view)
    {

    }

    public void viewJobs(View view)
    {

    }


}
