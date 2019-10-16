package com.example.quiethours;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.libraries.places.api.model.Place;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.CustomViewHolder> {

    Context context;
    ArrayList<Place> places;

    public PlaceAdapter(Context context, ArrayList<Place> placeList) {
        this.context = context;
        places = placeList;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.place_row, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        Place place = places.get(position);
        holder.bind(place);
    }

    @Override
    public int getItemCount() {
        return places.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;

        public CustomViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);

        }

        public void bind(Place place) {
            tvName.setText(place.getName());
        }

    }

}
