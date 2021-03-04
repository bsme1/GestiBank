package com.example.gestibank.remote;

public class APIUtils {private APIUtils(){
};

    public static final String API_URL = "http://192.168.166.184:86/clients/";
    public static final String API_CURRENCY = "http://api.currencylayer.com/";

    public static ClientService getClientService(){
        return RetrofitClient.getClient(API_URL).create(ClientService.class);
    }

    public static AgentService getAgentService(){
        return RetrofitAgent.getAgent(API_URL).create(AgentService.class);
    }
}

