package com.android.chucky.health;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.chucky.health.model.Disease;

import java.util.List;

public class DiseaseAdapter extends RecyclerView.Adapter<DiseaseAdapter.MyViewHolder> {
    Context context;

    private List<Disease> diseasesList;

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title ,description;

        MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            description = view.findViewById(R.id.description);
        }
    }

    public DiseaseAdapter(Context context) {
        this.context = context;
    }

    public void setDiseasesList(List<Disease> diseasesList) {
        this.diseasesList = diseasesList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.disease_list_row, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Disease disease = diseasesList.get(position);
        holder.title.setText(disease.getTitle());
        holder.description.setText(disease.getDescription());
    }

    @Override
    public int getItemCount() {
        if (diseasesList != null){
            return diseasesList.size();
        }else{
            return 0;
        }

    }

}

