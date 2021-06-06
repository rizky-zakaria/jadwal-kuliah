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
import com.example.jadwalkuliah.adapter.AdapterMatakuliah;


public class CourseFragment extends Fragment {


    Context context;
    RecyclerView recyclerView;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    String[] matakuliah = {
            "Bahasa Indonesia", "Bahasa Inggris", "Pemrograman Mobile Dasar", "Pemrograman Web Lanjut",
            "Ligoka Informatika", "Basisdata Lanjut", "Pemrograman Game"
    };

    String[] sks = {
            "2 SKS", "2 SKS", "3 SKS", "3 SKS", "2 SKS", "3 SKS", "3 SKS"
    };


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_course, container, false);

        context = v.getContext();
        recyclerView = v.findViewById(R.id.list);
        recylerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        recyclerViewAdapter = new AdapterMatakuliah(context, matakuliah, sks);
        recyclerView.setAdapter(recyclerViewAdapter);

        return v;
    }
}