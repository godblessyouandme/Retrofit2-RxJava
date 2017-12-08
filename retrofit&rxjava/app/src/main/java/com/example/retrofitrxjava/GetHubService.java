package com.example.retrofitrxjava;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

/**
 * Created by Administrator on 2017/12/8.
 */

public interface GetHubService {

    @GET("/")
    Call<NetRespond> respServiers();

}
