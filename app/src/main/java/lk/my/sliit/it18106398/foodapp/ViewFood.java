package lk.my.sliit.it18106398.foodapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ViewFood extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<FoodItem> list;
    DatabaseReference reference;
    RestViewFoodAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_food);



        recyclerView = findViewById(R.id.foodRecyclerView2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<FoodItem>();

        reference = FirebaseDatabase.getInstance().getReference().child("FoodTable");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()){

                    FoodItem F = dataSnapshot1.getValue(FoodItem.class);
                    list.add(F);
                }

                adapter = new RestViewFoodAdapter(ViewFood.this,list);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



      //  resViewfoods = new ArrayList<>();

      //  resViewfoods.add(new ModelViewFoods(R.drawable.friderice, "Mix Rice        Rs.250.00"));
       // resViewfoods.add(new ModelViewFoods(R.drawable.cheeskottu, "Cheese Kottu   Rs.350.00"));
       // resViewfoods.add(new ModelViewFoods(R.drawable.hoppers, "Hoppers        R.20.00"));
      //  resViewfoods.add(new ModelViewFoods(R.drawable.noodles, "Noodles     Rs.200.00"));
        //resViewfoods.add(new ModelViewFoods(R.drawable.img11, "Box-O-Noodles"));

       // RestViewFoodAdapter adapter = new RestViewFoodAdapter(this,resViewfoods);

        recyclerView.setAdapter(adapter);


    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}


