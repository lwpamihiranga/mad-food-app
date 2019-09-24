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

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>{

    private Context mContex;
    private ArrayList<Food_Items> mList;

    public FoodAdapter(Context mContex, ArrayList<Food_Items> mList) {
        this.mContex = mContex;
        this.mList = mList;
    }

    @NonNull
    @Override
    public FoodAdapter.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContex);
        View view = inflater.inflate(R.layout.food_list, parent, false);

        return new FoodViewHolder(view, mContex, mList);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        Food_Items foods = mList.get(position);

        ImageView imageView = holder.fImage;
        TextView textView = holder.fName;

      //  imageView.setImageResource(mList.get(position).getFoodImage());
       // Food_Items.class,R.layout.food_list,FoodViewHolder.class,food_Items;
        textView.setText(foods.getfName());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }


    public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView fImage;
        TextView fName;

        Context mContext;
        ArrayList<Food_Items> mList;

        public FoodViewHolder(@NonNull View itemView, Context context, ArrayList<Food_Items> list) {
            super(itemView);

            fImage = itemView.findViewById(R.id.foodImg);
            fName = itemView.findViewById(R.id.foodName);

            itemView.setOnClickListener(this);

            mContext = context;
            mList = list;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext, DisplayFoodsActivity.class);
            intent.putExtra("image_id", mList.get(getAdapterPosition()).getFoodImage());
            intent.putExtra("res_name", mList.get(getAdapterPosition()).getfName());

            mContext.startActivity(intent);

        }
    }
}
