package com.example.android2_4_retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("api/facts")
    Call<Fact> getFact();
}
