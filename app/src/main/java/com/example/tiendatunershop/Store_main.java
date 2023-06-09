package com.example.tiendatunershop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class Store_main extends AppCompatActivity {
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
        setContentView(R.layout.activity_store_main);

        drawerlayout = findViewById(R.id.drawer_layout);
        navigationview=findViewById(R.id.nav_view);
        drawertoggle=new ActionBarDrawerToggle(this,drawerlayout,R.string.open,R.string.close);
        drawerlayout.addDrawerListener(drawertoggle);
        drawertoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                switch (id)
                {
                    case R.id.home:
                    {
                        startActivity(new Intent(Store_main.this, MainActivity.class));
                        Toast.makeText(Store_main.this,"Home Selected",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.store:
                    {
                        startActivity(new Intent(Store_main.this, Store_main.class));
                        break;
                    }
                    case R.id.about:
                    {
                        Toast.makeText(Store_main.this,"Nosotros",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.horarios:
                    {
                        startActivity(new Intent(Store_main.this, horario.class));
                        Toast.makeText(Store_main.this,"Horarios",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.exit:
                    {
                        finish();
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

