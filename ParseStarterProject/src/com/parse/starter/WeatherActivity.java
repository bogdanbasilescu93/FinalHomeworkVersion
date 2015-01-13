package com.parse.starter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class WeatherActivity extends Activity {

    String citytxt;
    String countrytxt;
    EditText city,country;
    TextView output;
    ListView days;
    Button checkWeather;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);

         city = (EditText) findViewById(R.id.editText3);
         country = (EditText) findViewById(R.id.editText4);
         days = (ListView) findViewById(R.id.listView);
         output = (TextView) findViewById(R.id.textView6);

        checkWeather = (Button) findViewById(R.id.button7);
        checkWeather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                citytxt=city.getText().toString();
                countrytxt=country.getText().toString();
                output.setText("The weather in "+citytxt+","+countrytxt+" is:");

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent= new Intent(WeatherActivity.this,Welcome.class);
        startActivity(intent);
        finish();
    }
}
