package com.android.kumaratul.hvac_award;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RuleRating extends AppCompatActivity {
     TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule_rating);
        t1=(TextView)findViewById(R.id.textView31);
        String data="Rules For Ratings For Awards:-"+"\n"+"1.Rating will be 1-10."+"\n"
                +"2.(1) will lowest and (10) will be highest"+"\n"
                +"3.capacity Factor is Add Total capacity divided by 10"+"\n"
                +"4.After rating and adding capacity factor ,Add 10% extra to used promocode"+"\n"
                +"Example:-"+"\n"
                +"(a) So if a normal person 'A' who does not used promocode and rate the project 4 and capacity of project is 46TR,total rating will be 8.6"+"\n"
                +"(b) So if a normal person 'b' who used promocode during sign up and rate the project 4 and capacity of project is 46TR ,total rating will be 9.46";

        t1.setText(data);
    }
}
