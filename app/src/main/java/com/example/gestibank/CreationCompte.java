package com.example.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.example.gestibank.models.Client;
import com.example.gestibank.remote.APIUtils;
import com.example.gestibank.remote.ClientService;


public class CreationCompte extends AppCompatActivity {
    ClientService clientService;
    List<Client> list;

    EditText name;
    EditText prenom;
    EditText email;
    EditText tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creationcompte);
        clientService = APIUtils.getClientService();

        name = (EditText) findViewById(R.id.editName);
        prenom = (EditText) findViewById(R.id.editPrenom);
        email = (EditText) findViewById(R.id.editEmail);
        tel = (EditText) findViewById(R.id.editTel);
    }

    public void addNewClient(View v){
        //Toast.makeText(creationcompte.this, "Client created successfully!", Toast.LENGTH_SHORT).show();

        Client client= new Client(name.getText().toString(),prenom.getText().toString(),email.getText().toString(),tel.getText().toString());
       //Log.i("info",client.toString());

        //showMessage("info",client.toString());

        Call<Client> call = clientService.addClient(client);
        call.enqueue(new Callback<Client>() {
            @Override
            public void onResponse(Call<Client> call, Response<Client> response) {
                if(response.isSuccessful()){
                    Toast.makeText(CreationCompte.this, "Client ajouté avec succès!", Toast.LENGTH_SHORT).show();
                }}
            @Override
            public void onFailure(Call<Client> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    public void getClientsList(View v){
        Call<List<Client>> call = clientService.getClients();
        call.enqueue(new Callback<List<Client>>() {
            @Override
            public void onResponse(Call<List<Client>> call, Response<List<Client>> response) {
                if(response.isSuccessful()){
                    list = response.body();
                    Log.i("Data: ", list.toString());

                    StringBuffer buffer=new StringBuffer();
                    for (Client user : list)
                    {

                        buffer.append("Name: "+user.getName()+"\n");
                        buffer.append("Email: "+user.getEmail()+"\n\n");

                    }
                    showMessage("Clients List", buffer.toString());

                    // listView.setAdapter(new UserAdapter(MainActivity.this, R.layout.list_user, list));
                }
            }

            @Override
            public void onFailure(Call<List<Client>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }


    public void showMessage(String title,String message)
    {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }



    public void callauthentification(View view) {
        Intent i = new Intent(getApplicationContext(), Authentification.class);
        startActivity(i);
    }
}




