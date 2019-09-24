package lk.my.sliit.it18106398.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class Resturent_Home extends AppCompatActivity {

    Button addFood, addOrder, addPromotion;
    Button viewPromotion;
    Button viewFood, viewOrders, completedOrders;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturent__home);

        addPromotion = (Button) findViewById(R.id.btnadd_promo);
        viewPromotion = (Button) findViewById(R.id.btnview_promo);
        addFood = (Button) findViewById(R.id.btnadd_food);
        viewOrders = findViewById(R.id.btnview_order);
        completedOrders = findViewById(R.id.btnnCompletedOrdrs);
        viewFood = findViewById(R.id.btnview_food);


        addPromotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Resturent_Home.this,Add_Promotions.class);
                startActivity(intent);
            }
        });
        viewPromotion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Resturent_Home.this, promo_list.class);
                startActivity(intent1);
            }
        });

        addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Resturent_Home.this,Addfoods.class);
                startActivity(intent);
            }
        });
        viewOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Resturent_Home.this,PendingOrderActivity.class);
                startActivity(intent);
            }
        });

        completedOrders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Resturent_Home.this,CompletedOrderActivity.class);
                startActivity(intent);
            }
        });

//        viewFood.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(Resturent_Home.this, ViewFood.class);
//                startActivity(intent);
//            }
//        });

    }

    @Override
    protected void onResume() {
        super.onResume();



    }
}
