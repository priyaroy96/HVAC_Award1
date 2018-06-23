package com.android.kumaratul.hvac_award;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import static android.R.attr.rating;

public class ViewRating extends AppCompatActivity {
    SQLiteDatabase db;
    EditText e1;
    Button b1,b2,b3,b4;
    RatingBar r;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_rating);
        b1 = (Button) findViewById(R.id.button48);
        b2 = (Button) findViewById(R.id.button45);
        b3 = (Button) findViewById(R.id.button46);
        b4= (Button) findViewById(R.id.button47);
        e1 = (EditText) findViewById(R.id.editText49);
        t1 = (TextView) findViewById(R.id.textView52);
        r=(RatingBar)findViewById(R.id.ratingBar);
        db = openOrCreateDatabase("Hvac", MODE_PRIVATE, null);
        db.execSQL("create table IF NOT EXISTS rating(email varchar(40),pass varchar(25),promo varchar(40),projectnumber varchar(20),ratingpoints decimal(5,5))");
        //db.execSQL("drop table IF EXISTS rating");
        Bundle ob=getIntent().getExtras();
        final String e=ob.getString("em");
        final String p=ob.getString("pass");
        final String mypro=ob.getString("mypromo");
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(ViewRating.this,ViewProfile1.class);
                startActivity(i1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email=e;
                String pass=p;
                String promo=mypro;
                String projectnumber=e1.getText().toString();
                float myNum= r.getRating();
                float ratingp=0;
                Cursor c = db.rawQuery("select * from rating where projectnumber='"+projectnumber+"'", null);
                while (c.moveToNext()) {
                    ratingp = ratingp+c.getFloat(4);
                }c.close();
                float ratingpoints=ratingp+2*myNum;

                db.execSQL("insert into rating values('" + email + "','" + pass + "','" + promo + "','"+projectnumber+"','"+ratingpoints+"')");
                //String s=String.valueOf(r.getRating());
               // int myNum = Integer.parseInt(s);
                String p1="Your rating For Project is:-"+myNum*2+"\n"+"THANK YOU SO MUCH";
                //t1.setText(s);
                //String p1="Your rating For Project is:-"+myNum*2+"\n"+"THANK YOU SO MUCH";
                t1.setText(p1);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(ViewRating.this,Ratings.class);
                startActivity(i1);

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(ViewRating.this,Sharec.class);
                startActivity(i1);
            }
        });
    }
}
