package com.android.kumaratul.hvac_award;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin extends AppCompatActivity {
    EditText e1,e2;
    Button b1,b2,b3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        e1=(EditText)findViewById(R.id.editText18);
        e2=(EditText)findViewById(R.id.editText19);
        b1=(Button)findViewById(R.id.button9);
        b2=(Button)findViewById(R.id.button10);
        b3=(Button)findViewById(R.id.button11);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=e1.getText().toString();
                String p=e2.getText().toString();
                if (n.equals("Hvac1234") && p.equals("Admin1234"))
                {
                    Toast.makeText(getApplicationContext(),"LOGIN SUCCESSFULLY",Toast.LENGTH_LONG).show();
                    Intent i=new Intent(Admin.this,Showdata.class);
                    i.putExtra("abc",n);
                    i.putExtra("xyz",p);
                    startActivity(i);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"LOGIN FAILED",Toast.LENGTH_LONG).show();
                }

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9083770941"));
                startActivity(I1);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I2=new Intent(Intent.ACTION_SENDTO,Uri.parse("sms:9083770941"));
                I2.putExtra("sms_body","Plz Give Admin Id and PassWord");
                startActivity(I2);
            }
        });
    }
}
