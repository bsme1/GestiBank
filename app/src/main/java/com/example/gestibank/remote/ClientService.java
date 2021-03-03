package com.example.gestibank.remote;

import com.example.gestibank.models.Client;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ClientService {
    @GET("list/")
    Call<List<Client>> getClients();

    @GET("list/attente")
    Call<List<Client>> getClientsEnAttentes();

    @GET("list/valide")
    Call<List<Client>> getClientsValides();

    @POST("add/")
    Call<Client> addClient(@Body Client client);

}



