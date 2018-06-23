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

public class SearchExperience extends AppCompatActivity {
    SQLiteDatabase db;
    EditText mypromo;
    Button b1,b2,b3;
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_experience);
        b1=(Button) findViewById(R.id.button34);
        b2=(Button) findViewById(R.id.button35);
        b3=(Button) findViewById(R.id.button36);
        mypromo=(EditText)findViewById(R.id.editText35);
        t1=(TextView)findViewById(R.id.textView37);
        db = openOrCreateDatabase("Hvac", MODE_PRIVATE, null);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e1 = mypromo.getText().toString();
                Cursor c = db.rawQuery("select * from experience1 WHERE email= '" + e1 + "'", null);
                String data1 = "Experience:-";
                //String[] data =null;
                while (c.moveToNext()) {
                    data1 = data1 + "\nExperience(Years):-" + c.getString(2) + "\nExperience(Service)" + c.getString(3);
                }
                c.close();
                t1.setText(data1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n=mypromo.getText().toString();
                db.execSQL("delete from experience1 where email='"+n+"'");
                Intent i=new Intent(SearchExperience.this,Showdata.class);
                startActivity(i);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(SearchExperience.this,Showdata.class);
                startActivity(i);

            }
        });

    }
}
