package edu.cs.birzeit.a1172482.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Spinner cities;
    private TextView fName;
    private TextView lName;
    private TextView email;
    private TextView phone;
    private RadioButton male;
    private RadioButton female;
    private TextView birthOfDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cities = findViewById(R.id.citiesSpinner);
        fName = findViewById(R.id.fNameEdtTxt);
        lName = findViewById(R.id.lNameEdtTxt);
        email = findViewById(R.id.emailEdtTxt);
        phone = findViewById(R.id.phoneEdtTxt);
        male = findViewById(R.id.maleRbtn);
        female = findViewById(R.id.femaleRbtn);
        birthOfDate = findViewById(R.id.BODedtTxt);

        populateCitiesSpinner();
    }

    private void populateCitiesSpinner() {
        ArrayList<String> citiesData = new ArrayList<>();
        citiesData.add("Jerusalem");
        citiesData.add("Ramallah");
        citiesData.add("Hebron");
        citiesData.add("Bethlehem");
        citiesData.add("Jericho");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, citiesData);

        cities.setAdapter(adapter);
    }

    public void save_OnClick(View view) {
        Intent intent = new Intent(this, MainActivity2.class);

        String dataCity = cities.getSelectedItem().toString();
        String dataFName = "";
        String dataLName = lName.getText().toString();
        String dataEmail = email.getText().toString();
        String dataPhone = phone.getText().toString();
        String dataGender = "";
        String dataBirthOfDate = birthOfDate.getText().toString();
        String preName = "";


        if(male.isChecked()){
            dataGender="male";
            preName = "Mr.";
        }
        else if(female.isChecked()){
            dataGender = "Female";
            preName="Mrs.";
        }
        else{
            dataGender="Not Selected";
        }
        if(fName.getText().equals("")){
            dataFName = "No Name";
        }
        else{
            dataFName=fName.getText().toString();
        }

        String data = "Welcome "+preName +dataFName+" "+dataLName+",\nto my Application.\n"+
                "\nHere is your information: \n\nEmail: "+dataEmail+","+
                "\nGender: "+dataGender+","+
                "\nPhone: "+dataPhone+","+
                "\nDate Of Birth: "+dataBirthOfDate+","+
                "\nCity: "+dataCity+".";
        intent.putExtra("DATA", data);

        startActivity(intent);
    }
}