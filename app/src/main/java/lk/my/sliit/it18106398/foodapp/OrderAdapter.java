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

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.myViewHolder> {
    private Context mContext;
    private ArrayList<String> des;
    private ArrayList<Integer> qty;
    int pos;

    public OrderAdapter(Context context, ArrayList<String> des, ArrayList<Integer> qty) {
        mContext = context;
        this.des = des;
        this.qty = qty;

    }
    public OrderAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.order_bag_layout, parent, false);

        myViewHolder viewHolder = new myViewHolder(v, mContext, des,qty);

        return viewHolder;
    }
    public void onBindViewHolder(myViewHolder holder, int position) {
        //ModelOrder order = mList.get(position);

        ImageView orderImage = holder.order_img;
        TextView orderName = holder.order_name;
        TextView quantity = holder.order_qty;
        pos = position;

        //orderImage.setImageResource(mList.get(position).getImage());

        orderName.setText(des.get(position));
        quantity.setText("" +qty.get(position));
    }
    public int getItemCount() {
        return des.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView order_img;
        TextView order_name;
        TextView order_qty;
        Button updateBtn;

        Context mContext;
        ArrayList<ModelOrder> mList;
        ArrayList<OrderBag1> orderBag1s;
        ArrayList<Food_Items> modelFoods;

        public myViewHolder(@NonNull View itemView, Context context, ArrayList<String> list,ArrayList<Integer> qty) {
            super(itemView);

            order_img = itemView.findViewById(R.id.foodImg);
            order_name = itemView.findViewById(R.id.foodName);
            order_qty = itemView.findViewById(R.id.qty);
            updateBtn = itemView.findViewById(R.id.updatebtn);

//            itemView.setOnClickListener(this);
            updateBtn.setOnClickListener(this);

            mContext = context;
            //mList = list;
        }

        public void onClick(View view) {
            //Intent intent = new Intent(mContext, DisplayFoodsActivity.class);
            openDisplayFoodsActivity();

            //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //intent.putExtra("image_id", mList.get(getAdapterPosition()).getImage());
            //intent.putExtra("order_name", mList.get(getAdapterPosition()).getName());
            ///intent.putExtra("order_qty", mList.get(getAdapterPosition()).getQuantity());

            //mContext.startActivity(intent);
        }

        public void openDisplayFoodsActivity(){
            Intent intent = new Intent(mContext, DisplayFoodsActivity.class);
            intent.putExtra("qty",qty.get(pos));
            mContext.startActivity(intent);
        }

    }
}
