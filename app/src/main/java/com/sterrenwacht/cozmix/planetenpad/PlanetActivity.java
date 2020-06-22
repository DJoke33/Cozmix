package com.sterrenwacht.cozmix.planetenpad;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;

import com.sterrenwacht.cozmix.R;
import com.sterrenwacht.cozmix.helper.StringHelper;

public class PlanetActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);

        // enable toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // enable up button
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        // enable bottom navigation panel
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        // get planet name from intent and fill bundle to pass to fragments
        String planetName = getIntent().getStringExtra("planet");
        bundle.putString("planet", planetName);

        // set activity title
        setTitle(StringHelper.capitalise(planetName));

//        // set background image
//        ((ImageView)findViewById(R.id.planet_background))
//                .setImageResource(getResources().getIdentifier(
//                                 planetName+"_background",
//                                "drawable",
//                                getPackageName()
//                        )
//                );

        // fill planet fragment
        if (savedInstanceState == null) {
            Fragment fragment = new PlanetHomeFragment();
            fragment.setArguments(bundle);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.planet_container, fragment);
            ft.commit();
        }
    }

    private void ReplaceFragment(Fragment fragment){
        if (fragment != null){
            fragment.setArguments(bundle);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.planet_container, fragment)
                    .commit();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        Fragment fragment = null;

        switch (menuItem.getItemId()) {
            case R.id.navigation_home:
                fragment = new PlanetHomeFragment();
                break;
            case R.id.navigation_zwaarte:
                fragment = new PlanetWeightFragment();
                break;
            case R.id.navigation_weetjes:
                fragment = new PlanetTriviaFragment();
                break;
        }

        if (fragment != null) {
            ReplaceFragment(fragment);
        }

        return true;
    }
}