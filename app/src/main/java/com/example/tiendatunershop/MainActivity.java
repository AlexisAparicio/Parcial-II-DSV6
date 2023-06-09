package com.example.tiendatunershop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    DrawerLayout drawerlayout;
    NavigationView navigationview;
    ActionBarDrawerToggle drawertoggle;
    private EditText inp1,inp2;

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
//        String nombre=" ";
//        inp1=(EditText)findViewById(R.id.nombre_p);
//        inp1.setText(nombre);
//
//
//        nombre=getIntent().getStringExtra("nombre");
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
                        startActivity(new Intent(MainActivity.this, MainActivity.class));
//                        i.putExtra("nombre",inp1.getText().toString());
//                        i.putExtra("apellido",inp2.getText().toString());
                        Toast.makeText(MainActivity.this,"Home Selected",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.store:
                    {
                        startActivity(new Intent(MainActivity.this, Store_main.class));
                        break;
                    }
                    case R.id.about:
                    {
                        Toast.makeText(MainActivity.this,"Nosotros",Toast.LENGTH_SHORT).show();
                        break;
                    }
                    case R.id.horarios:
                    {
                        startActivity(new Intent(MainActivity.this, horario.class));
                        Toast.makeText(MainActivity.this,"Horarios",Toast.LENGTH_SHORT).show();
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

