package com.example.ericbell.naorapp;

import android.app.ProgressDialog;
import android.content.ClipData;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {
    Toolbar toolbar;
    Button btbarca;
    ProgressDialog dialog;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        btbarca =(Button) findViewById(R.id.btBarca);
        fab.setOnClickListener(fabListener);
        btbarca.setOnClickListener(barcabtlistener);




    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.menu_main, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {


            return true;
        }
        if (id == R.id.action_login) {
            if (dialog == null) {
                dialog = new ProgressDialog(this);
                dialog.setCancelable(false);
                dialog.setTitle("Logging you in");
                dialog.setMessage("Please Wait");
            }
            dialog.show();
            fab.postDelayed(new Runnable() {
                @Override
                public void run() {
                    dialog.dismiss();
                }
            }, 2000);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //fab listener

    View.OnClickListener fabListener =new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            new LoginFragment().show(getSupportFragmentManager(),"LoginFragment");
        }
    };
    View.OnClickListener barcabtlistener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent ynetIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://www.fcbarcelona.com")
            );

            startActivity(ynetIntent);

        }
    };

}
