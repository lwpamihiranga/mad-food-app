package lk.my.sliit.it18106398.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RestuarantsAdapter extends RecyclerView.Adapter<RestuarantsAdapter.myViewHolder> {

    private Context mContext;
    private ArrayList<ModelRestuarant> mList;

    public RestuarantsAdapter(Context context, ArrayList<ModelRestuarant> list) {
        mContext = context;
        mList = list;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.resturant_list, parent, false);

        myViewHolder viewHolder = new myViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        ModelRestuarant restuarants = mList.get(position);

        ImageView restuarantImage = holder.restuarant_img;
        TextView restuarantName = holder.restuarant_name;

        restuarantImage.setImageResource(mList.get(position).getImage());

        restuarantName.setText(restuarants.getName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder {
        ImageView restuarant_img;
        TextView restuarant_name;

        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            restuarant_img = itemView.findViewById(R.id.resImg);
            restuarant_name = itemView.findViewById(R.id.resName);
        }
    }
}
