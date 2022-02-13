package com.example.drawermenu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
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
        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_baseline_dehaze_24);
            getSupportActionBar().setTitle("The Drawer");
        }
    }

    @Override  // override this method to infate the option menu
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override  // not checking which item is clicked as main menu have only one
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this,"added to favorite",Toast.LENGTH_SHORT).show();
        return true;
    }
}