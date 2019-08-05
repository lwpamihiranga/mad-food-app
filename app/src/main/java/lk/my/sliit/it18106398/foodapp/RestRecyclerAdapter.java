package lk.my.sliit.it18106398.foodapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RestRecyclerAdapter extends RecyclerView.Adapter<RestRecyclerAdapter.RestViewHolder>    {
    private List<String> list;

    public RestRecyclerAdapter(List<String> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public RestViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        TextView textView = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.rest_view_layout, parent, false);

        RestViewHolder restViewHolder = new RestViewHolder(textView);

        return restViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestViewHolder holder, int position) {
        holder.restName.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class RestViewHolder extends RecyclerView.ViewHolder {
        TextView restName;

        public RestViewHolder(@NonNull TextView itemView) {
            super(itemView);
            restName = itemView;
        }
    }
}
