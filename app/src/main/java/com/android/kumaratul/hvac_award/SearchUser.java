package com.android.kumaratul.hvac_award;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SearchUser extends AppCompatActivity {
    SQLiteDatabase db;
    EditText mypromo;
    Button b1,b2,b3;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_user);
        b1=(Button) findViewById(R.id.button31);
        b2=(Button) findViewById(R.id.button32);
        b3=(Button) findViewById(R.id.button33);
        mypromo=(EditText)findViewById(R.id.editText20);
        t1=(TextView)findViewById(R.id.textView36);
        db = openOrCreateDatabase("Hvac", MODE_PRIVATE, null);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e1 = mypromo.getText().toString();
                Cursor c = db.rawQuery("select * from user1 WHERE mobile= '" + e1 + "'", null);
                String data1 = "Profile:-";
                //String[] data =null;
                while (c.moveToNext()) {
                    data1 = data1 + "\nNAME       :-" + c.getString(0) + " " + c.getString(1) + "\nEMAIL    :-" +
                            c.getString(2) + "\nMOBILE    :-" + c.getString(3) + "\nADDRESS   :-" +
                            c.getString(4) + "\nCity       :-" + c.getString(5) + "\n" + c.getString(6) + "," + c.getString(7)
                            + "\nREFER PROMO-CODE:-" + c.getString(10) + "\nYOUR  PROMO-CODE:-" + c.getString(11) + "\n";

                }
                c.close();
                t1.setText(data1);
            }
          });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=mypromo.getText().toString();
                db.execSQL("delete from user1 where mobile='"+n+"'");
                Intent i=new Intent(SearchUser.this,Showdata.class);
                startActivity(i);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(SearchUser.this,Showdata.class);
                startActivity(i);

            }
        });


    }
}
