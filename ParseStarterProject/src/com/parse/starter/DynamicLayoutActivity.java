package com.parse.starter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

public class DynamicLayoutActivity extends Activity implements OnClickListener{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamicactive);

        View buttonAdd = findViewById(R.id.add);
        buttonAdd.setOnClickListener(this);

        View buttonRemove = findViewById(R.id.remove);
        buttonRemove.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.add:
                //Check if the Layout already exists
                LinearLayout hiddenLayout = (LinearLayout)findViewById(R.id.hiddenLayout);
                if(hiddenLayout == null){
                    //Inflate the Hidden Layout Information View
                    LinearLayout myLayout = (LinearLayout)findViewById(R.id.linearLayout2);
                    View hiddenInfo = getLayoutInflater().inflate(R.layout.dynamicdefault, myLayout, false);
                    myLayout.addView(hiddenInfo);
                }

                //Get References to the TextView
                TextView myTextView = (TextView) findViewById(R.id.textView1);
                // Update the TextView Text
                myTextView.setText("This is only a training-homework application!\n" +
                        "The purpose of the application is to become more familiarized with Android platform.\n"+
                        "Button Templates:");
                break;

            case R.id.remove:
                View myView = findViewById(R.id.hiddenLayout);
                ViewGroup parent = (ViewGroup) myView.getParent();
                parent.removeView(myView);

                break;

        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(
                DynamicLayoutActivity.this,
                Welcome.class);
        startActivity(intent);
        finish();

    }

}