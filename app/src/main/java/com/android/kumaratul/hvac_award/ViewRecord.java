package com.android.kumaratul.hvac_award;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import static com.android.kumaratul.hvac_award.R.id.textView33;

public class ViewRecord extends Activity {
    SQLiteDatabase db;
    //EditText mypromo;//ExpandableListView l1;
    Button b1,b2,b3,b4;
    TextView t1,t2;
   // private String[] lv_arr = {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_record);
        b1=(Button)findViewById(R.id.button8);
        b2=(Button)findViewById(R.id.button20);
        b3=(Button)findViewById(R.id.button21);
        b4=(Button)findViewById(R.id.button22);
        t1=(TextView)findViewById(R.id.textView33);
        t2=(TextView)findViewById(R.id.textView34);
        //final ListView lv = (ListView) findViewById(R.id.List1);
        //l1=(ExpandableListView) findViewById(R.id.pen);
        //mypromo=(EditText)findViewById(R.id.editText20);
        db=openOrCreateDatabase("Hvac",MODE_PRIVATE,null);
        final Bundle ob=getIntent().getExtras();
        final String e2=ob.getString("em2");
        t1.setText(e2);
        /*b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor c = db.rawQuery("select * from user1 where email= '" + e + "'", null);
                String data="Your Profile:-";
                //String[] data = null;
                while (c.moveToNext()) {
                    data = data+"\nNAME       :-" + c.getString(0) + " " + c.getString(1) + "\nEMAIL    :-" +
                            c.getString(2) + "\nMOBILE    :-" + c.getString(3) + "\nADDRESS   :-" +
                            c.getString(4) + "\nCity       :-" + c.getString(5) + "\n" + c.getString(6) + "," + c.getString(7)
                            + "\nREFER PROMO-CODE:-" + c.getString(10) + "\nYOUR  PROMO-CODE:-" + c.getString(11) + "\n";
                    c.close();
                }
                t1.setText(data);
            }
        });*/


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String e1 = mypromo.getText().toString();
                String e1=ob.getString("mypromo");
                Cursor c = db.rawQuery("select * from user1 WHERE mypromo= '" + e1 + "'", null);
                String data1="Your Profile:-";
                //String[] data =null;
                while (c.moveToNext()) {
                    data1 = data1+"\nNAME       :-" + c.getString(0) + " " + c.getString(1) + "\nEMAIL    :-" +
                            c.getString(2) + "\nMOBILE    :-" + c.getString(3) + "\nADDRESS   :-" +
                            c.getString(4) + "\nCity       :-" + c.getString(5) + "\n" + c.getString(6) + "," + c.getString(7)
                            + "\nREFER PROMO-CODE:-" + c.getString(10) + "\nYOUR  PROMO-CODE:-" + c.getString(11) + "\n";
                    c.close();
                }
                //lv_arr = data;
                //lv.setAdapter(new ArrayAdapter<String>(ViewRecord.this,
                        //android.R.layout.simple_list_item_1, lv_arr));
                t2.setText(data1);
                //ArrayAdapter<String> ob = new ArrayAdapter<String>(this, data, simple_expandable_list_item_1);
                //l1.setAdapter(ob);


            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e1=ob.getString("mypromo");
                Intent i1=new Intent(ViewRecord.this,ChangePassword.class);
                i1.putExtra("em2",e2);
                i1.putExtra("mypromo",e1);
                startActivity(i1);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e1=ob.getString("mypromo");
                Intent i1=new Intent(ViewRecord.this,EditProfile.class);
                i1.putExtra("em2",e2);
                i1.putExtra("mypromo",e1);
                startActivity(i1);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e=ob.getString("em");
                String p=ob.getString("pass");
                String mypro=ob.getString("mypromo");
                Intent i1=new Intent(ViewRecord.this,Projects.class);
                i1.putExtra("em",e);
                i1.putExtra("pass",p);
                i1.putExtra("mypromo",mypro);
                startActivity(i1);
            }
        });
    }
}
