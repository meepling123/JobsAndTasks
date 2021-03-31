package com.example.jobsandtasks;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.media.Image;
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

import org.w3c.dom.Text;

public class employeeHomeMaker extends AppCompatActivity
{

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_home_layout);

        LinearLayout mainLl = findViewById(R.id.homeLinearLayout);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.HORIZONTAL);
        LinearLayout.LayoutParams  llParams = new LinearLayout.LayoutParams(220,140);
        ll.setLayoutParams(llParams);

        ImageView img = new ImageView(this);
        img.setImageResource(R.drawable.ic_place_holder);
        LinearLayout.LayoutParams imgParams = new LinearLayout.LayoutParams(76, 80);
        imgParams.setMargins(8, 8, 0 ,0);
        img.setLayoutParams(imgParams);

        ll.addView(img);

        LinearLayout nameLocLL = new LinearLayout(this);
        nameLocLL.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams  llParams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        nameLocLL.setLayoutParams(llParams2);

        TextView name = new TextView(this);
        name.setText("Epic");

        TextView loc = new TextView(this);
        loc.setText("Somalia");

        nameLocLL.addView(name);
        nameLocLL.addView(loc);

        ll.addView(nameLocLL);

        Button button = new Button(this);
        button.setLayoutParams(llParams2);
        button.setBackgroundColor(Color.BLUE);
        button.setText("connect");
        button.setTextSize(8);

        ll.addView(button);

        mainLl.addView(ll);

    }
