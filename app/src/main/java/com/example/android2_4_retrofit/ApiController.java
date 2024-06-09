package com.example.android2_4_retrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiController {

    static final String BASE_URL = "https://dogapi.dog/";

    public static void fetchFact(Callback_Fact callback){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiInterface service = retrofit.create(ApiInterface.class);

        Call<Fact> call = service.getFact();
        call.enqueue(new Callback<Fact>() {
            @Override
            public void onResponse(Call<Fact> call, retrofit2.Response<Fact> response) {
                if (!response.isSuccessful()) {
                    callback.onFailure();
                    return;
                }
                Fact fact = response.body();
                callback.onResponse(fact);
            }

            @Override
            public void onFailure(Call<Fact> call, Throwable t) {
                callback.onFailure();
            }
        });
    }

    public interface Callback_Fact{
        void onResponse(Fact fact);
        void onFailure();


    }
}
