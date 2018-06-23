package com.android.kumaratul.hvac_award;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditProfile extends AppCompatActivity {
    EditText et1,et2,et3,et4,et5,et6,et7;
    Button b;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);
        db=openOrCreateDatabase("Hvac",MODE_PRIVATE,null);
        et1=(EditText)findViewById(R.id.editText28);
        et2=(EditText)findViewById(R.id.editText29);
        et3=(EditText)findViewById(R.id.editText30);
        et4=(EditText)findViewById(R.id.editText31);
        et5=(EditText)findViewById(R.id.editText32);
        et6=(EditText)findViewById(R.id.editText33);
        et7=(EditText)findViewById(R.id.editText34);
        b=(Button)findViewById(R.id.button24);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle ob=getIntent().getExtras();
                String e2=ob.getString("em2");
                String e1=ob.getString("mypromo");
                String m=et1.getText().toString();
                String n=et2.getText().toString();
                String sn=et3.getText().toString();
                String a=et4.getText().toString();
                String c=et5.getText().toString();
                String s=et6.getText().toString();
                String p=et7.getText().toString();
                   db.execSQL("update user1 set name='"+n+"',surname='"+sn+"',address='"+a+"',city='"+c+"',state='"+s+"',pin='"+p+"' where pass='"+m+"'and email='"+e2+"' and mypromo='"+e1+"'");
                    Intent i=new Intent(EditProfile.this,UserSignUp.class);
                    startActivity(i);
                    Toast.makeText(getApplicationContext(),"Details Changed Successfully,please Login Again",Toast.LENGTH_LONG).show();



            }
        });
    }
}
