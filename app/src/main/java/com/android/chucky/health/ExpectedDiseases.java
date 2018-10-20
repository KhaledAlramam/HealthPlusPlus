package com.android.chucky.health;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.android.chucky.health.DiseaseAdapter;
import com.android.chucky.health.R;
import com.android.chucky.health.model.DataService;
import com.android.chucky.health.model.Disease;
import com.android.chucky.health.model.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ExpectedDiseases extends AppCompatActivity {


    private List<Disease> diseaseList ;
    @BindView(R.id.recycler_view)RecyclerView recyclerView;
    private DiseaseAdapter mAdapter;

    @BindView(R.id.no_data)
    RelativeLayout relativeLayout;

    Intent callerIntent;
    double latitude,longitude;
    String token;
    SharedPreferences sharedPreferences;
    RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excpected_diseases);
        ButterKnife.bind(this);
        sharedPreferences=getSharedPreferences("myPrefs",MODE_PRIVATE);
        token=sharedPreferences.getString("token",null);
        callerIntent= this.getIntent();
        latitude = callerIntent.getDoubleExtra("lat",0);
        longitude = callerIntent.getDoubleExtra("lang",0);
        mAdapter = new DiseaseAdapter(this);
        mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        getData();
    }

    private void getData(){
        DataService service = RetrofitInstance.getRetrofitInstance().create(DataService.class);
        Call<List<Disease>> diseaseCall=service.getPossibleDisease(token,latitude,longitude);
        diseaseCall.enqueue(new Callback<List<Disease>>() {
            @Override
            public void onResponse(Call<List<Disease>> call, Response<List<Disease>> response) {
                diseaseList = response.body();
                if (diseaseList == null || diseaseList.size()<1){
                    recyclerView.setVisibility(View.GONE);
                    relativeLayout.setVisibility(View.VISIBLE);
                }else{
                    recyclerView.setVisibility(View.VISIBLE);
                    relativeLayout.setVisibility(View.GONE);
                    updateUi();
                }

            }

            @Override
            public void onFailure(Call<List<Disease>> call, Throwable t) {
                Toast.makeText(ExpectedDiseases.this, "Sorry for interruption, but something wrong happened", Toast.LENGTH_SHORT).show();
            }
        });
    }
    private void updateUi(){
        mAdapter.setDiseasesList(diseaseList);
        mAdapter.notifyDataSetChanged();
    }
}
