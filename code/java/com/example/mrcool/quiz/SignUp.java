package com.example.mrcool.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SignUp extends AppCompatActivity {
    EditText usr,nm,pass,rpass,mobile;
    Button sup,lin;
    QuizDB d ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        d = new QuizDB(this);

        usr = (EditText)findViewById(R.id.es1);
        nm = (EditText)findViewById(R.id.nam);
        pass = (EditText)findViewById(R.id.es2);
        rpass = (EditText)findViewById(R.id.es3);
        mobile = (EditText)findViewById(R.id.es4);
        sup = (Button)findViewById(R.id.su);
        lin = (Button)findViewById(R.id.li);
        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(usr.getText().toString().isEmpty())
                {
                    usr.setError("Required field");
                }
                if(nm.getText().toString().isEmpty())
                {
                    nm.setError("Required field");
                }
                if(pass.getText().toString().isEmpty())
                {
                    pass.setError("Required field");
                }
                if(rpass.getText().toString().isEmpty())
                {
                    rpass.setError("Required field");
                }
                if(mobile.getText().toString().isEmpty())
                {
                    mobile.setError("Required field");
                }

                if(mobile.getText().toString().length()!=10)
                {
                    mobile.setError("Plz enter right no.");
                }
                if(pass.getText().toString().equals(rpass.getText().toString()))
                {
                    d.addUser(usr.getText().toString().trim(),nm.getText().toString().trim(),pass.getText().toString().trim(),rpass.getText().toString().trim(),mobile.getText().toString().trim());

                    cln();

                }
                else {

                    rpass.setError("Password doesn't match");
                }
            }
        });
        lin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(SignUp.this,LogIn.class);
                startActivity(i);
                cln();
            }
        });

    }
    public void cln()
    {
        usr.setText(null);
        usr.requestFocus();
        nm.setText(null);
        pass.setText(null);
        rpass.setText(null);
        mobile.setText(null);
    }
}
