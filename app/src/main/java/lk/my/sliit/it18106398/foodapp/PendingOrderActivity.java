package lk.my.sliit.it18106398.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

public class PendingOrderActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    //ArrayList<ModelOrder> orders;
    ArrayList<OrderBag1> orderList;
    ArrayList<String> description;
    ArrayList<Integer>qty;
    DisplayFoodsActivity dis;

    PendingOrderAdapter adapter;
    DatabaseReference db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_order);

        description = new ArrayList<>();
        qty = new ArrayList<>();

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
                    Toast.makeText(PendingOrderActivity.this, "No data found", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        recyclerView = findViewById(R.id.recycleVeiwPendingOrders);
        adapter = new PendingOrderAdapter(getApplicationContext(),description,qty);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
