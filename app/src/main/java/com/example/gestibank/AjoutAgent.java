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
    List<Agent> list = new ArrayList<>();

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

    public void getAgentList(View v){
        Call<List<Agent>> call = agentService.getAgents();
        call.enqueue(new Callback<List<Agent>>() {
            @Override
            public void onResponse(Call<List<Agent>> call, Response<List<Agent>> response) {
                if(response.isSuccessful()){
                    list = response.body();
                    Log.i("Data: ", list.toString());

                    StringBuffer buffer=new StringBuffer();
                    for (Agent user : list)
                    {

                        buffer.append("Name: "+user.getName()+"\n");
                        buffer.append("Prenom: "+user.getPrenom()+"\n");
                        buffer.append("Matricule: "+user.getMatricule()+"\n\n");
                        buffer.append("Email: "+user.getEmail()+"\n\n");
                        buffer.append("Password: "+user.getPassword()+"\n");
                        buffer.append("Tel:"+user.getTel()+"\n");
                        buffer.append("Role:"+user.getRole()+"\n");


                    }
                    showMessage("Agents List", buffer.toString());

                    // listView.setAdapter(new UserAdapter(MainActivity.this, R.layout.list_user, list));
                }
            }

            @Override
            public void onFailure(Call<List<Agent>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }


    public void showMessage(String title,String message)
    {
        android.app.AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }

}




