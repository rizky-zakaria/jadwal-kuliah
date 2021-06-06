package com.example.jadwalkuliah.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.jadwalkuliah.R;
import com.example.jadwalkuliah.SessionManager;

public class MainActivity extends AppCompatActivity {

    EditText pass, user;
    Button masuk;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        sessionManager = new SessionManager(MainActivity.this);
        if(sessionManager.isLoggedIn()){
              moveToDashboar();
        }

        pass = findViewById(R.id.password);
        user = findViewById(R.id.username);
        masuk = findViewById(R.id.masuk);

        masuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = user.getText().toString();
                String password = pass.getText().toString();
//                Toast.makeText(getApplicationContext(), user.getText().toString() + " " + pass.getText().toString(), Toast.LENGTH_SHORT).show();
                if (username.isEmpty()){
                    user.setError("Field ini harus diisi");
                }else if (password.isEmpty()){
                    pass.setError("Field ini harus diisi");
                }else {
                    if (username.equals("apipa")){
                        if (password.equals("123456")){

                            // Ini untuk menyimpan sesi
                            sessionManager = new SessionManager(MainActivity.this);
                            sessionManager.createLoginSession(username);

                            startActivity(new Intent(getApplicationContext(), BaseActivity.class));
                            finish();
                        }else {
                            Toast.makeText(getApplicationContext(), "Password yg anda masukan salah", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(getApplicationContext(), "Username yg anda masukan salah", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    private void moveToDashboar() {
        Intent intent = new Intent(MainActivity.this, BaseActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivity(intent);
        finish();
    }

}