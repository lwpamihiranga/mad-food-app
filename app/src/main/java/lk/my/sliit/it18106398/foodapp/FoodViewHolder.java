package lk.my.sliit.it18106398.foodapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

class FoodViewHolderAdapter extends RecyclerView.Adapter<FoodViewHolderAdapter.FoodViewHolder> {

    Context context;
    ArrayList<FoodItem> Food_Items;

    public FoodViewHolderAdapter(Context c, ArrayList<FoodItem> F){
        context = c;
        Food_Items = F;

    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FoodViewHolder(LayoutInflater.from(context).inflate(R.layout.food_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
            holder.Name.setText(Food_Items.get(position).getName());
        //Picasso.get().load(Food_Items.get(position).getImage().into(holder.Image));
    }

    @Override
    public int getItemCount() {
        return Food_Items.size();
    }


    class FoodViewHolder extends RecyclerView.ViewHolder {

        TextView Name;
        ImageView Image;
        public FoodViewHolder(View itemview) {
            super(itemview);

            Name = (TextView)itemview.findViewById(R.id.Name);
            Image = (ImageView)itemview.findViewById(R.id.Image);
        }
    }
}