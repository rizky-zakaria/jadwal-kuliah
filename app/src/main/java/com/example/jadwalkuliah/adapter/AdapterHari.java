package com.example.jadwalkuliah.adapter;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jadwalkuliah.R;
import com.example.jadwalkuliah.fragment.ScheduleFragment;

public class AdapterHari extends RecyclerView.Adapter<AdapterHari.ViewHolder> {
    private String[] SubjectValues;
    private Context context;

    public AdapterHari(Context context1, String[] SubjectValues1) {

        SubjectValues = SubjectValues1;
        context = context1;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView hari, waktu;
        RelativeLayout klik;

        ViewHolder(View v) {

            super(v);

            hari = v.findViewById(R.id.hari);
            waktu = v.findViewById(R.id.waktu);
            klik = v.findViewById(R.id.klik);

        }
    }

    @NonNull
    @Override
    public AdapterHari.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_jadwal, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.hari.setText(SubjectValues[position]);
        holder.klik.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AppCompatActivity activity = (AppCompatActivity) v.getContext();
                String msg = SubjectValues[position];
                Bundle data = new Bundle();
                ScheduleFragment scheduleFragment = new ScheduleFragment();
                data.putString(scheduleFragment.KEY_ACTIVITY, msg);
                scheduleFragment.setArguments(data);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.container, scheduleFragment).addToBackStack(null).commit();

            }
        });
    }

    @Override
    public int getItemCount() {

        return SubjectValues.length;
    }

}
