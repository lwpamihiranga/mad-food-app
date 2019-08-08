package lk.my.sliit.it18106398.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MyBag extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ModelOrder> orderList;

    OrderAdapter adapter;
    Button btn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bag);

        orderList = new ArrayList<>();
        orderList.add(new ModelOrder(R.drawable.noodles,"noodles"));
        orderList.add(new ModelOrder(R.drawable.noodles,"noodles"));

        recyclerView = findViewById(R.id.foodsRecycleView);

        adapter = new OrderAdapter(getApplicationContext(),orderList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
