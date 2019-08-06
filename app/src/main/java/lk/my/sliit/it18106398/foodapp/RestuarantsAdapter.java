package lk.my.sliit.it18106398.foodapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
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

        myViewHolder viewHolder = new myViewHolder(v, mContext, mList);

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

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView restuarant_img;
        TextView restuarant_name;

        Context mContext;
        ArrayList<ModelRestuarant> mList;

        public myViewHolder(@NonNull View itemView, Context context, ArrayList<ModelRestuarant> list) {
            super(itemView);

            restuarant_img = itemView.findViewById(R.id.resImg);
            restuarant_name = itemView.findViewById(R.id.resName);

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
