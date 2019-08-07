package lk.my.sliit.it18106398.foodapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayFoodsActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_foods);



        imageView = findViewById(R.id.imageTop);
        textView = findViewById(R.id.foodNameTxtView);

        imageView.setImageResource(getIntent().getIntExtra("image_id", 00));
        textView.setText(getIntent().getStringExtra("res_name"));
    }
}
