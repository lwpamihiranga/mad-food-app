package lk.my.sliit.it18106398.foodapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter_LifecycleAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FoodList extends AppCompatActivity {

    DatabaseReference reference;
    RecyclerView recyclerView;
    ArrayList<FoodItem> list;
    FoodViewHolderAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foods_list);



        recyclerView =(RecyclerView)findViewById(R.id.foodsRecycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<FoodItem>();


        reference = FirebaseDatabase.getInstance().getReference().child("Food_Items");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){

                    FoodItem F = dataSnapshot1.getValue(FoodItem.class);
                    list.add(F);
                }

                adapter = new FoodViewHolderAdapter(FoodList.this,list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //foodList = new ArrayList<>();

        //foodList.add(new Food_Items(R.drawable.friderice, "Mix Rice"));
        //foodList.add(new Food_Items(R.drawable.cheeskottu, "Cheese Kottu"));
        // foodList.add(new Food_Items(R.drawable.hoppers, "Hoppers"));
        //foodList.add(new Food_Items(R.drawable.noodles, "Noodles"));
//
        // FoodAdapter adapter = new FoodAdapter(this,foodList);

        // recyclerView.setAdapter(adapter);
        // recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
