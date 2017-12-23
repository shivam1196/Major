package com.example.fblogin;

import android.content.Intent;
import android.os.Bundle;
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
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainMenu extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
String profile;
String choice1 , choice2;
int Score;
String [] names ={"Shivam","Tanupriya","Shubhrika","User1","User2"};
String url ="http://10.0.2.2/majorbegin.php?name=";
String url2= "&category=";
String url3="&score=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        Bundle bundle= getIntent().getExtras();
        choice1=bundle.getString("choice1");
        choice2=bundle.getString("choice2");
        Toast.makeText(this, choice1+" "+choice2, Toast.LENGTH_SHORT).show();
        CalculateScore calculateScore = new CalculateScore(choice1,choice2);
        Score=calculateScore.finalScore();
        Toast.makeText(this, "Score is"+Score, Toast.LENGTH_SHORT).show();
        if((Score <=(-3)) && (Score >=(-15)))
        {
            String urlfinal= url+names[0]+url2+"Beginner"+url3+Score;
            UrlSend urlSend = new UrlSend();
            urlSend.execute(urlfinal);
            Toast.makeText(this, "Data Send", Toast.LENGTH_SHORT).show();
        }
        else  if((Score <=(25)) && (Score >=(10)))
        {
            String urlfinal= url+names[0]+url2+"InterMediate"+url3+Score;
            UrlSend urlSend = new UrlSend();
            urlSend.execute(urlfinal);
        }
        else if((Score <=(72)) && (Score >=(48)))
        {
            String urlfinal= url+names[0]+url2+"Expert"+url3+Score;
            UrlSend urlSend = new UrlSend();
            urlSend.execute(urlfinal);
        }
//        profile=bundle.getString("id");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        GridView gridView= (GridView)findViewById(R.id.grdView);
        MainMenuAdapter mma= new MainMenuAdapter(getApplicationContext());
        gridView.setAdapter(mma);
        ImageView userimage=(ImageView)findViewById(R.id.userpic);
        userimage.setImageResource(R.drawable.securex);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0)
                {
                    Intent intent = new Intent(getApplicationContext(),Profile.class);
                    Bundle bundle= new Bundle();
                    bundle.putString("id","Shivam");
                    bundle.putString("level","TBD");
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                if (position == 1)
                {
                    Intent intent = new Intent(getApplicationContext(),Content.class);
                    Bundle bundle= new Bundle();
                    bundle.putInt("pos",position);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                if(position==5)
                {
                    Intent intent = new Intent(getApplicationContext(),ArandAbout.class);
                    Bundle bundle= new Bundle();
                    bundle.putInt("pos",position);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
                if(position==4)
                {
                    Intent intent = new Intent(getApplicationContext(),ArandAbout.class);
                    Bundle bundle= new Bundle();
                    bundle.putInt("pos",position);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });


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
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if(id == R.id.profile)
        {
            Intent intent = new Intent(getApplicationContext(),Profile.class);
            Bundle bundle= new Bundle();
            bundle.putString("id",profile);
            intent.putExtras(bundle);
            startActivity(intent);
        }
        if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent intent = new Intent(getApplicationContext(),ArandAbout.class);
            Bundle bundle= new Bundle();
            bundle.putInt("pos",1);
            intent.putExtras(bundle);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {
            Intent intent = new Intent(getApplicationContext(),ArandAbout.class);
            Bundle bundle= new Bundle();
            bundle.putInt("pos",4);
            intent.putExtras(bundle);
            startActivity(intent);

        } else if (id == R.id.nav_aboutus) {
            Intent intent = new Intent(getApplicationContext(),ArandAbout.class);
            Bundle bundle= new Bundle();
            bundle.putInt("pos",5);
            intent.putExtras(bundle);
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
