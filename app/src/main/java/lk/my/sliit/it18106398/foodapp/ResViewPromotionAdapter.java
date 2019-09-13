package lk.my.sliit.it18106398.foodapp;

import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResViewPromotionAdapter extends RecyclerView.Adapter<ResViewPromotionAdapter.myViewHolder> {
    private Context mContext;
    private ArrayList<ModelViewPromotion> mList;

    public ResViewPromotionAdapter(Context mContext, ArrayList<ModelViewPromotion> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public ResViewPromotionAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View V = inflater.inflate(R.layout.restaurant_viewpromotion, parent, false);

        ResViewPromotionAdapter.myViewHolder viewHolder = new ResViewPromotionAdapter.myViewHolder(V, mContext, mList);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ResViewPromotionAdapter.myViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageButton promo_img;
        TextView promo_txt;
        Button update_promo;
        Button delete_promo;


        Context mContext;
        ArrayList<ModelViewPromotion> mList;


        public myViewHolder(@NonNull View itemView, Context context, ArrayList<ModelViewPromotion> list) {
            super(itemView);

            promo_img = itemView.findViewById(R.id.promo_image);
            promo_txt = itemView.findViewById(R.id.promo_text);
            update_promo = itemView.findViewById(R.id.btnpromo_update);
            delete_promo = itemView.findViewById(R.id.btnpromo_delete);

            itemView.setOnClickListener(this);

            mContext = context;
            mList = list;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext,Add_Promotions.class);

            intent.putExtra("button",mList.get(getAdapterPosition()).getPromoImage());

            mContext.startActivity(intent);
        }

    }
}