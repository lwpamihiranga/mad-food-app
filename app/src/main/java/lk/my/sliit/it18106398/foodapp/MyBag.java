package lk.my.sliit.it18106398.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
//test comment 2
public class MyBag extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ModelOrder> orderList;

    OrderAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_bag);

        orderList = new ArrayList<>();
        orderList.add(new ModelOrder(R.drawable.noodles,"noodles"));
        orderList.add(new ModelOrder(R.drawable.noodles,"noodles"));

        recyclerView = findViewById(R.id.restuarantRecycleView);

        adapter = new OrderAdapter(getApplicationContext(),orderList);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}
