package com.example.chirag.practicerecycle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.chirag.practicerecycle.adapter.AmenitiesAdapter;
import com.example.chirag.practicerecycle.model.Amenities;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Boolean aBoolean;

    private RecyclerView mRvResources;
    private AppCompatButton mBtSubmit;
    private ArrayList<Amenities> amenitiesArrayList = new ArrayList<>();
    private final String  resourcs[] = {"chirag","asdfas","sdfas","asdf","adsf","asdf","fds","afd","afd","afds","cow","buffalo","cat","cata","cast","catf","cgat","cbvat","sdcat","cdsat"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRvResources = (RecyclerView) findViewById(R.id.rv_amenities);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2,GridLayoutManager.VERTICAL, false);
        mRvResources.setLayoutManager(layoutManager);
        prepareData();
        AmenitiesAdapter amenitiesAdapter = new AmenitiesAdapter(this,amenitiesArrayList);
        mRvResources.setAdapter(amenitiesAdapter);






    }

    private void prepareData(){

        aBoolean=false;

        for(int i=0;i<resourcs.length;i++){
            Amenities amenities = new Amenities();

            amenities.setName(resourcs[i]);
            amenities.setActive(aBoolean);
            amenitiesArrayList.add(amenities);
        }

    }
}
