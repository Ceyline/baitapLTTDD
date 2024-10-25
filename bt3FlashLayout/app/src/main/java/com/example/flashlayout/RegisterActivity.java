package com.example.flashlayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {
    Button loginBtn, registerBtn;
    TextView masv_output, hoten_output, password_output;
    EditText username_input, password_input, email_input, password_cf_input;
    String masv, hoten, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Mapping();
        ControlButton();
    }

    public void ControlButton() {
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
            }
        });
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterEvent();
            }
        });
    }

    public void Mapping() {
        loginBtn = (Button) findViewById(R.id.loginBtn);
        registerBtn = (Button) findViewById(R.id.registerBtn);
        masv_output = (TextView) findViewById(R.id.masv_output);
        hoten_output = (TextView) findViewById(R.id.hoten_output);
        password_output = (TextView) findViewById(R.id.password_output);
        username_input = (EditText) findViewById(R.id.username_input);
        password_input = (EditText) findViewById(R.id.password_input);
        email_input = (EditText) findViewById(R.id.email_input);
        password_cf_input = (EditText) findViewById(R.id.password_cf_input);
    }

    public void RegisterEvent() {
        boolean flag = true;
        String errorSubmit = "";

        if (email_input.getText().toString().isEmpty()) {
            flag = false;
            errorSubmit += "Email cannot be left in blank\n";
        }

        if (username_input.getText().toString().isEmpty()) {
            flag = false;
            errorSubmit += "\nUsername cannot be left in blank\n";
        }
        if (password_input.getText().toString().isEmpty()) {
            flag = false;
            errorSubmit += "\nPassword cannot be left in blank\n";
        }

        if (password_cf_input.getText().toString().isEmpty()) {
            flag = false;
            errorSubmit += "\nYou must confirm your password \n";
        }

        if (!flag) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this, android.R.style.Theme_DeviceDefault_Dialog_Alert);
            builder.setTitle("Alert!");
            builder.setMessage(errorSubmit);
            builder.setIcon(android.R.drawable.ic_dialog_alert);
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                @Override
                public void onClick(DialogInterface dialogInterface, int i){

                }
            });
            builder.show();
        }
        else{
            masv = "22115053122302";
            hoten = username_input.getText().toString();
            pass = password_input.getText().toString();

            masv_output.setText(masv_output.getText().toString() + " " + masv);
            hoten_output.setText(hoten_output.getText().toString() + " " + hoten);
            password_output.setText(password_output.getText().toString() + " " + pass);
        }
    }
}