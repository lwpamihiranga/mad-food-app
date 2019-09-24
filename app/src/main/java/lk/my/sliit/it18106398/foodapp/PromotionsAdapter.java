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

public class PromotionsAdapter extends RecyclerView.Adapter<PromotionsAdapter.myViewHolder> {
    private Context mContext;
    private ArrayList<String> name;
    private ArrayList<String> key;
    //private ArrayList<ModelPromotions> mList;

    public PromotionsAdapter(Context Context, ArrayList<String> name, ArrayList<String> key) {
        mContext = Context;
        this.name = name;
        this.key = key;
    }

    public PromotionsAdapter.myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.list_promotions, parent, false);

        myViewHolder viewHolder = new myViewHolder(v,mContext,name, key);
        return viewHolder;
    }
    public void onBindViewHolder(myViewHolder holder, int position) {
        //ModelOrder order = mList.get(position);

        ImageView promoImg = holder.promo_img;
        TextView promoName = holder.promo_txt;
        TextView keys = holder.key;

        //orderImage.setImageResource(mList.get(position).getImage());

        promoName.setText(name.get(position));
        keys.setText(key.get(position));

    }
    String pName;
    String myKey;
    @Override
    public int getItemCount() {

        return name.size();
    }
    public class myViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView promo_img;
        TextView promo_txt;
        TextView key;

        Context mContext;
        ArrayList<ModelPromotions> mList;



        public myViewHolder(@NonNull View itemView, Context context, ArrayList<String> strings, ArrayList<String> name) {
            super(itemView);

            promo_img = itemView.findViewById(R.id.promoImage);
            promo_txt = itemView.findViewById(R.id.promoText);
            key = itemView.findViewById(R.id.textView7);
//            pName = "test";

            itemView.setOnClickListener(this);
            pName = promo_txt.getText().toString();
            myKey = key.getText().toString();
            mContext = context;
            //mList = list;
        }

        public void onClick(View view) {
            Intent intent = new Intent(mContext,Promotion_ACTIVITY3.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            TextView text = view.findViewById(R.id.promoText);
            pName = text.getText().toString();
            TextView text1 = view.findViewById(R.id.textView7);
            myKey = key.getText().toString();
            //intent.putExtra("image",mList.get(getAdapterPosition()).getPromoImage());
//            intent.putExtra("pName", mList.get(getAdapterPosition()).getPromoName());
            intent.putExtra("pName", pName);
            intent.putExtra("key", myKey);

            mContext.startActivity(intent);
        }
    }
}