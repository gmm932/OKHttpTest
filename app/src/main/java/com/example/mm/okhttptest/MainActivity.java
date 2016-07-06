package com.example.mm.okhttptest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class MainActivity extends Activity {
    private Handler mhandler;
    private final OkHttpClient client = new OkHttpClient();
    private final Gson gson = new Gson();
    private TextView tvText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvText = (TextView) findViewById(R.id.tv_text);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    execute();
                    enqueue();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        mhandler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                tvText.setText(msg.toString());
            }
        };
    }

    public void execute() throws Exception {
        Request request = new Request.Builder()
                .url("http://publicobject.com/helloworld.txt")
                .build();
        Response response = client.newCall(request).execute();
        if(response.isSuccessful()){
            System.out.println(response.code());
            System.out.println(response.body().string());
            System.out.println(response.code());
            System.out.println(response.body().string());
        }
    }

    private void enqueue(){
        Request request = new Request.Builder()
                .url("http://wazu.yunhomework.com/Data/GetDatabytype?id1=1&&id2=3&&id3=5&&p=1")
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
               String str =  response.body().string();
                Message msg = mhandler.obtainMessage();
                msg.obj =str;
                mhandler.sendMessage(msg);
            }
        });
    }
}
