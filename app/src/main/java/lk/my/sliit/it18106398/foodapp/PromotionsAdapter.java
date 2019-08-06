package lk.my.sliit.it18106398.foodapp;

import android.content.Context;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PromotionsAdapter extends RecyclerView.Adapter<PromotionsAdapter.myViewHolder> {
    private Context mContext;
    private ArrayList<ModelPromotions> mList;

    public PromotionsAdapter(Context mContext, ArrayList<ModelPromotions> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.list_promotions, parent, false);

        myViewHolder viewHolder = new myViewHolder(v, mContext, mList);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myViewHolder holder, int position) {
        ModelPromotions promotions = mList.get(position);

        ImageView promoImg = holder.promo_img;
        TextView promoName = holder.promo_txt;

        promoImg.setImageResource(mList.get(position).getPromoImage());
        promoName.setText(promotions.getPromoName());
    }

    @Override
    public int getItemCount() {

        return mList.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView promo_img;
        TextView promo_txt;

        Context mContext;
        ArrayList<ModelPromotions> mList;

        public myViewHolder(@NonNull View itemView, Context context, ArrayList<ModelPromotions> list) {
            super(itemView);

            promo_img = itemView.findViewById(R.id.promoImage);
            promo_txt = itemView.findViewById(R.id.promoText);

            itemView.setOnClickListener(this);

            mContext = context;
            mList = list;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(mContext,Promotion_ACTIVITY3.class);
            intent.putExtra("image",mList.get(getAdapterPosition()).getPromoImage());
            intent.putExtra("name", mList.get(getAdapterPosition()).getPromoName());

            mContext.startActivity(intent);
        }
    }
}
