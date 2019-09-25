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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.myViewHolder> {
    private Context mContext;
    private ArrayList<String> des;
    private ArrayList<Integer> qty;
    private int pos;

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

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView order_img;
        TextView order_name;
        TextView order_qty;
        Button updateBtn;
        Button deleteBtn;

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
            deleteBtn = itemView.findViewById(R.id.deleteBtn);

//            itemView.setOnClickListener(this);
            updateBtn.setOnClickListener(this);
            deleteBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DatabaseReference delRef = FirebaseDatabase.getInstance().getReference().child("OrderBag1");
                    delRef.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            Toast.makeText(mContext, "xxxx", Toast.LENGTH_SHORT).show();
                            if (dataSnapshot.hasChild("-LpXNGumlWRngn4stMV9")){
                                DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference().child("OrderBag1").child("-LpXNGumlWRngn4stMV9");
                                dbRef.removeValue();
                                Toast.makeText(mContext, "Data deleted successfully", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                Toast.makeText(mContext, "No source to delete", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            });

            mContext = context;
            //mList = list;
        }

        public void onClick(View view) {
            openDisplayFoodsActivity();
        }

        public void openDisplayFoodsActivity(){
            Intent intent = new Intent(mContext, UpdateQuantity.class);
            intent.putExtra("des",des.get(getAdapterPosition()));
            //intent.putExtra("qty",qty.get(pos));
            mContext.startActivity(intent);
        }
    }
}
