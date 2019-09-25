package lk.my.sliit.it18106398.foodapp;

import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RestuarantsAdapter extends RecyclerView.Adapter<RestuarantsAdapter.myViewHolder> implements Filterable {

    private Context mContext;
    private ArrayList<ModelRestaurant> mList;
    private ArrayList<ModelRestaurant> mListCopy;


    public RestuarantsAdapter(Context context, ArrayList<ModelRestaurant> list) {
        mContext = context;
        mList = list;
        mListCopy = new ArrayList<>(list);
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.resturant_list, parent, false);

        myViewHolder viewHolder = new myViewHolder(v, mContext, mList);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        ModelRestaurant restuarants = mList.get(position);

        ImageView restuarantImage = holder.restuarant_img;
        TextView restuarantName = holder.restuarant_name;

        restuarantImage.setImageResource(mList.get(position).getImage());

        restuarantName.setText(restuarants.getName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFiler;
    }

    private Filter exampleFiler = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence charSequence) {
            ArrayList<ModelRestaurant> filteredList = new ArrayList<>();

            if(charSequence == null || charSequence.length() == 0) {
                filteredList.add((ModelRestaurant) mListCopy);
            } else {
                String filterPattern = charSequence.toString().toLowerCase().trim();

                for(ModelRestaurant res: mListCopy) {
                    if(res.getName().toLowerCase().contains(filterPattern)) {
                        filteredList.add(res);
                    }
                }
            }
            FilterResults  results = new FilterResults();
            results.values = filteredList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            mListCopy.clear();
            mListCopy.addAll((List)filterResults.values);
            notifyDataSetChanged();
        }
    };

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView restuarant_img;
        TextView restuarant_name;

        Context mContext;
        ArrayList<ModelRestaurant> mList;

        public myViewHolder(@NonNull View itemView, Context context, ArrayList<ModelRestaurant> list) {
            super(itemView);

            restuarant_img = itemView.findViewById(R.id.foodImg);
            restuarant_name = itemView.findViewById(R.id.foodName);

            itemView.setOnClickListener(this);

            mContext = context;
            mList = list;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, DisplayRestaurantsActivity.class);
            intent.putExtra("image_id", mList.get(getAdapterPosition()).getImage());
            intent.putExtra("res_name", mList.get(getAdapterPosition()).getName());

            mContext.startActivity(intent);
        }
    }
}
