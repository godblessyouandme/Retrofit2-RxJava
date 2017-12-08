package com.example.retrofitrxjava;

import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author Administrator Super_Feng
 * @class 测试retrofit+rxjava的性能框架
 * @time 2017/12/7   14:48
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_sendRequest;
    private TextView tv_profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        initNet();
    }

    private void initNet() {




    }


    private void initView() {

        bt_sendRequest = (Button) findViewById(R.id.bt_sendRequest);
        tv_profile = (TextView) findViewById(R.id.tv_profile);
        bt_sendRequest.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.bt_sendRequest:

                Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl("http://www.baidu.com")
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                GetHubService getHubService = retrofit.create(GetHubService.class);
                Call<NetRespond> call = getHubService.respServiers();
                call.enqueue(new Callback<NetRespond>() {
                    @Override
                    public void onResponse(Call<NetRespond> call, Response<NetRespond> response) {
                        Logs.e("请求成功");
                    }

                    @Override
                    public void onFailure(Call<NetRespond> call, Throwable t) {
                        Logs.e("请求失败");
                    }
                });


                break;
        }

    }
}
