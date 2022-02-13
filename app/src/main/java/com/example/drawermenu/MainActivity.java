package com.example.drawermenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;

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

        // setting onClick listener for menu button to open drawer
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(Gravity.LEFT);   // it will open up the drawer
            }
        });
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