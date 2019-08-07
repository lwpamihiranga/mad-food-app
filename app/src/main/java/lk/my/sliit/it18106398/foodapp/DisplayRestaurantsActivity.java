package lk.my.sliit.it18106398.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayRestaurantsActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;


    Button viewFood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_restaurants);

        //b1 = findViewById(R.id.btn1);

        viewFood = (Button) findViewById(R.id.viewFood);

        viewFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent1 = new Intent(DisplayRestaurantsActivity.this, FoodList.class);
                startActivity(intent1);
            }
        });


        imageView = findViewById(R.id.imageTop);
        textView = findViewById(R.id.resNameTxtView);

        imageView.setImageResource(getIntent().getIntExtra("image_id", 00));
        textView.setText(getIntent().getStringExtra("res_name"));
    }

    @Override
    protected void onResume() {
        super.onResume();


    }
}