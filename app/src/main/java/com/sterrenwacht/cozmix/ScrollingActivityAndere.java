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

public class ScrollingActivityAndere extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling_andere);

        //Status bar doorzichtbaar maken //////////////////////////////////////////////////////////////////////////////////////////

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        FloatingActionButton btnTerug = (FloatingActionButton)findViewById(R.id.fabIjsdwergen);
        btnTerug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button btnPlanetoiden = (Button)findViewById(R.id.btnPlanetoiden);
        Button btnMars = (Button)findViewById(R.id.btnMars);
        Button btnAarde = (Button)findViewById(R.id.btnAarde);
        Button btnVenus = (Button)findViewById(R.id.btnVenus);
        Button btnMercurius = (Button)findViewById(R.id.btnMercurius);
        Button btnZon = (Button)findViewById(R.id.btnZon);

        btnPlanetoiden.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollingActivityAndere.this, planeetPlanetoiden.class));
            }
        });
        btnMars.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollingActivityAndere.this, planeetMars.class));
            }
        });
        btnAarde.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollingActivityAndere.this, planeetAarde.class));
            }
        });
        btnVenus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollingActivityAndere.this, planeetVenus.class));
            }
        });
        btnMercurius.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollingActivityAndere.this, planeetMercurius.class));
            }
        });
        btnZon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ScrollingActivityAndere.this, planeetZon.class));
            }
        });
    }
}
