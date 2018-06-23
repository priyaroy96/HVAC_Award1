package com.android.kumaratul.hvac_award;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangePassword extends AppCompatActivity {
    EditText et1,et2,et3;
    Button b;
    SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        db=openOrCreateDatabase("Hvac",MODE_PRIVATE,null);
        et1=(EditText)findViewById(R.id.editText25);
        et2=(EditText)findViewById(R.id.editText26);
        et3=(EditText)findViewById(R.id.editText27);
        b=(Button)findViewById(R.id.button23);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle ob=getIntent().getExtras();
                String e2=ob.getString("em2");
                String e1=ob.getString("mypromo");
                String n=et1.getText().toString();
                String p=et2.getText().toString();
                String a=et3.getText().toString();
               if (p.equals(a))
               {
                   db.execSQL("update user1 set pass='"+p+"',cpass='"+a+"' where pass='"+n+"' and email='"+e2+"' and mypromo='"+e1+"'");
                   Intent i=new Intent(ChangePassword.this,UserSignUp.class);
                   startActivity(i);
                   Toast.makeText(getApplicationContext(),"Password Changed Successfully,please Login Again",Toast.LENGTH_LONG).show();
               }
               else
               {
                   Intent i=new Intent(ChangePassword.this,ViewRecord.class);
                   startActivity(i);
                   Toast.makeText(getApplicationContext(),"Password Do not Match,please Try Again",Toast.LENGTH_LONG).show();
               }


            }
        });
    }
}
