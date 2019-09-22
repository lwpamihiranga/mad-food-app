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
import android.widget.Toast;
import android.widget.Toolbar;

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

public class ListPromotions extends AppCompatActivity {

    Toolbar tb;
    DatabaseReference dRef;
    RecyclerView recyclerView;
    ArrayList<ModelPromotions> PromoList;
    ArrayList<Add_Promotions> promotions;
    ArrayList<String> foodName;
    //ArrayList<>
    //FirebaseRecyclerAdapter adapter;
    PromotionsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_promotions);

        foodName = new ArrayList<>();
        dRef = FirebaseDatabase.getInstance().getReference();
        dRef.child("PromotionTable").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()) {
                    for (DataSnapshot ds : dataSnapshot.getChildren()) {
                        Toast.makeText(ListPromotions.this, "err", Toast.LENGTH_SHORT).show();
                        String food = ds.child("foodName").getValue(String.class);
                        foodName.add(food);
                        adapter.notifyDataSetChanged();
                    }
                } else {
                    Toast.makeText(ListPromotions.this, "No data found.", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        recyclerView = findViewById(R.id.promoRecyclerView);
        adapter = new PromotionsAdapter(getApplicationContext(), foodName);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

}