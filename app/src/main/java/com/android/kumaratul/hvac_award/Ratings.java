package com.android.kumaratul.hvac_award;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Ratings extends Activity {
    SQLiteDatabase db;
    String[] lv_arr1 = {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);
        db=openOrCreateDatabase("Hvac",MODE_PRIVATE,null);
        Cursor c = db.rawQuery("select projectnumber,count(*),AVG(ratingpoints) from rating GROUP BY projectnumber ORDER BY projectnumber ", null);
        String[] data = null;
        while (c.moveToNext()) {
            data = new String[]{"\nProject Number      :-" + c.getString(0) + "\nNo. of people rated" + c.getString(1)
                    +"\nYour Rating(Out of 10)    :-" + c.getString(2)};
            //"\nTotal Rating Points:-" + c.getString(4)};
            //
            }
        lv_arr1 = data;
        //lv_arr1= (String[]) data.toArray();
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.activity_listview5, lv_arr1);

        ListView listView = (ListView) findViewById(R.id.mobile_list5);
        listView.setAdapter(adapter);
    }
}

