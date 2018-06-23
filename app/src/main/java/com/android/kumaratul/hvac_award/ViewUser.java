package com.android.kumaratul.hvac_award;

import android.app.Activity;
import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import static android.R.layout.simple_expandable_list_item_1;

public class ViewUser extends Activity {
    SQLiteDatabase db;
    //Button b1;

    //int i=0;
    String[] lv_arr1 = {};

    //ListView lv1;
    //NestedScrollView lv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user);
        db = openOrCreateDatabase("Hvac", MODE_PRIVATE, null);
        Cursor c = db.rawQuery("select * from user1", null);
        String[] data = null;
        while (c.moveToNext()) {
            data = new String[]{"\nNAME       :-" + c.getString(0) + " " + c.getString(1) + "\nEMAIL    :-" +
                    c.getString(2) + "\nMOBILE    :-" + c.getString(3) + "\nADDRESS   :-" +
                    c.getString(4) + "\nCity       :-" + c.getString(5) + "\n" + c.getString(6) + "," + c.getString(7)
                    + "\nREFER PROMO-CODE:-" + c.getString(10) + "\nPROMO-CODE     :-" + c.getString(11) + "\n"};

        }c.close();
        lv_arr1 =data;
        // setListAdapter(new ArrayAdapter<String>(this, simple_expandable_list_item_1,lv_arr1));
        //lv_arr1= (String[]) data.toArray();
        ListAdapter adapter = new ArrayAdapter<String>(this, R.layout.activity_listview, lv_arr1);
        //ArrayAdapter<String> ob = new ArrayAdapter<String>(this, simple_expandable_list_item_1, lv_arr1);
        ListView listView = (ListView) findViewById(R.id.mobile_list);
        listView.setAdapter(adapter);
    }



        /*b1=(Button)findViewById(R.id.button19);
        //t1=(TextView)findViewById(R.id.textView20);
        lv1 = (NestedScrollView) findViewById(R.id.List2);
        //l1=(ExpandableListView) findViewById(R.id.pen);
        //mypromo=(EditText)findViewById(R.id.editText20);
        db=openOrCreateDatabase("Hvac",MODE_PRIVATE,null);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String e = mypromo.getText().toString();
                Cursor c = db.rawQuery("select * from user1", null);
                String data="Your Profile:-";
                //String[] data = null;
                while (c.moveToNext()) {
                    data = data+"\nNAME       :-" + c.getString(0) + " " + c.getString(1) + "\nEMAIL    :-" +
                            c.getString(2) + "\nMOBILE    :-" + c.getString(3) + "\nADDRESS   :-" +
                            c.getString(4) + "\nCity       :-" + c.getString(5) + "\n" + c.getString(6) + "," + c.getString(7)
                            + "\nREFER PROMO-CODE:-" + c.getString(10) + "\nPROMO-CODE     :-" + c.getString(11) + "\n";
                }
                //lv_arr1 = data;
                //lv1.setAdapter(new ArrayAdapter<String>(ViewUser.this,
                        //android.R.layout.simple_list_item_1, lv_arr1));
                //t1.setText(data);
                //ArrayAdapter<String> ob = new ArrayAdapter<String>(this, data, simple_expandable_list_item_1);
                //l1.setAdapter(ob);


            }
        });*/

}
