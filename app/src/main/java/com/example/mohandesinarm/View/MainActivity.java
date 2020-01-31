package com.example.mohandesinarm.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.example.mohandesinarm.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    ImageView imgMenu;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();

    }

    private void setUpViews() {
        imgMenu = findViewById(R.id.img_main_menu);
        drawerLayout = findViewById(R.id.drawer);
        imgMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                drawerLayout.openDrawer(Gravity.RIGHT);
            }
        });


        NavigationView navigationView = findViewById(R.id.main_nav);
        navigationView.setNavigationItemSelectedListener(this);



    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.addi_elan:{
                Intent intent = new Intent(MainActivity.this, elan_adi.class);
                intent.putExtra("kind","اعلان عادی");
                startActivity(intent);
                break;
            }
           case R.id.monasebati_elan:{
               Intent intent = new Intent(MainActivity.this,elan_adi.class);
               intent.putExtra("kind","اعلان مناسبتی");
               startActivity(intent);
                break;
            }
            case R.id.fori_elan:{
                Intent intent = new Intent(MainActivity.this,elan_adi.class);
                intent.putExtra("kind","اعلان فوری");
                startActivity(intent);
                break;
            }
            case R.id.tej_elan:{
                Intent intent = new Intent(MainActivity.this,elan_adi.class);
                intent.putExtra("kind","اعلان تجاری");
                startActivity(intent);
                break;
            }
            case R.id.namayesh:{
                Intent intent = new Intent(MainActivity.this, namayesh_Activity.class);
                startActivity(intent);
                break;
            }


        }
        return false;
    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(Gravity.RIGHT)){
            drawerLayout.closeDrawer(Gravity.RIGHT);
        }else
            super.onBackPressed();
    }
}
