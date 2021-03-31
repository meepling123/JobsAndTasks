package com.example.jobsandtasks;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.widget.*;

public class employeeHomeMaker extends AppCompatActivity
{
    private int home_prof_view;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_home_layout);

        TextView textView = new TextView(this);
        textView.setId(Integer.parseInt("@+id/KillMe"));

        TextView textView2 = new TextView(this);


        employeeDataBase dataBase = new employeeDataBase();
        homeEmployeeShowClass person = new homeEmployeeShowClass(dataBase.getEmployeeBylogin(2));

        LinearLayout ll = (LinearLayout) findViewById(R.id.homeLinearLayout);
        //ConstraintLayout empHomeProf = new ConstraintLayout(this);

        LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.home_prof_view, null);
        ll.addView(view);

//        TextView textView1 = new TextView(this);
//        textView1.setLayoutParams(new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.WRAP_CONTENT,
//                ConstraintLayout.LayoutParams.WRAP_CONTENT));
//        textView1.setText("programmatically created TextView1");
//        textView1.setBackgroundColor(0xff66ff66); // hex color 0xAARRGGBB
//        textView1.setPadding(20, 20, 20, 20);// in pixels (left, top, right, bottom)

    }

    public void createHome(LinearLayout ll)
    {

        ConstraintLayout.LayoutParams mainLayout = new ConstraintLayout.LayoutParams(180, 160);
        ConstraintSet set = new ConstraintSet();

        set.clone((ConstraintLayout) findViewById(R.id.employLayout));

        set.applyTo(findViewById(R.id.employLayout));

        TextView textView = new TextView(this);
        int textViewId = 100;
        textView.setId(textViewId);

        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(80, 76);

        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.ic_place_holder);

        layoutParams.topToTop = 8;
        layoutParams.leftToLeft = 8;
        layoutParams.rightMargin = 8;
        img.setLayoutParams(layoutParams);

        ConstraintLayout.LayoutParams nameParams =
                new ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        nameParams.topToTop= 22;
        nameParams.leftToLeft = 98;
        textView.setLayoutParams(nameParams);
        //98
        TextView nameLabelView = new TextView(this);
    }
}
