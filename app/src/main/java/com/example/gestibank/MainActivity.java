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
    public void callCreationCompte(View view) {
        Intent i = new Intent(getApplicationContext(), CreationCompte.class);
        startActivity(i);
    }

    public void callConversion(View view) {
        Intent i = new Intent(getApplicationContext(), Conversion.class);
        startActivity(i);
    }

    public void callAdmin(View view) {
        Intent i = new Intent(getApplicationContext(), Admin.class);
        startActivity(i);
    }
}