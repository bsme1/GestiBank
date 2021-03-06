package com.example.gestibank;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gestibank.R;
import com.example.gestibank.models.Agent;
import com.example.gestibank.remote.APIUtils;
import com.example.gestibank.remote.AgentService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListeAgents extends AppCompatActivity {

    AgentService agentService;
    List<Agent> list;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_agents);

        agentService = APIUtils.getAgentService();

        listView = findViewById(R.id.listViewAgent);

        Call<List<Agent>> call = agentService.getAgents();

        call.enqueue(new Callback<List<Agent>>() {
            @Override
            public void onResponse(Call<List<Agent>> call, Response<List<Agent>> response) {
                if(response.isSuccessful()){
                    System.out.println(response.body());
                    list = response.body();
                    listView.setAdapter(new ListeAgentAdapter(ListeAgents.this, list));
                }else {
                    System.out.println(response.code());
                }

            }
            @Override
            public void onFailure(Call<List<Agent>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });



    }


}

