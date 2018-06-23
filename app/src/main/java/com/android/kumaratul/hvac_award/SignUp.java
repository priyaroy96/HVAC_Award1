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

import java.security.PublicKey;

public class SignUp extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11;
    Button b1,b2;
    TextView t;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        e1=(EditText)findViewById(R.id.editText4);
        e2=(EditText)findViewById(R.id.editText5);
        e3=(EditText)findViewById(R.id.editText6);
        e4=(EditText)findViewById(R.id.editText7);
        e5=(EditText)findViewById(R.id.editText8);
        e6=(EditText)findViewById(R.id.editText9);
        e7=(EditText)findViewById(R.id.editText10);
        e8=(EditText)findViewById(R.id.editText11);
        e9=(EditText)findViewById(R.id.editText12);
        e10=(EditText)findViewById(R.id.editText13);
        e11=(EditText)findViewById(R.id.editText14);
        t=(TextView)findViewById(R.id.textView17);
        db=openOrCreateDatabase("Hvac",MODE_PRIVATE,null);
        b1=(Button)findViewById(R.id.button5);
        b2=(Button)findViewById(R.id.button6);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fn1 = e1.getText().toString();
                String m1 = e4.getText().toString();
                String mypromo1 = fn1+m1;
                String promo="Your Promocode is "+mypromo1;
                t.setText(promo);

            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fn = e1.getText().toString();
                String ln = e2.getText().toString();
                String e = e3.getText().toString();
                String m = e4.getText().toString();
                String add = e5.getText().toString();
                String city=e6.getText().toString();
                String state=e7.getText().toString();
                String pin=e8.getText().toString();
                String p=e9.getText().toString();
                String cp=e10.getText().toString();
                String refpro=e11.getText().toString();
                String mypro=fn+m;



                if(fn.length()!=0 && ln.length()!=0 && e.length()!=0 && m.length()!=0 &&add.length()!=0 && city.length()!=0 &&state.length()!=0 && pin.length()!=0 &&p.length()!=0 && cp.length()!=0 &&refpro.length()!=0)
                {

                     if(e.contains("@")&&m.length()==10&&pin.length()==6)
                     {
                        db.execSQL("insert into user1 values('" + fn + "','" + ln + "','" + e + "','" + m + "','" + add + "','" + city + "','" + state + "','" + pin + "','" + p + "','" + cp + "','" + refpro + "','" + mypro + "')");
                        Intent i1 = new Intent(SignUp.this, UserSignUp.class);
                        startActivity(i1);
                        Toast.makeText(getApplicationContext(), "You are successfully registered", Toast.LENGTH_SHORT).show();
                    }
                    else
                        {
                            Toast.makeText(getApplicationContext(),"Please give Correct Email Address",Toast.LENGTH_SHORT).show();
                        }
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "please give all & Valid details", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}
