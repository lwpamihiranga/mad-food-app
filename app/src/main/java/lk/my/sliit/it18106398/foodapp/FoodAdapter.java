package lk.my.sliit.it18106398.foodapp;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class FoodAdapter {

    private static  final  String TAG = "FoodAdapter";

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView imageName;
        RelativeLayout parentLayout;

        public ViewHolder(View itemview){
            super(itemview);
            image = itemview.findViewById(R.id.image);
            imageName = itemview.findViewById(R.id.image_name);
            parentLayout = itemview.findViewById(R.id.parent_layout);


        }


    }


}
