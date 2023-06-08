package com.example.tiendatunershop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerlayout;
    NavigationView navigationview;
    ActionBarDrawerToggle drawertoggle;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(drawertoggle.onOptionsItemSelected(item))
        {
             return(true);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerlayout = findViewById(R.id.drawer_layout);
        navigationview=findViewById(R.id.nav_view);
        drawertoggle=new ActionBarDrawerToggle(this,drawerlayout,R.string.open,R.string.close);
        drawerlayout.addDrawerListener(drawertoggle);
        drawertoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home:
                    {
                        Toast.makeText(MainActivity.this,"Home Selected",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.market:
                    {
                        Toast.makeText(MainActivity.this,"Market",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.ubicacion:
                    {
                        Toast.makeText(MainActivity.this,"Ubicación",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.horarios:
                    {
                        Toast.makeText(MainActivity.this,"Horarios",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.contact:
                    {
                        Toast.makeText(MainActivity.this,"Contact Selected",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.gallery:
                    {
                        Toast.makeText(MainActivity.this,"Gallery Selected",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.about:
                    {
                        Toast.makeText(MainActivity.this,"About Selected",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.login:
                    {
                        Toast.makeText(MainActivity.this,"Login Selected",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.share:
                    {
                        Toast.makeText(MainActivity.this,"Share Selected",Toast.LENGTH_SHORT).show();
                        break;
                    }

                }
                return false;
            }
        });

    }
    @Override
    public void onBackPressed() {
        if(drawerlayout.isDrawerOpen(GravityCompat.START))
        {
            drawerlayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }
}