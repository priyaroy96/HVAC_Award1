package com.android.kumaratul.hvac_award;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewProject extends Activity {
    SQLiteDatabase db;
    String[] lv_arr1 = {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_project);
        db=openOrCreateDatabase("Hvac",MODE_PRIVATE,null);
        Cursor c = db.rawQuery("select * from project", null);
        String[] data1 = null;
        while (c.moveToNext()) {
            data1 = new String[] {"\nEmail       :-" + c.getString(0) + "\nPromo-code:-" + c.getString(2) + "\nAccount holder Name    :-" +
                    c.getString(3) + "\nBankName    :-" + c.getString(4) + "\nBank Branch   :-" +
                    c.getString(5) + "\nAccount No.  :-" + c.getString(6) + "\nIFSC Code:-" + c.getString(7) + "\nProject Number:-" + c.getString(8)
                    + "\nProject Capacity:- " + c.getString(9) + "\nProject Site:-  " + c.getString(10)+"\nAddress:=-"+c.getString(11)+"\nArea:-" +c.getString(12)+","+c.getString(13)+ "\n"};

        }
        lv_arr1 = data1;
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview3, lv_arr1);

        ListView listView = (ListView) findViewById(R.id.mobile_list3);
        listView.setAdapter(adapter);

    }
}
