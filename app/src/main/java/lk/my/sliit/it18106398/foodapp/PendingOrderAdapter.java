package lk.my.sliit.it18106398.foodapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PendingOrderAdapter extends RecyclerView.Adapter<PendingOrderAdapter.OrderViewHolder> {
    private Context mContext;
    //private ArrayList<ModelOrder> mList;
    private ArrayList<String> des;
    private ArrayList<Integer> qty;

    public PendingOrderAdapter(Context mContext, ArrayList<String> des, ArrayList<Integer> qty) {
        this.mContext = mContext;
        this.des = des;
        this.qty = qty;
    }

    @NonNull
    @Override
    public PendingOrderAdapter.OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.pending_orders_layout, parent, false);
        OrderViewHolder viewHolder = new OrderViewHolder(v, mContext,des,qty);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        //ModelOrder order = mList.get(position);

        ImageView orderImage = holder.order_img;
        TextView orderName = holder.order_name;

        //orderImage.setImageResource(mList.get(position).getImage());

        orderName.setText(des.get(position));

    }

   /* @Override
    public int getItemCount() {
        return mList.size();
    }*/
    public int getItemCount() {
        return des.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView order_img;
        TextView order_name;
        Button acceptButton;

        Context mContext;
        ArrayList<ModelOrder> mList;
        public OrderViewHolder(@NonNull View itemView, Context context, ArrayList<String> des, ArrayList<Integer> qty) {
            super(itemView);

            order_img = itemView.findViewById(R.id.foodImg);
            order_name = itemView.findViewById(R.id.foodName);
            acceptButton = itemView.findViewById(R.id.updatebtn);

            acceptButton.setOnClickListener(this);

            mContext = context;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, DeliveryPersonList.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra("image_id", mList.get(getAdapterPosition()).getImage());
            intent.putExtra("order_name", mList.get(getAdapterPosition()).getName());

            mContext.startActivity(intent);
        }
    }
}
