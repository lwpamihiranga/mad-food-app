package lk.my.sliit.it18106398.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DisplayRestaurantsActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_restaurants);

        imageView = findViewById(R.id.resImageTop);
        textView = findViewById(R.id.resNameTxtView);

        imageView.setImageResource(getIntent().getIntExtra("image_id", 00));
        textView.setText(getIntent().getStringExtra("res_name"));
    }
}
