package com.android.kumaratul.hvac_award;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ViewExperience extends Activity {
    SQLiteDatabase db;
    String[] lv_arr1 = {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_experience);
        db=openOrCreateDatabase("Hvac",MODE_PRIVATE,null);
        Cursor c = db.rawQuery("select * from experience1", null);
        String[] data = null;
        while (c.moveToNext()) {
            data = new String[]{"\nEmail      :-" + c.getString(0) + "\nPromo-code:-" + c.getString(1) + "\nExperience(years)    :-" +
                    c.getString(2) + "\nExperience(Service)    :-" + c.getString(3)};
        }
        lv_arr1 = data;
        //lv_arr1= (String[]) data.toArray();
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview2, lv_arr1);

        ListView listView = (ListView) findViewById(R.id.mobile_list2);
        listView.setAdapter(adapter);
    }
}
