package com.example.jadwalkuliah.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.jadwalkuliah.R;
import com.example.jadwalkuliah.SessionManager;
import com.example.jadwalkuliah.fragment.CourseFragment;
import com.example.jadwalkuliah.fragment.HomeFragment;
import com.example.jadwalkuliah.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class BaseActivity extends AppCompatActivity {
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        sessionManager = new SessionManager(BaseActivity.this);
        if(!sessionManager.isLoggedIn()){
            moveToLogin();
        }

        BottomNavigationView navigationView = findViewById(R.id.bottom);
        navigationView.setOnNavigationItemSelectedListener(selectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.container, new HomeFragment()).commit();

    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.logout:
                Toast.makeText(this, "Berhasil Logout", Toast.LENGTH_SHORT).show();
//                startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                finish();
                sessionManager.logoutSession();
                moveToLogin();
                break;
            case R.id.about:
                Toast.makeText(this, "Ini Menu Settings harusnya", Toast.LENGTH_SHORT).show();
        }

        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener selectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment fragment = null;

            switch (item.getItemId()){
                case R.id.home:
                    fragment = new HomeFragment();
                    break;
                case R.id.profile:
                    fragment = new ProfileFragment();
                    break;
                case R.id.jadwal:
                    fragment = new CourseFragment();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.container, fragment).commit();

            return true;
        }
    };

    private void moveToLogin() {
        Intent intent = new Intent(BaseActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }
}