package com.example.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gestibank.models.Agent;
import com.example.gestibank.models.Client;
import com.example.gestibank.remote.APIUtils;
import com.example.gestibank.remote.AgentService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AjoutAgent extends AppCompatActivity {
    AgentService agentService;

    EditText name;
    EditText prenom;
    EditText matricule;
    EditText tel;
    EditText email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_agent);
        agentService = APIUtils.getAgentService();

        name = (EditText) findViewById(R.id.editNameAg);
        prenom = (EditText) findViewById(R.id.editPrenomAg);
        matricule = (EditText) findViewById(R.id.editMatriculeAg);
        email = (EditText) findViewById(R.id.editEmailAg);
        tel = (EditText) findViewById(R.id.editTelAg);
    }

    public void addAgent(View v){
        Agent agent = new Agent(
                name.getText().toString(),
                prenom.getText().toString(),
                matricule.getText().toString(),
                tel.getText().toString(),
                email.getText().toString()
        );
        Call<Agent> call = agentService.addAgents(agent);
        call.enqueue(new Callback<Agent>() {
            @Override
            public void onResponse(Call<Agent> call, Response<Agent> response) {
                if(response.isSuccessful()){
                    Toast.makeText(AjoutAgent.this, "Compte Agent créé avec succès!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Agent> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

}