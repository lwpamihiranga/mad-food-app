package lk.my.sliit.it18106398.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.time.Instant;
import java.util.ArrayList;

public class Promotion_ACTIVITY2 extends AppCompatActivity {

   // ListView listView;
//    String names = {name1, name2};
//    Integer[] images ={I1,I2};
    Button btn_promo1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion__activity2);

        //listView= (ListView) findViewById(R.id.list1);
       // names = findViewById(R.id.txtView1);

        //final ArrayList<String>arrayList
        btn_promo1 = (Button) findViewById(R.id.buttonPromo1);
    }

    @Override
    protected void onResume() {
        super.onResume();

        btn_promo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ins = new Intent(Promotion_ACTIVITY2.this,Promotion_ACTIVITY3.class);
                startActivity(ins);
            }
        });
    }
}
