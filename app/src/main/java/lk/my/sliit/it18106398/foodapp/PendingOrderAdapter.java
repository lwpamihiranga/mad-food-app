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
    private ArrayList<ModelOrder> mList;

    public PendingOrderAdapter(Context mContext, ArrayList<ModelOrder> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.pending_orders_layout, parent, false);
        return new OrderViewHolder(v, mContext);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        ModelOrder order = mList.get(position);

        ImageView orderImage = holder.order_img;
        TextView orderName = holder.order_name;

        orderImage.setImageResource(mList.get(position).getImage());

        orderName.setText(order.getName());

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class OrderViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView order_img;
        TextView order_name;
        Button acceptButton;

        Context mContext;
        public OrderViewHolder(@NonNull View itemView, Context context) {
            super(itemView);

            order_img = itemView.findViewById(R.id.foodImg);
            order_name = itemView.findViewById(R.id.foodName);
            acceptButton = itemView.findViewById(R.id.acceptbtn);

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
