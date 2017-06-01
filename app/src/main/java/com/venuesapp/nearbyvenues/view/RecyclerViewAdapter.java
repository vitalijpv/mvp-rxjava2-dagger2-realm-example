package com.venuesapp.nearbyvenues.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.venuesapp.nearbyvenues.R;
import com.venuesapp.nearbyvenues.model.local.VenueRealm;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private ArrayList<VenueRealm> venueRealmList;


    public RecyclerViewAdapter(ArrayList<VenueRealm> venueRealmList) {
        this.venueRealmList = venueRealmList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.tvName.setText(venueRealmList.get(position).getName());
        holder.tvAddress.setText(venueRealmList.get(position).getAddress());
        holder.tvPhone.setText(venueRealmList.get(position).getFormattedPhone());
    }

    @Override
    public int getItemCount() {
        return venueRealmList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvName, tvAddress, tvPhone;

        public ViewHolder(View view) {
            super(view);

            tvName = (TextView) view.findViewById(R.id.tvName);
            tvAddress = (TextView) view.findViewById(R.id.tvAddress);
            tvPhone = (TextView) view.findViewById(R.id.tvPhone);
        }
    }
}