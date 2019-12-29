package com.sterrenwacht.cozmix;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ImageView;

public class PlanetActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener,
        NavigationView.OnNavigationItemSelectedListener {

    Fragment fragment = null;
    Intent intent = null;
    String planetName;
    Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet);

        // enable navigation drawer
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // enable bottom navigation panel
        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(this);

        // get planet name from intent and fill bundle to pass to fragments
        planetName = getIntent().getStringExtra("planet");
        bundle.putString("planet", planetName);

        // set background image
        ((ImageView)findViewById(R.id.planet_background))
                .setImageResource(getResources().getIdentifier(
                                 planetName+"_background",
                                "drawable",
                                getPackageName()
                        )
                );

        // fill planet fragment
        if (savedInstanceState == null) {
            fragment = new PlanetHomeFragment();
            fragment.setArguments(bundle);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.planet_container, fragment);
            ft.commit();
        }
    }

    private boolean ReplaceFragment(Fragment fragment){
        if (fragment != null){
            fragment.setArguments(bundle);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.planet_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        fragment = null;
        intent = null;

        switch (menuItem.getItemId()) {
            // navigation drawer
            /* TODO: finalise navigation drawer options */
            case R.id.nav_home:
                intent = new Intent(this, HomeActivity.class);
                break;
            case R.id.nav_planetenpad:
                intent = new Intent(this, ScrollingActivity.class);
                break;
            case R.id.nav_website_cozmix:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.cozmix_website)));
                break;
            case R.id.nav_feedback:
                intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"+getString(R.string.cozmix_email_address)));
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.feedback_email_subject));
                break;

            // bottom navigation
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
        else if (intent != null) {
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
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
}