package com.sterrenwacht.cozmix;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class ScrollingActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Status bar doorzichtbaar maken //////////////////////////////////////////////////////////////////////////////////////////

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        //logo knop die doorverwijst naar de website ////////////////////////////////////////////////////////////////////////////////

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabHome);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String site = "http://www.cozmix.be";
                Uri webadress = Uri.parse(site);
                Intent goWebSite = new Intent(Intent.ACTION_VIEW, webadress);
                if (goWebSite.resolveActivity(getPackageManager())!=null);{
                    startActivity(goWebSite);
                }
            }
        });

        //Knoppen die doorverwijzen naar de planeet paginas /////////////////////////////////////////////////////////////////////

        final Button btnIjs = (Button)findViewById(R.id.btnIjs);
        Button btnJupiter = (Button)findViewById(R.id.btnJupiter);
        Button btnNeptunus = (Button)findViewById(R.id.btnNeptunus);
        Button btnPluto = (Button)findViewById(R.id.btnPluto);
        Button btnSaturnus = (Button)findViewById(R.id.btnSaturnus);
        Button btnUranus = (Button)findViewById(R.id.btnUranus);
        Button btnRest = (Button)findViewById(R.id.btnRest);

        btnIjs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollingActivity.this, planeetIjsdwergen.class));
            }
        });
        btnPluto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollingActivity.this, planeetPluto.class));
            }
        });
        btnNeptunus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollingActivity.this, planeetNeptunus.class));
            }
        });
        btnUranus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollingActivity.this, planeetUranus.class));
            }
        });
        btnSaturnus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollingActivity.this, planeetSaturnus.class));
            }
        });
        btnJupiter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollingActivity.this, planeetJupiter.class));
            }
        });

        btnRest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollingActivity.this, ScrollingActivityAndere.class));
            }
        });


    }
}
