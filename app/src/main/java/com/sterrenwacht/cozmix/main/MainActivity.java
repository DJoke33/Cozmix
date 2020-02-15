package com.sterrenwacht.cozmix.main;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sterrenwacht.cozmix.AstronautsActivity;
import com.sterrenwacht.cozmix.planetenpad.PlanetActivity;
import com.sterrenwacht.cozmix.R;

import java.util.Objects;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,
        View.OnClickListener {

    private Bundle bundle = new Bundle();
    private String IO = "outer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,
                drawer,
                toolbar,
                R.string.nav_open_drawer,
                R.string.nav_close_drawer);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        Fragment fragment = new HomeFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.nav_host_fragment, fragment);
        ft.commit();
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Fragment fragment = null;
        Intent intent = null;

        switch (id) {
            case R.id.nav_home:
                fragment = new HomeFragment();
                break;
            case R.id.nav_planetenpad:
                fragment = new PlanetenpadFragment();
                IO = "outer";
                bundle.putString("IO", IO);
                fragment.setArguments(bundle);
                break;
            case R.id.nav_website_cozmix:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.cozmix_website)));
                break;
            case R.id.nav_feedback:
                intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:"+getString(R.string.cozmix_email_address)));
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.feedback_email_subject));
                break;
            default:
                intent = new Intent(this, MainActivity.class);
                break;
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.nav_host_fragment, fragment);
            ft.commit();
        } else {
            startActivity(intent);
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (Objects.equals(IO, "inner")) {
            Fragment fragment = new PlanetenpadFragment();
            IO = "outer";
            bundle.putString("IO", IO);
            fragment.setArguments(bundle);
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.planetenpad_host_fragment, fragment);
            ft.commit();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_manage_astronauts:
                Intent intent = new Intent(this, AstronautsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Fragment fragment = null;
        Intent intent = null;

        switch (id) {
            case R.id.btnInnerPlanets:
                fragment = new PlanetenpadFragment();
                IO = "inner";
                bundle.putString("IO", IO);
                fragment.setArguments(bundle);
                break;
            case R.id.btnZon:
                intent = new Intent(this, PlanetActivity.class);
                intent.putExtra("planet", "zon");
                break;
            case R.id.btnMercurius:
                intent = new Intent(this, PlanetActivity.class);
                intent.putExtra("planet", "mercurius");
                break;
            case R.id.btnVenus:
                intent = new Intent(this, PlanetActivity.class);
                intent.putExtra("planet", "venus");
                break;
            case R.id.btnAarde:
                intent = new Intent(this, PlanetActivity.class);
                intent.putExtra("planet", "aarde");
                break;
            case R.id.btnMars:
                intent = new Intent(this, PlanetActivity.class);
                intent.putExtra("planet", "mars");
                break;
            case R.id.btnPlanetoiden:
                intent = new Intent(this, PlanetActivity.class);
                intent.putExtra("planet", "planetoiden");
                break;
            case R.id.btnJupiter:
                intent = new Intent(this, PlanetActivity.class);
                intent.putExtra("planet", "jupiter");
                break;
            case R.id.btnSaturnus:
                intent = new Intent(this, PlanetActivity.class);
                intent.putExtra("planet", "saturnus");
                break;
            case R.id.btnUranus:
                intent = new Intent(this, PlanetActivity.class);
                intent.putExtra("planet", "uranus");
                break;
            case R.id.btnNeptunus:
                intent = new Intent(this, PlanetActivity.class);
                intent.putExtra("planet", "neptunus");
                break;
            case R.id.btnPluto:
                intent = new Intent(this, PlanetActivity.class);
                intent.putExtra("planet", "pluto");
                break;
            case R.id.btnIjsdwergen:
                intent = new Intent(this, PlanetActivity.class);
                intent.putExtra("planet", "ijsdwergen");
                break;
            default:
                break;
        }

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.planetenpad_host_fragment, fragment);
            ft.commit();
        } else {
            startActivity(intent);
        }
    }
}