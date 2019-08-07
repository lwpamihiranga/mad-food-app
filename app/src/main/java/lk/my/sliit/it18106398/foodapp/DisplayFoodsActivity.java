package lk.my.sliit.it18106398.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DisplayFoodsActivity extends AppCompatActivity {
    ImageView imageView;
    TextView textView;

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_foods);

        b1 = findViewById(R.id.btn1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Intent intent1 = new Intent(DisplayFoodsActivity.this, MyBag.class);
                startActivity(intent1);
            }
        });



        imageView = findViewById(R.id.imageTop);
        textView = findViewById(R.id.foodNameTxtView);

        imageView.setImageResource(getIntent().getIntExtra("image_id", 00));
        textView.setText(getIntent().getStringExtra("res_name"));


    }


    
}
