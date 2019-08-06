package lk.my.sliit.it18106398.foodapp;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.ViewHolder>{

    private static  final  String TAG = "FoodAdapter";
    private ArrayList<String> mImageNames = new ArrayList<>();
    private ArrayList<String> mImages = new ArrayList<>();
    private Context mContex;

public FoodAdapter(Context context,ArrayList<String> imageNames, ArrayList<String> images ){
    mImageNames = imageNames;
    mImages = images;
    mContex = context;


}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_listview,parent,false);
    ViewHolder holder = new ViewHolder(view);
    return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
    Log.d(TAG,"onBindViewHolder: called." );

        Glide.with(mContex)
            .asBitmap()
            .load(mImages.get(position))
            .into(holder.image);


        holder.imageName.setText(mImageNames.get(position));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onclick: clicked on:" + mImageNames.get(position));

                Toast.makeText(mContex,mImageNames.get(position),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContex, FoodGalleryMain.class);
                intent.putExtra("images_m",mImages.get(position));
                intent.putExtra("imageNames_m",mImageNames.get(position));
                mContex.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mImageNames.size();
    }

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
