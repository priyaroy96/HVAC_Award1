package com.android.kumaratul.hvac_award;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Experience extends AppCompatActivity {
     CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15;
    Button b;
    EditText e1;
    SQLiteDatabase db;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_experience);
        c1=(CheckBox)findViewById(R.id.checkBox);
        c2=(CheckBox)findViewById(R.id.checkBox2);
        c3=(CheckBox)findViewById(R.id.checkBox3);
        c4=(CheckBox)findViewById(R.id.checkBox4);
        c5=(CheckBox)findViewById(R.id.checkBox5);
        c6=(CheckBox)findViewById(R.id.checkBox6);
        c7=(CheckBox)findViewById(R.id.checkBox7);
        c8=(CheckBox)findViewById(R.id.checkBox8);
        c9=(CheckBox)findViewById(R.id.checkBox9);
        c10=(CheckBox)findViewById(R.id.checkBox10);
        c11=(CheckBox)findViewById(R.id.checkBox11);
        c12=(CheckBox)findViewById(R.id.checkBox12);
        c13=(CheckBox)findViewById(R.id.checkBox13);
        c14=(CheckBox)findViewById(R.id.checkBox14);
        c15=(CheckBox)findViewById(R.id.checkBox15);
        b=(Button) findViewById(R.id.button13);
        e1=(EditText)findViewById(R.id.editText21);
        t1=(TextView)findViewById(R.id.textView35);
        db=openOrCreateDatabase("Hvac",MODE_PRIVATE,null);
        final Bundle ob=getIntent().getExtras();
        //String e3=ob.getString("em2");
        //String mypromo1=ob.getString("mypromo");
        //t1.setText(e3+mypromo1);
        //db.execSQL("drop table IF EXISTS experience ");
        db.execSQL("create table IF NOT EXISTS experience1(email varchar(40),mypromo varchar(40),experienceyear varchar(10),experience varchar(400))");
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StringBuilder result = new StringBuilder();
                if(c1.isChecked())
                {      if(c6.isChecked())
                    {
                        result.append("Window(Installation)"+",");
                    }
                    if(c11.isChecked())
                    {
                        result.append("Window(Compliant)"+",");
                    }


                }
                if(c2.isChecked())
                {
                    if(c7.isChecked())
                    {
                        result.append("Split(Installation)"+",");
                    }
                    if(c12.isChecked())
                    {
                        result.append("Split(Compliant)"+",");
                    }
                }
                if(c3.isChecked())
                {
                    if(c8.isChecked())
                    {
                        result.append("Ductable(Installation)"+",");
                    }
                    if(c13.isChecked())
                    {
                        result.append("Ductable(Compliant)"+",");
                    }
                }
                if(c4.isChecked())
                {
                    if(c9.isChecked())
                    {
                        result.append("VRV/VRF(Installation)"+",");
                    }
                    if(c14.isChecked())
                    {
                        result.append("VRV/VRF(Compliant)"+",");
                    }
                }
                if(c5.isChecked())
                {
                    if(c10.isChecked())
                    {
                        result.append("Chiller(Installation)"+",");
                    }
                    if(c15.isChecked())
                    {
                        result.append("Chiller(Compliant)"+",");
                    }
                }

                String expyrs=e1.getText().toString();
                result.append("Experienced In Following Fields:-"+"\n");
                String exp=result.toString();
                String e3=ob.getString("em2");
                String mypromo1=ob.getString("mypromo");
                t1.setText(exp);
                db.execSQL("insert into experience1 values('" + e3+ "','" + mypromo1+ "','" + expyrs + "','" + exp + "')");
                Intent i1 = new Intent(Experience.this,UserSignUp.class);
                startActivity(i1);
                Toast.makeText(getApplicationContext(), "Details Saved Successfully", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
