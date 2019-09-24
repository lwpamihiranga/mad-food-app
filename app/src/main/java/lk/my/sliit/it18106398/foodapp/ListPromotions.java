package lk.my.sliit.it18106398.foodapp;

import android.os.Bundle;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import lk.my.sliit.it18106398.foodapp.Add_Promotions;
import lk.my.sliit.it18106398.foodapp.ModelPromotions;
import lk.my.sliit.it18106398.foodapp.PromotionsAdapter;

public class ListPromotions extends AppCompatActivity {

    Toolbar tb;
    DatabaseReference dRef;
    RecyclerView recyclerView;
    ArrayList<ModelPromotions> PromoList;
    ArrayList<Add_Promotions> promotions;
    ArrayList<String> foodName;
    ArrayList<String> promoKey;
    //ArrayList<>
    //FirebaseRecyclerAdapter adapter;
    PromotionsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_promotions);

        foodName = new ArrayList<>();
        promoKey = new ArrayList<>();
        dRef = FirebaseDatabase.getInstance().getReference();

        recyclerView = findViewById(R.id.promoRecyclerView);
        adapter = new PromotionsAdapter(getApplicationContext(),foodName, promoKey);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        dRef.child("PromotionTable").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //if (dataSnapshot.exists()) {

                foodName.clear();
                promoKey.clear();

                    for (DataSnapshot ds : dataSnapshot.getChildren()) {

                        String food = ds.child("foodName").getValue(String.class);
                        String key = ds.child("description").getValue(String.class);
                        Toast.makeText(ListPromotions.this, "key"+key, Toast.LENGTH_SHORT).show();

                        foodName.add(food);
                        promoKey.add(key);
                        adapter.notifyDataSetChanged();
                    }
                //} else {
                 //   Toast.makeText(ListPromotions.this, "No data found.", Toast.LENGTH_SHORT).show();
                //}
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
       /* recyclerView = findViewById(R.id.promoRecyclerView);
        adapter = new PromotionsAdapter(getApplicationContext(),foodName, promoKey);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));*/
    }
}