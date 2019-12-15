package com.sterrenwacht.cozmix;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class ScrollingActivityAndere extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_andere);

        //Statusbar doorzichtig maken
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnZon:
                startActivity((new Intent(this, PlanetActivity.class))
                        .putExtra("planet", "zon"));
                break;
            case R.id.btnMercurius:
                startActivity((new Intent(this, PlanetActivity.class))
                        .putExtra("planet", "mercurius"));
                break;
            case R.id.btnVenus:
                startActivity((new Intent(this, PlanetActivity.class))
                        .putExtra("planet", "venus"));
                break;
            case R.id.btnAarde:
                startActivity((new Intent(this, PlanetActivity.class))
                        .putExtra("planet", "aarde"));
                break;
            case R.id.btnMars:
                startActivity((new Intent(this, PlanetActivity.class))
                        .putExtra("planet", "mars"));
                break;
            case R.id.btnPlanetoiden:
                startActivity((new Intent(this, PlanetActivity.class))
                        .putExtra("planet", "planetoiden"));
                break;
            default:
                break;
        }
    }
}