package com.example.mrcool.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {
    Button log,sign;
    EditText user,pass;
    RadioGroup rg;
    RadioButton r,ru,ra;
    QuizDB d;
    static String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        user = (EditText)findViewById(R.id.E1);
        pass = (EditText)findViewById(R.id.E2);
        log = (Button)findViewById(R.id.bt1);
        sign = (Button)findViewById(R.id.bt2);
        rg = (RadioGroup)findViewById(R.id.rg);
        ru = (RadioButton)findViewById(R.id.r1);
        ra = (RadioButton)findViewById(R.id.r2);
        ru.setChecked(true);
        d = new QuizDB(this);
        uid = user.getText().toString();


        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int myid = rg.getCheckedRadioButtonId();
                r = (RadioButton)findViewById(myid);

                if(user.getText().toString().isEmpty())
                {
                    user.setError("Enter the userId...!");
                }
                if(pass.getText().toString().isEmpty())
                {
                    pass.setError("Enter the password...!");
                }
//                if (!rg.isSelected())
//                {
//                    Toast.makeText(LogIn.this, "Plz Select RadioButton...!", Toast.LENGTH_LONG).show();
//                }

                if(r.getText().toString().equals("user"))
                {

                    try {
                        String passs =d.logIn(user.getText().toString().trim());

                        if (passs.equals(pass.getText().toString().trim())) {

                            Intent i = new Intent(LogIn.this,LangTp.class);
                            i.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            startActivity(i);
                        } else {
                            Toast.makeText(LogIn.this, "Plz Try Again..?", Toast.LENGTH_LONG).show();
                        }


                    }catch(Exception t){
                        Toast.makeText(LogIn.this, "Plz Try Again..?", Toast.LENGTH_LONG).show();
                    }

                }
                if (r.getText().toString().equals("admin"))
                {
                    if(user.getText().toString().equals("honey@123")&&pass.getText().toString().equals("mukesh")) {
                        Intent i = new Intent(LogIn.this, Lang.class);
                        startActivity(i);
                    }
                }
                cln();
            }
        });

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LogIn.this,SignUp.class);
                startActivity(i);
                cln();
            }
        });
    }
    public void cln(){
        user.setText(null);
        user.requestFocus();
        pass.setText(null);

    }
}
