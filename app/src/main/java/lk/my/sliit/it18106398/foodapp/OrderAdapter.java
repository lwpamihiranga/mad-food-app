package lk.my.sliit.it18106398.foodapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.myViewHolder> {
    private Context mContext;
    private ArrayList<ModelOrder> mList;

    public OrderAdapter(Context context, ArrayList<ModelOrder> list) {
        mContext = context;
        mList = list;
    }
    public OrderAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.resturant_list, parent, false);

        myViewHolder viewHolder = new myViewHolder(v, mContext, mList);

        return viewHolder;
    }
    public void onBindViewHolder(myViewHolder holder, int position) {
        ModelOrder order = mList.get(position);

        ImageView orderImage = holder.order_img;
        TextView orderName = holder.order_name;

        orderImage.setImageResource(mList.get(position).getImage());

        orderName.setText(order.getName());
    }
    public int getItemCount() {
        return mList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView order_img;
        TextView order_name;

        Context mContext;
        ArrayList<ModelOrder> mList;

        public myViewHolder(@NonNull View itemView, Context context, ArrayList<ModelOrder> list) {
            super(itemView);

            order_img = itemView.findViewById(R.id.foodImg);
            order_name = itemView.findViewById(R.id.foodName);

            itemView.setOnClickListener(this);

            mContext = context;
            mList = list;
        }

        public void onClick(View view) {
            Intent intent = new Intent(mContext, DisplayRestaurantsActivity.class);
            intent.putExtra("image_id", mList.get(getAdapterPosition()).getImage());
            intent.putExtra("order_name", mList.get(getAdapterPosition()).getName());

            mContext.startActivity(intent);
        }
    }
}
