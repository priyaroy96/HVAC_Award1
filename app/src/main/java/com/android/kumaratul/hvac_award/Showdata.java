package com.android.kumaratul.hvac_award;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Showdata extends AppCompatActivity {
    Button b1,b2,b3,b4,b5,b6,b7;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showdata);
        b1=(Button)findViewById(R.id.button12);
        b2=(Button)findViewById(R.id.button25);
        b3=(Button)findViewById(R.id.button26);
        b4=(Button)findViewById(R.id.button27);
        b5=(Button)findViewById(R.id.button28);
        b6=(Button)findViewById(R.id.button29);
        b7=(Button)findViewById(R.id.button30);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Showdata.this,ViewUser.class);
                startActivity(i);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Showdata.this,SearchUser.class);
                startActivity(i);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Showdata.this,ViewExperience.class);
                startActivity(i);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Showdata.this,SearchExperience.class);
                startActivity(i);
            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Showdata.this,ViewProject.class);
                startActivity(i);
            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Showdata.this,SearchProject.class);
                startActivity(i);
            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Showdata.this,Ratings.class);
                startActivity(i);
            }
        });






    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.showdata, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.rules1) {
            Intent i2=new Intent(Showdata.this,RuleRating.class);
            startActivity(i2);
        } else if (id == R.id.rules2) {
            Intent i2=new Intent(Showdata.this,RuleProject.class);
            startActivity(i2);
        } else if (id == R.id.rules3) {
            Intent i2 = new Intent(Showdata.this,Email.class);
            startActivity(i2);
        }else if (id == R.id.rules4) {
            Intent I2=new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"));
            startActivity(I2);
        }
        return super.onOptionsItemSelected(item);
    }
}
