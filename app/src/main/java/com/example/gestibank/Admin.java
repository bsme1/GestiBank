package com.example.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Admin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
    }
    public void callListeDemandes(View view) {
        Intent i = new Intent(getApplicationContext(), ListeDemandes.class);
        startActivity(i);
    }

    public void callAjoutAgent(View view) {
        Intent i = new Intent(getApplicationContext(), AjoutAgent.class);
        startActivity(i);
    }
    public void callListeAgents(View view) {
        Intent i = new Intent(getApplicationContext(), ListeAgents.class);
        startActivity(i);
    }
}