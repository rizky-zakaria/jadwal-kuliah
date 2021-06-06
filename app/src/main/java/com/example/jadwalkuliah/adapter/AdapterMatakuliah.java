package com.example.jadwalkuliah.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jadwalkuliah.R;

public class AdapterMatakuliah extends RecyclerView.Adapter<AdapterMatakuliah.ViewHolder> {
    private String[] SubjectValues;
    private Context context;
    private String[] Sks;

    public AdapterMatakuliah(Context context1, String[] SubjectValues1, String[] Sks1) {

        SubjectValues = SubjectValues1;
        Sks = Sks1;
        context = context1;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView matakuliah, sks;

        ViewHolder(View v) {

            super(v);

            matakuliah = v.findViewById(R.id.matakuliah);
            sks = v.findViewById(R.id.sks);
        }
    }

    @NonNull
    @Override
    public AdapterMatakuliah.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_matakuliah, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.matakuliah.setText(SubjectValues[position]);
        holder.sks.setText(Sks[position]);
    }

    @Override
    public int getItemCount() {

        return SubjectValues.length;
    }

}
