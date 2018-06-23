package com.android.kumaratul.hvac_award;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserSignUp extends AppCompatActivity {
    EditText email,pass,promocode;
    Button b1,b2;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_up);
        db=openOrCreateDatabase("Hvac",MODE_PRIVATE,null);
        db.execSQL("create table IF NOT EXISTS user1(name varchar(25),surname varchar(25),email varchar(40),mobile varchar(15),address varchar(100),city varchar(20),state varchar(20),pin varchar(10),pass varchar(20),cpass varchar(20),refpromo varchar(30),mypromo varchar(30))");
        //db.execSQL("drop table IF EXISTS user");
        email=(EditText)findViewById(R.id.editText);
        pass=(EditText)findViewById(R.id.editText2);
        promocode=(EditText)findViewById(R.id.editText3);
        b1=(Button)findViewById(R.id.button3);
        b2=(Button)findViewById(R.id.button4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = email.getText().toString();
                String p= pass.getText().toString();
                String mypro=promocode.getText().toString();
                Cursor c=db.rawQuery("Select email,pass,mypromo from user1 where email='"+e+"'and pass='"+p+"' and mypromo='"+mypro+"'",null);
                if (c.moveToNext())
                {
                    Intent i=new Intent(UserSignUp.this,ViewProfile.class);
                    i.putExtra("em",e);
                    i.putExtra("pass",p);
                    i.putExtra("mypromo",mypro);
                    startActivity(i);
                    c.close();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Login failed please enter the correct Details",Toast.LENGTH_LONG).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(UserSignUp.this,SignUp.class);
                startActivity(i1);
            }
        });
    }
}
