package com.example.jobsandtasks;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class employeeEdit extends AppCompatActivity
{
    employee curEmp = new employee("Emerson", "Love", "superStraight@straight.com", "555-141-4141", "meepling10"
            ,"Syria", "85086", "Anthem", "Hitman", "Boulder Creek", "none", true);

    int user = 0;

    private static final int SELECT_PICTURE = 0;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_prof_editor);
        imageView = (ImageView) findViewById(R.id.imageView5);

        Intent intent = getIntent();
        int curUserPosition = intent.getIntExtra("currentUser",0);
        employeeDataBase dataBase = new employeeDataBase();
        curEmp = dataBase.getEmployeeBylogin(curUserPosition);
        user = curUserPosition;

        EditText empName = findViewById(R.id.nameEdit);
        empName.setHint(curEmp.getFName());

        EditText empLname = findViewById(R.id.lastNameEdit);
        empLname.setHint(curEmp.getlName());

        EditText empCountry = findViewById(R.id.countryEdit);
        empCountry.setHint(curEmp.getEmpCountry());

        EditText empPostal = findViewById(R.id.postalEdit);
        empPostal.setHint(curEmp.getEmpPostal());

        EditText empRegion = findViewById(R.id.regionEdit);
        empRegion.setHint(curEmp.getEmpLocalArea());

        EditText empBio = findViewById(R.id.bioEdit);
        empBio.setHint(curEmp.getBio());

        EditText empSchool = findViewById(R.id.schoolEdit);
        empSchool.setHint(curEmp.getSchool());

        EditText empDegree = findViewById(R.id.degreeEdit);
        empDegree.setHint(curEmp.getDegree());

        EditText empPrevJob = findViewById(R.id.prevJobEdit);
        empPrevJob.setHint(curEmp.getemprevJob());

        EditText empPhone = findViewById(R.id.phoneConactEdit);
        empPhone.setHint(curEmp.getEmpPhone());

        EditText empEmail = findViewById(R.id.emailContactEdit);
        empEmail.setHint(curEmp.getEmpEmail());

        TextView skillsShow = findViewById(R.id.skillsView);
        String skillString = "";
        for (int i = 0; i < curEmp.getSkill().size(); i++)
        {
            skillString = skillString + curEmp.getSkill().get(i) + ", ";
        }
        skillsShow.setText(skillString);

    }

    public void returnToAccount(View view)
    {
        EditText empFname = findViewById(R.id.nameEdit);
        if (empFname.getText().toString().replaceAll(" ", "").equals("") == false) { curEmp.setFName(empFname.getText().toString()); }

        EditText emplName = findViewById(R.id.lastNameEdit);
        if (emplName.getText().toString().replaceAll(" ", "").equals("") == false) { curEmp.setlName(emplName.getText().toString());}

        EditText empCountry = findViewById(R.id.countryEdit);
        if (empCountry.getText().toString().replaceAll(" ", "").equals("") == false)
        {curEmp.setEmpCountry(empCountry.getText().toString());}

        EditText empPostal = findViewById(R.id.postalEdit);
        if (empPostal.getText().toString().replaceAll(" ", "").equals("") == false)
        {curEmp.setEmpPostal(empPostal.getText().toString());}

        EditText empRegion = findViewById(R.id.regionEdit);
        if (empRegion.getText().toString().replaceAll(" ", "").equals("") == false)
            curEmp.setEmpLocalArea(empRegion.getText().toString());

        EditText empBio = findViewById(R.id.bioEdit);
        if (empBio.getText().toString().replaceAll(" ", "").equals("") == false)
            curEmp.setBio(empBio.getText().toString());

        EditText empSchool = findViewById(R.id.schoolEdit);
        if (empSchool.getText().toString().replaceAll(" ", "").equals("") == false)
            curEmp.setSchool(empSchool.getText().toString());

        EditText empDegree = findViewById(R.id.degreeEdit);
        if (empDegree.getText().toString().replaceAll(" ", "").equals("") == false)
            curEmp.setDegree(empDegree.getText().toString());

        EditText empPrevJob = findViewById(R.id.prevJobEdit);
        if (empPrevJob.getText().toString().replaceAll(" ", "").equals("") == false)
            curEmp.setemprevJob(empPrevJob.getText().toString());

        EditText empPhone = findViewById(R.id.phoneConactEdit);
        if (empPhone.getText().toString().replaceAll(" ", "").equals("") == false)
            curEmp.setEmpPhone(empPhone.getText().toString());

        EditText empEmail = findViewById(R.id.emailContactEdit);
        if (empEmail.getText().toString().replaceAll(" ", "").equals("") == false)
            curEmp.setEmpEmail(empEmail.getText().toString());

        Intent intent= new Intent(this ,employeeProfile.class);
        intent.putExtra("currentUser", user);
        startActivity(intent);
    }

    public void addSkill(View view)
    {
        EditText skill = findViewById(R.id.skillEditText);
        if (skill.getText().toString().trim().equals("") == false) {
            curEmp.addSkill(skill.getText().toString());
            skill.setText("");

            TextView skillsShow = findViewById(R.id.skillsView);
            String skillString = "";
            for (int i = 0; i < curEmp.getSkill().size(); i++) {
                skillString = skillString + curEmp.getSkill().get(i) + ", ";
            }
            skillsShow.setText(skillString);
        }


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Bitmap bitmap = getPath(data.getData());
            imageView.setImageBitmap(bitmap);

        }
    }

    private Bitmap getPath(Uri uri) {

        String[] projection = {MediaStore.Images.Media.DATA};
        Cursor cursor = managedQuery(uri, projection, null, null, null);
        int column_index = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String filePath = cursor.getString(column_index);
        // cursor.close();
        // Convert file path into bitmap image using below line.
        Bitmap bitmap = BitmapFactory.decodeFile(filePath);

        return bitmap;
    }

    public void selectImage(View view)
    {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
    }
}
