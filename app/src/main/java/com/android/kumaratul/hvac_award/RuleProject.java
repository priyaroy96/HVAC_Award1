package com.android.kumaratul.hvac_award;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RuleProject extends AppCompatActivity {
    TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rule_project);
        t1=(TextView)findViewById(R.id.textView32);
        String data="Rules For Projects & Awards:-"+"\n"+"1.Give rating on the base of clean work,engineering,easy of serviceability."+"\n"
                +"2.Do not post same project again."+"\n"
                +"3.User can upload more than one project."+"\n"
                +"4.Award will purely on rating basis."+"\n"
                +"5.If Your post had not approved by admin it will take in next month"+"\n"
                +"6.Admin have right to reject without assigning the reason";

        t1.setText(data);
    }
}
