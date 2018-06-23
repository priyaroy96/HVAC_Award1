package com.android.kumaratul.hvac_award;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class ViewProfile extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    TextView t1;
    //SQLiteDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_profile);
        t1=(TextView)findViewById(R.id.textView20);
        Bundle ob=getIntent().getExtras();
        String e=ob.getString("em");
        t1.setText(e);
        //t2=(TextView)findViewById(R.id.textView21);
        //db=openOrCreateDatabase("Hvac",MODE_PRIVATE, null);
        //Bundle ob=getIntent().getExtras();
        //String e=ob.getString("emailid");
        /*Cursor cursor = db.rawQuery("SELECT name,surname,email FROM user WHERE email= '"+e+"'", null);
        do {
                /*String s1 = cursor.getString(cursor.getColumnIndex("name"));
                String s2 = cursor.getString(cursor.getColumnIndex("surname"));
                String s3 = cursor.getString(cursor.getColumnIndex("email"));
            String s1=cursor.getString(0);
            String s2=cursor.getString(1);
            String s3=cursor.getString(2);
            String s4=s1+s2;
            t1.setText(s4);
            t2.setText(s3);

        }while (cursor.moveToNext());*/
        //t1.setText(e);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1=new Intent(ViewProfile.this,Email.class);
                startActivity(i1);
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.view_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.rules1) {
            Intent i2=new Intent(ViewProfile.this,RuleRating.class);
            startActivity(i2);
        } else if (id == R.id.rules2) {
            Intent i2=new Intent(ViewProfile.this,RuleProject.class);
            startActivity(i2);
        } else if (id == R.id.rules3) {
            Intent i2 = new Intent(ViewProfile.this,UserSignUp.class);
            startActivity(i2);
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Bundle ob=getIntent().getExtras();
            String e=ob.getString("em");
            String p=ob.getString("pass");
            String mypro=ob.getString("mypromo");
            String e3=e;
            String mypro1=mypro;
            Intent i2=new Intent(ViewProfile.this,ViewRecord.class);
            i2.putExtra("em2",e3);
            i2.putExtra("pass",p);
            i2.putExtra("mypromo",mypro1);
            startActivity(i2);
                /*(MediaPlayer mediaPlayer = null;
                if (mediaPlayer != null && mediaPlayer.isPlaying()) mediaPlayer.pause();
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                cameraUri = MediaFileUtil.getOutputMediaFileUri(MediaFileUtil.MEDIA_TYPE_IMAGE);
                intent.putExtra(MediaStore.EXTRA_OUTPUT, cameraUri);
                startActivityForResult(intent, REQ_CAMERA);*/

            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Bundle ob=getIntent().getExtras();
            String e=ob.getString("em");
            String p=ob.getString("pass");
            String mypro=ob.getString("mypromo");
            String e2=e;
            Intent i2=new Intent(ViewProfile.this,Experience.class);
            i2.putExtra("em2",e2);
            i2.putExtra("pass",p);
            i2.putExtra("mypromo",mypro);
            startActivity(i2);

        } else if (id == R.id.nav_slideshow) {
            Bundle ob=getIntent().getExtras();
            String e=ob.getString("em");
            String p=ob.getString("pass");
            String mypro=ob.getString("mypromo");
            Intent i2=new Intent(ViewProfile.this,Projects.class);
            i2.putExtra("em",e);
            i2.putExtra("pass",p);
            i2.putExtra("mypromo",mypro);
            startActivity(i2);

        } else if (id == R.id.nav_manage) {
            Bundle ob=getIntent().getExtras();
            String e=ob.getString("em");
            String p=ob.getString("pass");
            String mypro=ob.getString("mypromo");
            Intent i2=new Intent(ViewProfile.this,ViewRating.class);
            i2.putExtra("em",e);
            i2.putExtra("pass",p);
            i2.putExtra("mypromo",mypro);
            startActivity(i2);


        } else if (id == R.id.nav_share) {
            Bundle ob=getIntent().getExtras();
            String e=ob.getString("em");
            String p=ob.getString("pass");
            String mypro=ob.getString("mypromo");
            Intent i2=new Intent(ViewProfile.this,Sharep.class);
            i2.putExtra("em",e);
            i2.putExtra("pass",p);
            i2.putExtra("mypromo",mypro);
            startActivity(i2);

        } else if (id == R.id.nav_send) {
            Intent i2=new Intent(ViewProfile.this,Sharec.class);
            startActivity(i2);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
