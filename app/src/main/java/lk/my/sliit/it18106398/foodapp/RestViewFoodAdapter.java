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

public class RestViewFoodAdapter extends RecyclerView.Adapter<RestViewFoodAdapter.myViewHolder> {


    private Context mContext;
    private ArrayList<ModelViewFoods> mList;

    public RestViewFoodAdapter(Context mContext, ArrayList<ModelViewFoods> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public RestViewFoodAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View V = inflater.inflate(R.layout.restaurant_viewpromotion, parent, false);

        RestViewFoodAdapter.myViewHolder viewHolder = new RestViewFoodAdapter.myViewHolder(V, mContext, mList);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RestViewFoodAdapter.myViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView food_img;
        TextView food_txt;
        Button update_food;
        Button delete_food;


        Context mContext;
        ArrayList<ModelViewFoods> mList;


        public myViewHolder(@NonNull View itemView, Context context, ArrayList<ModelViewFoods> list) {
            super(itemView);

            food_img = itemView.findViewById(R.id.food_image);
            food_txt = itemView.findViewById(R.id.food_text);
            update_food = itemView.findViewById(R.id.btnfood_update);
            delete_food = itemView.findViewById(R.id.btnfood_delete);

            itemView.setOnClickListener(this);

            mContext = context;
            mList = list;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, Add_Promotions.class);

            intent.putExtra("button", mList.get(getAdapterPosition()).getPromoImage());

            mContext.startActivity(intent);
        }

    }
}
