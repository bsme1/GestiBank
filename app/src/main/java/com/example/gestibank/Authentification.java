package com.example.gestibank;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.gestibank.models.User;
import com.example.gestibank.remote.APIUtils;
import com.example.gestibank.remote.AuthService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Authentification extends AppCompatActivity {

    AuthService authService;

    EditText email;
    EditText password;
    String myEmail="";
    String myPassword="";
    User user;
    String  role = "invalide";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentification);

    // affectation des attributs aux view

    email = (EditText) findViewById(R.id.editLogin);
    password = (EditText) findViewById(R.id.editMotdepasse);
    authService = APIUtils.getAuthService();

}

    public void dashboardUser(View v){


        myEmail = email.getText().toString();
        myPassword = password.getText().toString();

        //Toast.makeText(Login.this, "Login : "+ myEmail +" Password : "+ myPassword, Toast.LENGTH_SHORT).show();

        // récupération du user et donc de son role

        Call<User> call = authService.getUserByEmail(myEmail);

        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    user = response.body();
                    if(user!=null){
                        if(user.getEmail().equals(myEmail) && user.getPassword().equals(myPassword))
                        {
                            role = user.getRole();
                            switch(role)
                            {
                                case "AGENT" : //.... redirection vers dashboard Agent
                                    Intent intent1 = new Intent(Authentification.this, Agent.class);
                                    startActivity(intent1);
                                    break;

                                case "CLIENT" : //.... redirection vers dashboard Agent
                                    Intent intent2 = new Intent(Authentification.this, Client.class);
                                    startActivity(intent2);
                                    break;

                                case "ADMIN" : //.... redirection vers dashboard Agent
                                    Intent intent3 = new Intent(Authentification.this, Admin.class);
                                    startActivity(intent3);
                                    break;
                                default :
                            }
                        }
                        else
                        {

                            Toast.makeText(Authentification.this, "Login ou Password invalides", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else
                    {

                        Toast.makeText(Authentification.this, "Utilisateur inexistant", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
        // fin récupération

        //...


        //role =user.getRole();
        //Redirection vers le dashboard en question : Admin, Client ou Agent


    }}

