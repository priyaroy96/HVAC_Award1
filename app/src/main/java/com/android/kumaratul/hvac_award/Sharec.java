package com.android.kumaratul.hvac_award;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Sharec extends AppCompatActivity {
    Button b1,b2,b3;EditText e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharec);
         b1 = (Button) findViewById(R.id.button16);
        b2=(Button)findViewById(R.id.button17);
        b3=(Button)findViewById(R.id.button18);
        e=(EditText)findViewById(R.id.editText24);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:9083770941"));
                startActivity(I1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e1=e.getText().toString();
                Intent I2=new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:9083770941"));
                I2.putExtra("sms_body",e1);
                startActivity(I2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I3=new Intent(Sharec.this,Email.class);
                startActivity(I3);
            }
        });
    }
}
