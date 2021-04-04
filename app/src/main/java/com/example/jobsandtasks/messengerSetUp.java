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

    employee orgEmp = dataBase.getEmployeeBylogin(orgUser);

    ArrayList<String> messages = new ArrayList<String>();

    int j;
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

        int getContact = orgEmp.getContactByPos(viewed);
         j = getContact;
        LinearLayout mainLl = findViewById(R.id.homeLinearLayout);

        for (int i = 0; i < orgEmp.getMessages(getContact).size(); i++)
        {
            ArrayList<String> messages = orgEmp.getMessages(getContact);
            ArrayList<Boolean> messageOrder = orgEmp.getMessageOrder(getContact);
            LinearLayout ll = new LinearLayout(this);

            if (messageOrder.get(i) == true)
            {
                EditText edit = findViewById(R.id.messageBox);
                LinearLayout.LayoutParams llParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                TextView message = new TextView(this);
                message.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
                message.setText("  " + messages.get(i));
                message.setLayoutParams(llParams2);
                message.setBackgroundColor(Color.rgb(113,166, 175));
                message.setBackgroundResource(R.drawable.rounded_corner_view);
                mainLl.addView(message);


                ll.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(24, 16);
                ll.setLayoutParams(llParams);
            }
            else
            {
                EditText edit = findViewById(R.id.messageBox);
                LinearLayout.LayoutParams llParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

                TextView message = new TextView(this);
                message.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
                message.setText("  " + messages.get(i));
                message.setLayoutParams(llParams2);
                message.setBackgroundColor(Color.rgb(113,166, 175));
                message.setBackgroundResource(R.drawable.rounded_other_message);
                mainLl.addView(message);


                ll.setOrientation(LinearLayout.HORIZONTAL);
                LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(24, 16);
                ll.setLayoutParams(llParams);
            }



            mainLl.addView(ll);
        }

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

        orgEmp.addMessage("  " + edit.getText(), j, true);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(24, 16);
        ll.setLayoutParams(llParams);
        mainLl.addView(ll);

        reply("" + edit.getText());

        edit.setText("");
    }

    public void reply(String message)
    {
        message = message.trim().toLowerCase();
        if (message.contains("hello"))
        {
            LinearLayout mainLl = findViewById(R.id.homeLinearLayout);

            EditText edit = findViewById(R.id.messageBox);
            LinearLayout.LayoutParams llParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            TextView message1 = new TextView(this);
            message1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
            message1.setText("  Hello! How are you?");
            message1.setLayoutParams(llParams2);
            message1.setBackgroundColor(Color.rgb(113,166, 175));
            message1.setBackgroundResource(R.drawable.rounded_other_message);
            mainLl.addView(message1);

            orgEmp.addMessage("  " + edit.getText(), j, false);

            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(24, 16);
            ll.setLayoutParams(llParams);
            mainLl.addView(ll);
        }
        else if (message.contains("how"))
        {
            LinearLayout mainLl = findViewById(R.id.homeLinearLayout);

            EditText edit = findViewById(R.id.messageBox);
            LinearLayout.LayoutParams llParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            TextView message1 = new TextView(this);
            message1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
            message1.setText("  I'm doing well, how about you");
            message1.setLayoutParams(llParams2);
            message1.setBackgroundColor(Color.rgb(113,166, 175));
            message1.setBackgroundResource(R.drawable.rounded_other_message);
            mainLl.addView(message1);

            orgEmp.addMessage("  " + edit.getText(), j, false);

            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(24, 16);
            ll.setLayoutParams(llParams);
            mainLl.addView(ll);
        }
        else if (message.contains("job"))
        {
            LinearLayout mainLl = findViewById(R.id.homeLinearLayout);

            EditText edit = findViewById(R.id.messageBox);
            LinearLayout.LayoutParams llParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            TextView message1 = new TextView(this);
            message1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22);
            message1.setText(" My job is working as a " + viewed.getemprevJob());
            message1.setLayoutParams(llParams2);
            message1.setBackgroundColor(Color.rgb(113,166, 175));
            message1.setBackgroundResource(R.drawable.rounded_other_message);
            mainLl.addView(message1);

            orgEmp.addMessage("  " + edit.getText(), j, false);

            LinearLayout ll = new LinearLayout(this);
            ll.setOrientation(LinearLayout.HORIZONTAL);
            LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(24, 16);
            ll.setLayoutParams(llParams);
            mainLl.addView(ll);
        }

    }

    public void viewHome(View view)
    {
        Intent intent= new Intent(this ,employeeHomeMaker.class);
        intent.putExtra("currentUser", orgUser);
        startActivity(intent);
    }

    public void viewNetwork(View view)
    {
        Intent intent= new Intent(this ,employeeMakeNetwork.class);
        intent.putExtra("currentUser", orgUser);
        startActivity(intent);
    }

    public void viewPost(View view)
    {
        Intent intent= new Intent(this ,employeePostMaker.class);
        intent.putExtra("currentUser", orgUser);
        startActivity(intent);
    }

    public void viewNotifications(View view)
    {
        Intent intent= new Intent(this ,employeeNotificationMaker.class);
        intent.putExtra("currentUser", orgUser);
        startActivity(intent);
    }

    public void viewJobs(View view)
    {
        Intent intent= new Intent(this ,employeeJobListMaker.class);
        intent.putExtra("currentUser", orgUser);
        startActivity(intent);
    }


}
