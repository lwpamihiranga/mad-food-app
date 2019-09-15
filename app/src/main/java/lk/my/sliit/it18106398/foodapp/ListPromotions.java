package lk.my.sliit.it18106398.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ListPromotions extends AppCompatActivity {

    Toolbar tb;
    DatabaseReference dRef;
    RecyclerView recyclerView;
    //ArrayList<ModelPromotions> promotions;
    //FirebaseRecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_promotions);

        dRef = FirebaseDatabase.getInstance().getReference().child("PromotionTable");
        recyclerView = findViewById(R.id.promoRecyclerView);

        DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReferenceFromUrl("https://foodappmad.firebaseio.com/PromotionTable");


        //promotions = new ArrayList<>();

        //promotions.add(new ModelPromotions(R.drawable.pic12, "Bangladesh Cuisine"));
        //promotions.add(new ModelPromotions(R.drawable.img6, "Beef Stroganoff"));
        //promotions.add(new ModelPromotions(R.drawable.img10, "Sausage mix rice"));
        //promotions.add(new ModelPromotions(R.drawable.img10, "Indean Kottu"));
        //promotions.add(new ModelPromotions(R.drawable.img11, "Box-O-Noodles"));


        /*PromotionsAdapter adapter = new PromotionsAdapter(
            this,
                String.class,
                android.R.layout.simple_list_item_1,
                databaseRef
        );*/
        //ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, promotions);

        //recyclerView.setAdapter(listAdap);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseRecyclerOptions<ModelPromotions> options =
                new FirebaseRecyclerOptions.Builder<ModelPromotions>()
                .setQuery(dRef,ModelPromotions.class)
                .build();

        FirebaseRecyclerAdapter<ModelPromotions, FindFriendViewHolder> adapter =
                new FirebaseRecyclerAdapter<ModelPromotions, FindFriendViewHolder>(options) {
                    @Override
                    protected void onBindViewHolder(@NonNull FindFriendViewHolder findFriendViewHolder, int i, @NonNull ModelPromotions modelPromotions) {
                       findFriendViewHolder.txtimage.setText(modelPromotions.getPromoName());
                       Picasso.get().load(modelPromotions.getPromoImage()).into(findFriendViewHolder.viewimage);
                    }

                    @NonNull
                    @Override
                    public FindFriendViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_promotions,parent,false);
                        FindFriendViewHolder viewHolder = new FindFriendViewHolder(view);
                        return viewHolder;
                    }
                };
        recyclerView.setAdapter(adapter);

        adapter.startListening();
    }

    public  static class  FindFriendViewHolder extends RecyclerView.ViewHolder{
            ImageView  viewimage;
            TextView txtimage;

        public FindFriendViewHolder(@NonNull View itemView) {
            super(itemView);

            txtimage = itemView.findViewById(R.id.promoImage);
            viewimage = itemView.findViewById(R.id.promoText);
        }
    }
}