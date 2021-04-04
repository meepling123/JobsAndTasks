package com.example.jobsandtasks;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
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
        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
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

        return super.onOptionsItemSelected(item);
    }
}
