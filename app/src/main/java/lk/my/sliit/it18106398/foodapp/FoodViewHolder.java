package lk.my.sliit.it18106398.foodapp;

import android.view.TextureView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


    public TextView textFoodName;
    public ImageView imageView;

    private ItemClickListener itemClickListener;

    public FoodViewHolder(View itemview){
        super(itemview);

        textFoodName = (TextView) itemview.findViewById(R.id.foodName);
        imageView = (ImageView)itemview.findViewById(R.id.foodImg);

        itemview.setOnClickListener(this);

    }
    public void setItemClickListner(ItemClickListener itemClickListner){
        this.itemClickListener = itemClickListner;
    }


    @Override
    public void onClick(View view) {

        itemClickListener.onClick(view,getAdapterPosition(),false);
    }
}
