package com.android.chucky.health;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.chucky.health.DiseaseAdapter;
import com.android.chucky.health.R;
import com.android.chucky.health.model.Disease;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExpectedDiseases extends AppCompatActivity {


    private List<Disease> diseaseList = new ArrayList<>();
    @BindView(R.id.recycler_view)RecyclerView recyclerView;
    private DiseaseAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excpected_diseases);
        ButterKnife.bind(this);
        mAdapter = new DiseaseAdapter(diseaseList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
    }
}
