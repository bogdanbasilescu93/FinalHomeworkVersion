package com.parse.starter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;

public class ChangePasswordActivity extends Activity {

    Button changePassword;
    EditText password1,password2;
    String ps1,ps2;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.changepass);

        password1 = (EditText) findViewById(R.id.editText);
        password2 = (EditText) findViewById(R.id.editText2);

        changePassword = (Button) findViewById(R.id.button6);
        changePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            ParseUser user= ParseUser.getCurrentUser();

                ps1 = password1.getText().toString();
                ps2 = password2.getText().toString();
                if(ps2.equals("")){
                    Toast.makeText(getApplicationContext(),
                            "Please insert new Password!",
                            Toast.LENGTH_LONG).show();
                }else {
                    user.setPassword(ps2);
                   user.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if (null == e) {
                                Toast.makeText(getApplicationContext(),
                                        "Password Successfully changed!",
                                        Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(
                                        ChangePasswordActivity.this,
                                        Welcome.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(),
                                        "Password error!",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    });

                }
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(
                ChangePasswordActivity.this,
                Welcome.class);
        startActivity(intent);
        finish();

    }
}
