package lk.my.sliit.it18106398.foodapp;

import android.content.Context;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
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
    private ArrayList<OrderBag1> ob;
    private int pos;
    private onItemClickListener mListener;

    public OrderAdapter(Context context, ArrayList<String> des, ArrayList<Integer> qty, ArrayList<OrderBag1>ob) {
        mContext = context;
        this.des = des;
        this.qty = qty;
        this.ob = ob;

    }
    public OrderAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.order_bag_layout, parent, false);

        myViewHolder viewHolder = new myViewHolder(v, mContext, des,qty);

        return viewHolder;
    }
    public void onBindViewHolder(myViewHolder holder, final int position) {
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

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
        ImageView order_img;
        TextView order_name;
        TextView order_qty;
        Button updateBtn;

        Context mContext;
        ArrayList<ModelOrder> mList;
        ArrayList<OrderBag1> orderBag1s;
        ArrayList<FoodItem> modelFoods;

        public myViewHolder(@NonNull View itemView, Context context, ArrayList<String> list,ArrayList<Integer> qty) {
            super(itemView);

            order_img = itemView.findViewById(R.id.foodImg);
            order_name = itemView.findViewById(R.id.foodName);
            order_qty = itemView.findViewById(R.id.qty);
            updateBtn = itemView.findViewById(R.id.updatebtn);

            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);
            updateBtn.setOnClickListener(this);

            mContext = context;
            //mList = list;
        }

        public void onClick(View view) {
            openDisplayFoodsActivity();
            if (mListener != null){
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION){
                    mListener.onItemClick(position);
                }
            }
        }

        @Override
        public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
            contextMenu.setHeaderTitle("Select Action");
            MenuItem delete = contextMenu.add(Menu.NONE, 1, 1, "Delete");

            delete.setOnMenuItemClickListener(this);
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            if (mListener != null){
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION){
                    switch (menuItem.getItemId()){
                        case 1:
                            mListener.onDeleteClick(position);
                            return true;
                    }
                }
            }
            return false;
        }

        public void openDisplayFoodsActivity(){
            Intent intent = new Intent(mContext, UpdateQuantity.class);
            intent.putExtra("des",des.get(getAdapterPosition()));
            //intent.putExtra("qty",qty.get(pos));
            mContext.startActivity(intent);
        }
    }

    public interface onItemClickListener{
        void onItemClick(int position);
        void onDeleteClick(int position);
    }

    public void setOnItemClickListener(onItemClickListener listener){
        mListener = listener;
    }
}
