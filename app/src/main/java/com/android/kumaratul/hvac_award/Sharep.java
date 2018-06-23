package com.android.kumaratul.hvac_award;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Sharep extends AppCompatActivity {
    Button b1,b2,b3;
    TextView e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sharep);
        b1 = (Button) findViewById(R.id.button37);
        b2=(Button)findViewById(R.id.button38);
        b3=(Button)findViewById(R.id.button39);
        e=(TextView) findViewById(R.id.textView38);
        Bundle ob=getIntent().getExtras();
        String mypro=ob.getString("mypromo");
        final String gg="Hii Give My Promo-Code To Earn More Benefits In Projects:-"+mypro;
        e.setText(gg);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I1=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"));
                startActivity(I1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent I2=new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:"));
                I2.putExtra("sms_body",gg);
                startActivity(I2);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent I3=new Intent(Sharep.this,Email.class);
                startActivity(I3);
            }
        });
    }
}
