package edu.cs.birzeit.a1172482.assignment_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = getIntent();

        String data = intent.getStringExtra("DATA");

        TextView viewTxt =findViewById(R.id.viewTxt);

        viewTxt.setText(data);
    }
}