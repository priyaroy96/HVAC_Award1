package com.android.kumaratul.hvac_award;

import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Projects extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_projects);
        b1=(Button)findViewById(R.id.button14);
        b2=(Button)findViewById(R.id.button15);
        e1=(EditText)findViewById(R.id.editText22);
        e2=(EditText)findViewById(R.id.editText23);
        Bundle ob=getIntent().getExtras();
        final String e=ob.getString("em");
        final String p=ob.getString("pass");
        final String mypro=ob.getString("mypromo");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e4=e1.getText().toString();
                if(e4.equalsIgnoreCase("yes"))
                {
                    Intent i=new Intent(Projects.this,BankDetails.class);
                    i.putExtra("em",e);
                    i.putExtra("pass",p);
                    i.putExtra("mypromo",mypro);
                    startActivity(i);
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e3=e2.getText().toString();
                if(e3.equalsIgnoreCase("yes"))
                {
                    Intent i=new Intent(Projects.this,ViewRating.class);
                    i.putExtra("em",e);
                    i.putExtra("pass",p);
                    i.putExtra("mypromo",mypro);
                    startActivity(i);
                }
            }
        });
    }
}
