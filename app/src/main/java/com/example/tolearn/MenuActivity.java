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
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.tolearn.fragments.ProfileFragment;
import com.example.tolearn.pojos.User;
import com.google.android.material.navigation.NavigationView;


public class MenuActivity extends AppCompatActivity {


    private ActionBarDrawerToggle toggle;
    private AppBarConfiguration appBarConfiguration;
    private NavController navController;
    private ProfileFragment profileFragment;
    private TextView tvUsername;
    private static User user;

    public static User getUser() {
        return user;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        DrawerLayout drawerLayout = (DrawerLayout)findViewById(R.id.drawer);
        NavigationView navigationView=findViewById(R.id.nav_view);

        toggle = new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);

        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle bundle = getIntent().getExtras();
        user = (User) bundle.get("user");
        Log.d("usuario",user.getLogin());


        appBarConfiguration= new AppBarConfiguration.Builder(R.id.nav_profile,
                R.id.nav_checkUsers,R.id.nav_companyAdmin,
                R.id.nav_departmentAdmin,R.id.nav_areaAdmin,
                R.id.nav_pdf,
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
