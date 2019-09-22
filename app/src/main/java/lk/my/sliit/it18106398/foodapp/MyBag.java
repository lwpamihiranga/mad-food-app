package lk.my.sliit.it18106398.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MyBag extends AppCompatActivity {

    RecyclerView recyclerView;
    //ArrayList<ModelOrder> orderList;
    ArrayList<OrderBag1> orderList;
    ArrayList<String> description;
    ArrayList<Integer>qty;

    OrderAdapter adapter;
    Button btnUpdate;
    DatabaseReference db;

    /*public void openDisplayFoodActivity(){
        Intent intent = new Intent(this, DisplayFoodsActivity.class);
        startActivity(intent);
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bag);
        description = new ArrayList<>();
        qty = new ArrayList<>();

       /* btnUpdate = (Button) findViewById(R.id.updatebtn);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDisplayFoodActivity();
            }
        });*/

        db = FirebaseDatabase.getInstance().getReference();
        db.child("OrderBag1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists())
                {
                    for (DataSnapshot dss:dataSnapshot.getChildren())
                    {
                        //Toast.makeText(MyBag.this, "err", Toast.LENGTH_SHORT).show();
                        String desc = dss.child("description").getValue(String.class);
                        int quty = dss.child("qty").getValue(Integer.class);
                        description.add(desc);
                        qty.add(quty);
                        adapter.notifyDataSetChanged();
                    }
                }
                else
                {
                    Toast.makeText(MyBag.this, "No data found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        recyclerView = findViewById(R.id.foodsRecycleView);
        adapter = new OrderAdapter(getApplicationContext(),description,qty);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
