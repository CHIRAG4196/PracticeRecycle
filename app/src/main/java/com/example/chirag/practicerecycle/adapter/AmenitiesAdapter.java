package com.example.chirag.practicerecycle.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import com.example.chirag.practicerecycle.R;
import com.example.chirag.practicerecycle.model.Amenities;

import java.util.ArrayList;

/**
 * Created by chirag on 01-Jun-17.
 */

public class AmenitiesAdapter extends RecyclerView.Adapter<AmenitiesAdapter.AmenitiesViewHolder> {

   private Context context;
    private ArrayList<Amenities> amenitiesArrayList;

    public AmenitiesAdapter(Context context, ArrayList<Amenities> amenitiesArrayList) {
        this.context = context;
        this.amenitiesArrayList = amenitiesArrayList;
    }


    @Override
    public AmenitiesAdapter.AmenitiesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_resources,parent,false);
        return new AmenitiesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final AmenitiesAdapter.AmenitiesViewHolder holder, final int position) {
        final Amenities amenities = this.amenitiesArrayList.get(position);
        holder.mTvAmenities.setText(amenities.getName());
        holder.mTbResources.setChecked(amenities.getActive());
        holder.mTbResources.setTag(position);
        holder.mTbResources.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    amenities.setActive(true);
                    holder.mLl.setBackgroundColor(Color.WHITE);
                }
                else {

                    amenities.setActive(false);
                    holder.mLl.setBackgroundColor(Color.CYAN);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return amenitiesArrayList.size();
    }

    public class AmenitiesViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView mTvAmenities,mTvBoolean;
        private ToggleButton mTbResources;
        private LinearLayout mLl;
        public AmenitiesViewHolder(View itemView) {
            super(itemView);
            mTvAmenities = (AppCompatTextView) itemView.findViewById(R.id.tv_amenities);
            mTbResources = (ToggleButton) itemView.findViewById(R.id.tb_resources);
            mLl = (LinearLayout) itemView.findViewById(R.id.ll);
            mTvBoolean = (AppCompatTextView) itemView.findViewById(R.id.tv_boolean);
        }
    }
}
