package com.example.tolearn;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;


public class MenuActivity extends AppCompatActivity {


    private ActionBarDrawerToggle toggle;
    private AppBarConfiguration appBarConfiguration;
    private NavController navController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        NavigationView navigationView=findViewById(R.id.nav_view);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);

        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        appBarConfiguration= new AppBarConfiguration.Builder(R.id.nav_profile,
                R.id.nav_newArea,R.id.nav_pdf,
                R.id.nav_newDoc,R.id.nav_exit)
                .setDrawerLayout(drawerLayout).build();

        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);
        NavigationUI.setupWithNavController(navigationView,navController);

    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item){

        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController,appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}

