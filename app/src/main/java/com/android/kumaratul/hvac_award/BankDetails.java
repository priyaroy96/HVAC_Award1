package com.android.kumaratul.hvac_award;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BankDetails extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11;
    Button b1,b2;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bank_details);
        e1=(EditText)findViewById(R.id.editText36);
        e2=(EditText)findViewById(R.id.editText37);
        e3=(EditText)findViewById(R.id.editText38);
        e4=(EditText)findViewById(R.id.editText39);
        e5=(EditText)findViewById(R.id.editText40);
        e6=(EditText)findViewById(R.id.editText41);
        e7=(EditText)findViewById(R.id.editText42);
        e8=(EditText)findViewById(R.id.editText43);
        e9=(EditText)findViewById(R.id.editText44);
        e10=(EditText)findViewById(R.id.editText45);
        e11=(EditText)findViewById(R.id.editText46);
        db=openOrCreateDatabase("Hvac",MODE_PRIVATE,null);
        db.execSQL("create table IF NOT EXISTS project(email varchar(40),pass varchar(25),promo varchar(40),acholdername varchar(30),bankname varchar(50),bankbranch varchar(50),acno varchar(20),ifsc varchar(20),projectnumber varchar(20),capacity varchar(20),projectsite varchar(50),address varchar(150),area varchar(40),city varchar(40))");
        b1=(Button)findViewById(R.id.button40);
        b2=(Button)findViewById(R.id.button41);
        Bundle ob=getIntent().getExtras();
        final String e=ob.getString("em");
        final String p=ob.getString("pass");
        final String mypro=ob.getString("mypromo");
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(BankDetails.this, UploadImage.class);
                startActivity(i1);

                        }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=e;
                String pass=p;
                String promo=mypro;
                String acholdername = e1.getText().toString();
                String bankname = e2.getText().toString();
                String bankbranch = e3.getText().toString();
                String acno = e4.getText().toString();
                String ifsc = e5.getText().toString();
                String projectnumber=e6.getText().toString();
                String capacity=e7.getText().toString();
                String projectsite=e8.getText().toString();
                String address=e9.getText().toString();
                String area=e10.getText().toString();
                String city=e11.getText().toString();

                if(acholdername.length()!=0 && bankname.length()!=0 && bankbranch.length()!=0 && acno.length()!=0 &&ifsc.length()!=0 && projectnumber.length()!=0 &&capacity.length()!=0 && projectsite.length()!=0 &&address.length()!=0 && area.length()!=0 &&city.length()!=0)
                {



                        db.execSQL("insert into project values('" + email + "','" + pass + "','" + promo + "','" + acholdername + "','" + bankname+ "','" + bankbranch + "','" + acno + "','" + ifsc + "','" + projectnumber + "','" + capacity + "','" + projectsite + "','" + address + "','"+area+"','"+city+"')");
                        Intent i1 = new Intent(BankDetails.this, UserSignUp.class);
                        startActivity(i1);
                        Toast.makeText(getApplicationContext(), "successfully saved", Toast.LENGTH_SHORT).show();
                    }
                else
                {
                   Toast.makeText(getApplicationContext(), "please give all & Valid details", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
