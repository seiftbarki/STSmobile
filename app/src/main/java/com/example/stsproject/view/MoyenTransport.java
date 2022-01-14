package com.example.stsproject.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.stsproject.R;
import com.example.stsproject.adapter.TransportAdapter;
import com.example.stsproject.model.Transport;
import com.example.stsproject.retro.ApiClient;
import com.example.stsproject.retro.ApiInterface;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoyenTransport extends AppCompatActivity {

    TextView textError;
    RecyclerView r;
    ProgressDialog pd;
    List<Transport> transportList;
    FloatingActionButton b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textError=findViewById(R.id.texterror);
        textError.setVisibility(View.INVISIBLE);
        b=findViewById(R.id.btn_add);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MoyenTransport.this ,AddActivity.class);
                startActivity(i);
            }
        });
        r=findViewById(R.id.recyler);

        r.setLayoutManager(new LinearLayoutManager(this));
        pd = new ProgressDialog(this);
        pd.setMessage("Fetching transport...");
        pd.setCancelable(false);
        pd.show();
        try{
            ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
            Call<List<Transport>> call = apiService.getTransport();
            call.enqueue(new Callback<List<Transport>>() {
                @Override
                public void onResponse(Call<List<Transport>> call, Response<List<Transport>> response) {
                    transportList=response.body();
                    TransportAdapter adapter=new TransportAdapter(MoyenTransport.this,transportList);
                    r.setAdapter(adapter);
                    r.smoothScrollToPosition(0);
                    pd.hide();
                }

                @Override
                public void onFailure(Call<List<Transport>> call, Throwable t) {
                    Log.d("TAG", "Response = " + t.toString());
                    Toast.makeText(MoyenTransport.this, "Error Fetching Data!", Toast.LENGTH_SHORT).show();
                    textError.setVisibility(View.VISIBLE);
                    pd.hide();
                }
            });

        }catch (Exception e){
            Log.d("Error", e.getMessage());
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }
}