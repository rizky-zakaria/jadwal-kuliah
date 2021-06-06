package com.example.jadwalkuliah.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jadwalkuliah.R;
import com.example.jadwalkuliah.adapter.AdapterHari;

public class HomeFragment extends Fragment {

    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    String[] harian = {
            "Senin", "Selasa", "Rabu", "Kamis",
            "Jum'at", "Sabtu", "Minggu"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        context = v.getContext();
        recyclerView = v.findViewById(R.id.list);
        recylerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerViewAdapter = new AdapterHari(context, harian);
        recyclerView.setAdapter(recyclerViewAdapter);
        return v;
    }
}