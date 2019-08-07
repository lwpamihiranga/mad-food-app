package lk.my.sliit.it18106398.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Resturent_Home extends AppCompatActivity {

    Button addFood, addOrder, addPromotion;
    Button viewPromotion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturent__home);

        addPromotion = (Button) findViewById(R.id.btnadd_promo);
        viewPromotion = (Button) findViewById(R.id.btnview_promo);

    }

    @Override
    protected void onResume() {
        super.onResume();

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
                Intent intent = new Intent(Resturent_Home.this, Promotion_ACTIVITY2.class);
                startActivity(intent);
            }
        });

    }
}
