package com.android.kumaratul.hvac_award;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=(Button)findViewById(R.id.button);
        b2=(Button)findViewById(R.id.button2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainActivity.this,Admin.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1=new Intent(MainActivity.this,UserSignUp.class);
                startActivity(i1);
            }
        });
        myProgress();
    }
    void myProgress() {
        // final for nesting thread
        final ProgressDialog pd = new ProgressDialog(this);
        pd.setMessage("Loading please Wait!!");
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setCancelable(false);
        pd.setTitle("HVAC-Award App");
        pd.show();
        Thread t = new Thread() {
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    try {
                        sleep(1000 / 100);
                    } catch (Exception e) {
                    }
                    pd.setProgress(i);
                }
                pd.dismiss();
            }
        };
        t.start();
    }
}
