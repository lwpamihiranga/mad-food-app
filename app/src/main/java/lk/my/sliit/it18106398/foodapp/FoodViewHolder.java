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

 class FoodViewHolderAdapter extends RecyclerView.Adapter<FoodViewHolderAdapter.FoodViewHolder> {

    Context context;
    ArrayList<FoodItem> FoodTable;

    public FoodViewHolderAdapter(Context c, ArrayList<FoodItem> F){
        context = c;
        FoodTable = F;

    }

    @NonNull
    @Override
    public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FoodViewHolder(LayoutInflater.from(context).inflate(R.layout.food_list,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
            holder.name.setText(FoodTable.get(position).getName());
        //Picasso.get().load(Food_Items.get(position).getImage().into(holder.Image));


    }

    @Override
    public int getItemCount() {
        return FoodTable.size();
    }


    class FoodViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView name;
        ImageView image;

        Context mContext;
        String fName;
        public FoodViewHolder(View itemview) {
            super(itemview);

            name = (TextView)itemview.findViewById(R.id.name);
            image = (ImageView)itemview.findViewById(R.id.image);

            itemView.setOnClickListener(this);

            mContext = context;
//            fName = name.getText().toString();
           // itemview.setOnClickListener(new View.OnClickListener() {
           //     @Override
            //   public void onClick(View view) {
              //      Intent displapfood = new Intent(this, DisplayFoodsActivity.class);


                }

        @Override
        public void onClick(View view) {
            TextView foodName = view.findViewById(R.id.name);
            fName = foodName.getText().toString();
            Intent intent = new Intent(mContext, DisplayFoodsActivity.class);
            intent.putExtra("fName", fName);
            mContext.startActivity(intent);
        }
        //});
    }
}
 //}

//
//     public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//         return new FoodViewHolder(LayoutInflater.from(context).inflate(R.layout.food_list,parent,false));
//     }