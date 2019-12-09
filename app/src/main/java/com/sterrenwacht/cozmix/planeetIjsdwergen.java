package com.sterrenwacht.cozmix;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class planeetIjsdwergen extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planeet_ijsdwergen);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);
        LoadFragment(new planeetIjsdwergen_homeFragment());

        //transparrant maken van statues en action bar ///////////////////////////////////////////////////////////

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window w = getWindow();
            w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        }

        //Terug knop (rechtsboven) //////////////////////////////////////////////////////////////////////////////

        FloatingActionButton btnTerug = (FloatingActionButton)findViewById(R.id.fabIjsdwergen);
        btnTerug.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private boolean LoadFragment(Fragment fragment){

        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.planeetIjsdwergen_fragment_container, fragment)
                    .commit();

            return true;
        }
        return false;
    }

    //Navigatie balk voor de verschillende tabs op een planeet pagina /////////////////////////////////////////////

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch (menuItem.getItemId()){
            case R.id.navigation_home:
                fragment = new planeetIjsdwergen_homeFragment();
                break;
            case R.id.navigation_zwaarte:
                fragment = new planeetIjsdwergen_gewichtFragment();
                break;
            case R.id.navigation_algemeen_plan:
                fragment = new planeetIjsdwergen_algemeenPlanFragment();
                break;

            case R.id.navigation_algemeen_stand:
                fragment = new planeetIjsdwergen_algemeenStandFragment();
                break;

            case R.id.navigation_weetjes:
                fragment = new planeetIjsdwergen_weetjesFragment();
                break;
        }

        return LoadFragment(fragment);
    }

}
