package lk.my.sliit.it18106398.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class Promotion_ACTIVITY1 extends AppCompatActivity {

    Button btn1, btn2,btn3,btn4;
    /*RecyclerView recyclerView;
    ArrayList<ModelRestaurant> restuarantsList;
*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion__activity1);

        btn1 = findViewById(R.id.res1);
        btn2 = findViewById(R.id.res2);
        btn3 = findViewById(R.id.res3);
        btn4 = findViewById(R.id.res4);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Promotion_ACTIVITY1.this, Resturent_Home.class);//client's side
                startActivity(intent1);

//                Intent intent2 = new Intent(Promotion_ACTIVITY1.this, Add_Promotions.class);//user's side
//                startActivity(intent2);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Promotion_ACTIVITY1.this, Resturent_Home.class);
                startActivity(intent1);

//                Intent intent2 = new Intent(Promotion_ACTIVITY1.this, Promotion_ACTIVITY3.class);//user's side
//                startActivity(intent2);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(Promotion_ACTIVITY1.this, Resturent_Home.class);
                startActivity(intent1);
            }
        });
    }
}
