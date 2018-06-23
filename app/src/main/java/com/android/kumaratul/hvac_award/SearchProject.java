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

public class SearchProject extends AppCompatActivity {

    SQLiteDatabase db;
    EditText email,prono;
    Button b1, b2, b3;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_project);
        b1 = (Button) findViewById(R.id.button42);
        b2 = (Button) findViewById(R.id.button43);
        b3 = (Button) findViewById(R.id.button44);
        email = (EditText) findViewById(R.id.editText47);
        prono = (EditText) findViewById(R.id.editText48);
        t1 = (TextView) findViewById(R.id.textView50);
        db = openOrCreateDatabase("Hvac", MODE_PRIVATE, null);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e1 = email.getText().toString();
                String e2 = prono.getText().toString();
                Cursor c = db.rawQuery("select * from project WHERE email= '" + e1 + "' OR projectnumber='"+e2+"' ", null);
                String data1 = "Bank & Project Details:-";
                //String[] data =null;
                while (c.moveToNext()) {
                    data1 = data1 + "\nEmail       :-" + c.getString(0) + "\nPromo-code:-" + c.getString(2) + "\nAccount holder Name    :-" +
                            c.getString(3) + "\nBankName    :-" + c.getString(4) + "\nBank Branch   :-" +
                            c.getString(5) + "\nAccount No.  :-" + c.getString(6) + "\nIFSC Code:-" + c.getString(7) + "\nProject Number:-" + c.getString(8)
                            + "\nProject Capacity:- " + c.getString(9) + "\nProject Site:-  " + c.getString(10)+"\nAddress:=-"+c.getString(11)+"\nArea:-" +c.getString(12)+","+c.getString(13)+ "\n";

                }
                c.close();
                t1.setText(data1);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e2 = prono.getText().toString();
                db.execSQL("delete from project where projectnumber='"+e2+"' ");
                Intent i = new Intent(SearchProject.this, Showdata.class);
                startActivity(i);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(SearchProject.this, Showdata.class);
                startActivity(i);

            }
        });
    }
}

