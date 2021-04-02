package com.example.jobsandtasks;

import android.annotation.SuppressLint;
import android.content.Context;

import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.Image;

import android.os.Bundle;
import android.util.TypedValue;
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

import org.w3c.dom.Text;



public class employeeHomeMaker extends AppCompatActivity {
    private int home_prof_view;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_home_layout);

        LinearLayout mainLl = findViewById(R.id.homeLinearLayout);



        mainLl.addView(makeEmploy());

    }

    public View makeEmploy()
    {
        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams llParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        ll.setLayoutParams(llParams);

        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.ic_place_holder);
        LinearLayout.LayoutParams imgParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        img.setLayoutParams(imgParams);

        ll.addView(img);

        LinearLayout nameLocLL = new LinearLayout(this);
        nameLocLL.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams llParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        llParams2.setMargins(8,12,8,8);
        nameLocLL.setLayoutParams(llParams2);

        TextView name = new TextView(this);
        name.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        name.setText("Epic");

        TextView loc = new TextView(this);
        loc.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
        loc.setText("Somalia");

        nameLocLL.addView(name);
        nameLocLL.addView(loc);

        ll.addView(nameLocLL);

        Button button = new Button(this);
        button.setLayoutParams(llParams2);
        button.setBackgroundColor(Color.BLACK);
        button.setTextColor(Color.WHITE);
        button.setText("connect");
        button.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);

        ll.addView(button);

        return ll;
    }

}
