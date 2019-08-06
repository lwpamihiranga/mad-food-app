package lk.my.sliit.it18106398.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class Promotion_ACTIVITY3 extends AppCompatActivity {
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion__activity3);

        imageView = findViewById(R.id.imageView2);
        textView = findViewById(R.id.textView4);

        imageView.setImageResource(getIntent().getIntExtra("image", 00));
        textView.setText(getIntent().getStringExtra("name"));
    }
}
