package com.example.jobsandtasks;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import org.w3c.dom.Text;


public class homeEmployeeShowClass extends AppCompatActivity
{
    String name;
    String Location;

    public homeEmployeeShowClass(employee e)
    {
        name = e.getFName() + " " +e.getlName();
        Location = e.getEmpLocalArea();
    }

    public View makeProf()
    {
        ConstraintLayout c = (ConstraintLayout) findViewById(R.id.employLayout);
        TextView nameView = c.findViewById(R.id.nameView);
        nameView.setText(name);
        TextView LocationView = c.findViewById(R.id.locationView);
        LocationView.setText(Location);

        return c;
    }
}
