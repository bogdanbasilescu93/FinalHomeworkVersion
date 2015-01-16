package com.parse.starter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class WeatherActivity extends Activity {

    private String url1 = "http://api.openweathermap.org/data/2.5/weather?q=";
    private EditText location,country,temperature,humidity,pressure;
    private WeatherHandler obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.weather);
        location = (EditText)findViewById(R.id.editText1);
        country = (EditText)findViewById(R.id.editText2);
        temperature = (EditText)findViewById(R.id.editText3);
        humidity = (EditText)findViewById(R.id.editText4);
        pressure = (EditText)findViewById(R.id.editText5);
    }

    public void open(View view){
        String url = location.getText().toString();
        String finalUrl = url1 + url;
        country.setText(finalUrl);
        obj = new WeatherHandler(finalUrl);
        obj.fetchJSON();

        while(obj.parsingComplete);
        country.setText(obj.getCountry());
        temperature.setText(obj.getTemperature());
        humidity.setText(obj.getHumidity());
        pressure.setText(obj.getPressure());

    }
}

