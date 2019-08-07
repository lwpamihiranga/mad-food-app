package lk.my.sliit.it18106398.foodapp;

import android.content.Context;
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
    private ArrayList<ModelFood> mList;

    public FoodAdapter(Context mContex, ArrayList<ModelFood> mList) {
        this.mContex = mContex;
        this.mList = mList;
    }

    @NonNull
    @Override
    public FoodAdapter.FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContex);
        View view = inflater.inflate(R.layout.detail_listview, parent, false);

        return new FoodViewHolder(view, mContex, mList);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
        ModelFood foods = mList.get(position);

        ImageView imageView = holder.fImage;
        TextView textView = holder.fName;

        imageView.setImageResource(mList.get(position).getFoodImage());

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
        ArrayList<ModelFood> mList;

        public FoodViewHolder(@NonNull View itemView, Context context, ArrayList<ModelFood> list) {
            super(itemView);

            fImage = itemView.findViewById(R.id.image);
            fName = itemView.findViewById(R.id.image_name);

            itemView.setOnClickListener(this);

            mContext = context;
            mList = list;
        }

        @Override
        public void onClick(View view) {
//            Intent intent = new Intent(mContext, FoodGalleryMain.class);
//            intent.putExtra("image", mList.get(getAdapterPosition()));
        }
    }
}
