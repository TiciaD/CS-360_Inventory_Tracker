package com.cs_360.project_two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText usernameEdt, passwordEdt;
    private Button saveBtn;
    DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameEdt = findViewById(R.id.username);
        passwordEdt = findViewById(R.id.password);
        saveBtn = findViewById(R.id.login);

        dbHandler = new DBHandler(this);

        // add on click listener for SignUp/Login button.
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get data from all edit text fields
                String username = usernameEdt.getText().toString();
                String password = passwordEdt.getText().toString();

                // validating if text fields are empty
                if (username.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    Boolean doesUsernameExist = dbHandler.checkUsername(username);

                    if (!doesUsernameExist) {
                        Boolean isUserSuccessfullyAdded = dbHandler.addUserToDatabase(username, password);
                        if (isUserSuccessfullyAdded) {
                            Toast.makeText(LoginActivity.this, "Signup Successful", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "Signup Failed", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Boolean isUserVerified = dbHandler.checkUsernameAndPassword(username, password);
                        if (isUserVerified) {
                            Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(LoginActivity.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });
    }
}