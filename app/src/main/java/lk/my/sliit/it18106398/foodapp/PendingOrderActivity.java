package lk.my.sliit.it18106398.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class PendingOrderActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ModelOrder> orders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pending_order);

        recyclerView = findViewById(R.id.recycleVeiwPendingOrders);

        orders = new ArrayList<>();

        orders.add(new ModelOrder(R.drawable.friderice, "Fried Rice"));
        orders.add(new ModelOrder(R.drawable.cheeskottu, "Cheese Kottu"));

        PendingOrderAdapter adapter = new PendingOrderAdapter(this, orders);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
