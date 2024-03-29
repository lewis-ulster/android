package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper db;
    EditText txtEmail, txtPassword;
    Button btnLogin, btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = new DatabaseHelper(this);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        txtPassword = (EditText)findViewById(R.id.txtPassword);
        btnRegister = (Button) findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = txtEmail.getText().toString();
                String Password = txtPassword.getText().toString();
                if(Email.equals("")||Password.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",
                            Toast.LENGTH_SHORT).show();}
                else {
                    boolean checkEmail = db.checkEmail(Email);
                    if (checkEmail) {
                        boolean insert = db.insert(Email, Password);
                        if (insert) {
                            Toast.makeText(getApplicationContext(), "Register Successful",
                                    Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Email already Exists",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
