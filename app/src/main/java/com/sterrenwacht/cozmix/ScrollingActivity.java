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

public class ScrollingActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_old);
        setSupportActionBar(toolbar);

        //Statusbar doorzichtig maken
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        // TODO: url cozmix elders plaatsen + FAB wissen of vervangen door iets beters
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
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnInnerPlanets:
                startActivity((new Intent(this, ScrollingActivityAndere.class)));
                break;
            case R.id.btnJupiter:
                startActivity((new Intent(this, PlanetActivity.class))
                        .putExtra("planet", "jupiter"));
                break;
            case R.id.btnSaturnus:
                startActivity((new Intent(this, PlanetActivity.class))
                        .putExtra("planet", "saturnus"));
                break;
            case R.id.btnUranus:
                startActivity((new Intent(this, PlanetActivity.class))
                        .putExtra("planet", "uranus"));
                break;
            case R.id.btnNeptunus:
                startActivity((new Intent(this, PlanetActivity.class))
                        .putExtra("planet", "neptunus"));
                break;
            case R.id.btnPluto:
                startActivity((new Intent(this, PlanetActivity.class))
                        .putExtra("planet", "pluto"));
                break;
            case R.id.btnIjsdwergen:
                startActivity((new Intent(this, PlanetActivity.class))
                        .putExtra("planet", "ijsdwergen"));
                break;
            default:
                break;
        }
    }
}