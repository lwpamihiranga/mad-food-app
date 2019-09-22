package lk.my.sliit.it18106398.foodapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CompletedOrderActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ModelOrder> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_completed_order);

        recyclerView = findViewById(R.id.recycleVeiwCompletedOrders);

        orders = new ArrayList<>();

       // orders.add(new ModelOrder(R.drawable.friderice, "Fried Rice"));
       // orders.add(new ModelOrder(R.drawable.cheeskottu, "Cheese Kottu"));

        completedOrderAdapter adapter = new completedOrderAdapter(this, orders);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}

