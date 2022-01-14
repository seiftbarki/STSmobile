package com.example.stsproject.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.stsproject.R;
import com.example.stsproject.retro.ApiClient;
import com.example.stsproject.retro.ApiInterface;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddActivity extends AppCompatActivity {
    EditText e1,e2;
    Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        e1=findViewById(R.id.edit_nom);
        e2=findViewById(R.id.edit_num);


        b=findViewById(R.id.btn_adds);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nom=e1.getText().toString();
                String num=e2.getText().toString();


                if (nom.isEmpty()) {
                    e1.setError("Enter nom");
                    e1.requestFocus();
                    return;
                }
                if (num.isEmpty()) {
                    e2.setError("enter num");
                    e2.requestFocus();
                    return;
                }


                ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
                Call<ResponseBody> call=apiService.insertdata(nom,Integer.valueOf(num));
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Intent intent=new Intent (AddActivity.this,MoyenTransport.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.d("TAG", "Response = " + t.toString());
                    }
                });


            }
        });
    }
}