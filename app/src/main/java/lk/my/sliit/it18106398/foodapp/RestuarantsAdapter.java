package lk.my.sliit.it18106398.foodapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RestuarantsAdapter extends RecyclerView.Adapter {
    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.restuarant_list_card, parent, false);

        return new myViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class myViewHolder extends  RecyclerView.ViewHolder {
        ImageView restuarant_img;
        TextView restuarant_name;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            restuarant_img = itemView.findViewById(R.id.restuarantImage);
            restuarant_name = itemView.findViewById(R.id.restuarantNameTextView);
        }
    }
}
