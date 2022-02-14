package com.example.drawermenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referencing the toolbar
        toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);   // set title using the getSupportActionBAr

        // setting up the back button as menu option by changing it's icon
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_dehaze_24);
            getSupportActionBar().setTitle("The Drawer");
        }

        // reference the drawerLayout so we can open the drawer
        final DrawerLayout mDrawerLayout = findViewById(R.id.drawer_layout);

        // setting onClick listener for hamburgur button to open drawer
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.LEFT);   // it will open up the drawer
            }
        });

        // find out the navController
        NavController navController = Navigation.findNavController(this,R.id.nav_host_fragment);
        NavigationView navView = findViewById(R.id.nav_view);  // reference the navigation View

        // set the appBarConfiguration so that we toolbar title is changed automatically
        // here drawer menu id are same as navigation fragment and we setting this fragment top level destinations
        // so that we can call them by directly clicking on drawer items
        appBarConfiguration = new AppBarConfiguration.Builder
                                                        (R.id.home_nav,
                                                         R.id.settings_nav,
                                                         R.id.share_nav).
                                                        setDrawerLayout(mDrawerLayout).build();

        NavigationUI.setupWithNavController(navView,navController);
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);
    }

    @Override // back button in toolbar but here it is hamburger button to open drawer
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, appBarConfiguration) || super.onSupportNavigateUp();
    }

    @Override  // override this method to infate the option menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override  // not checking which item is clicked as main menu have only one
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, "added to favorite", Toast.LENGTH_SHORT).show();
        return true;
    }
}