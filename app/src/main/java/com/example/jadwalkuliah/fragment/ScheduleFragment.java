package com.example.jadwalkuliah.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jadwalkuliah.R;

public class ScheduleFragment extends Fragment {

    public static final String KEY_ACTIVITY = "msg_frag";
    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    String[] harian = {
            "Senin", "Selasa", "Rabu", "Kamis",
            "Jum'at", "Sabtu", "Minggu"
    };

    TextView view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_schedule, container, false);

        view = v.findViewById(R.id.text);

        String messages = getArguments().getString(KEY_ACTIVITY);
        if (messages.equals("Senin")){
            view.setText("Matematika Dan Bahasa Inggris");
        }else if (messages.equals("Selasa")){
            view.setText("Bahasa Indonesia Dan Logika Informatika");
        }else if (messages.equals("Rabu")){
            view.setText("BasisData Dasar");
        }else if (messages.equals("Kamis")){
            view.setText("Pemrograman Android Dasar");
        }else if (messages.equals("Jum'at")){
            view.setText("Pemrograman Web Lanjut");
        }else {
            view.setText("Hari Libur Ini Woy!!!");
        }

        return v;
    }
}