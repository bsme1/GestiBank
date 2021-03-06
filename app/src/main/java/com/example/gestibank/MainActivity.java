package com.example.gestibank;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void callcreationcompte(View view) {
        Intent i = new Intent(getApplicationContext(), CreationCompte.class);
        startActivity(i);
    }

    public void callconversion(View view) {
        Intent i = new Intent(getApplicationContext(), Currency_Activity.class);
        startActivity(i);
    }

    public void callauthentification(View view) {
        Intent i = new Intent(getApplicationContext(), Authentification.class);
        startActivity(i);
    }
}