package com.example.gestibank.remote;

import com.example.gestibank.models.Agent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AgentService {
    @GET("/agents/list/")
    Call<List<Agent>> getAgents();

    @POST("agents/add/")
    Call<Agent> addAgents(@Body Agent agent);
}

