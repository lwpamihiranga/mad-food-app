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
import java.util.Objects;

public class RestViewFoodAdapter extends RecyclerView.Adapter<RestViewFoodAdapter.myViewHolder> {


    Context context;
    private ArrayList<FoodItem> FoodTable;

    public RestViewFoodAdapter(Context c, ArrayList<FoodItem> F) {
        context = c;
        FoodTable = F;
    }

    @NonNull
    @Override
    public RestViewFoodAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new myViewHolder(LayoutInflater.from(context).inflate(R.layout.restaurant_viewfood,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        holder.food_txt.setText(FoodTable.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return FoodTable.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView food_img;
        TextView food_txt;
        Button update_food;
        Button delete_food;


        Context mContext;


        public myViewHolder(View itemview) {
            super(itemview);

            food_img = itemView.findViewById(R.id.food_image);
            food_txt = itemView.findViewById(R.id.food_text);
            update_food = itemView.findViewById(R.id.btnfood_update);
            delete_food = itemView.findViewById(R.id.btnfood_delete);

            itemView.setOnClickListener(this);

            mContext = context;
            //mList = list;
        }



        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, Addfoods.class);

          //  intent.putExtra("button", mList.get(getAdapterPosition()).getImage());

            mContext.startActivity(intent);
        }

    }
}
