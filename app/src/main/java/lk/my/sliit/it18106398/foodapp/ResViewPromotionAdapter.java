package lk.my.sliit.it18106398.foodapp;

import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ResViewPromotionAdapter extends RecyclerView.Adapter<ResViewPromotionAdapter.myViewHolder> {
    private Context mContext;
    //private ArrayList<ModelViewPromotion> mList;

    private ArrayList<String> promoNo;
    private ArrayList<String> namefood;
    private ArrayList<String> desc;


    public ResViewPromotionAdapter(Context context, ArrayList<String> promoNo, ArrayList<String> namefood, ArrayList<String> desc) {
        mContext = context;
        this.promoNo = promoNo;
        this.namefood = namefood;
        this.desc = desc;
    }

    public ResViewPromotionAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View V = inflater.inflate(R.layout.restaurant_viewpromotion, parent, false);

        ResViewPromotionAdapter.myViewHolder viewHolder = new ResViewPromotionAdapter.myViewHolder(V, mContext, promoNo,namefood,desc);

        return viewHolder;
    }

    public void onBindViewHolder(myViewHolder holder, int position) {
        ImageView promoImage = holder.promo_img;
        TextView promoNumber = holder.promo_text;
        TextView foodName = holder.food_txt;
    }

    @Override
    public int getItemCount() {
        return promoNo.size();
    }

    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageButton promo_img;
        TextView promonum;
        TextView food_name;
        TextView food_desc;
        Button update_promo;
        Button delete_promo;


        Context mContext;
        ArrayList<ModelViewPromotion> mList;


        public myViewHolder(@NonNull View itemView, Context context, ArrayList<ModelViewPromotion> list) {
            super(itemView);

            promo_img = itemView.findViewById(R.id.promo_image);
            promonum  = itemView.findViewById(R.id.promo_text);
            food_name = itemView.findViewById(R.id.food_txt);
            food_desc = itemView.findViewById(R.id.desc_txt);
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