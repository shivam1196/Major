package com.example.fblogin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Score extends AppCompatActivity {
    Spinner SpinnerScore1,SpinnerScore2;
    TextView txtViewScore,txtViewScore1,txtViewScore3;
    Button mButton;
    String choice1,choice2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        SpinnerScore1=(Spinner)findViewById(R.id.ScoreSpinner1);
        SpinnerScore2=(Spinner)findViewById(R.id.ScoreSpinner2);
        final String [] professions={"Computer Science","Science and Technology","Finance and Marketing","House Wife"};
        ArrayAdapter<String> arrayAdapter= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,professions);
        String [] category={"Student","Fresher Graduate","3-5 Yrs Experience",">5 Years"};
        ArrayAdapter<String> arrayAdapter1= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_spinner_dropdown_item,category);
        SpinnerScore1.setAdapter(arrayAdapter);
        SpinnerScore2.setAdapter(arrayAdapter1);
       SpinnerScore1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               choice1=parent.getItemAtPosition(position).toString();
               Toast.makeText(Score.this, choice1+"", Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });
       SpinnerScore2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               choice2= parent.getItemAtPosition(position).toString();
               Toast.makeText(Score.this, choice2+"", Toast.LENGTH_SHORT).show();
           }

           @Override
           public void onNothingSelected(AdapterView<?> parent) {

           }
       });
        mButton=(Button)findViewById(R.id.ScoreSubmit);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),MainMenu.class);
                Bundle b = new Bundle();
                b.putString("choice1",choice1);
                b.putString("choice2",choice2);
                intent.putExtras(b);
                startActivity(intent);
            }
        });
    }
}
