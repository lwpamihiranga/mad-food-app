package lk.my.sliit.it18106398.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.FirebaseDatabase;

public class Promotion_ACTIVITY3 extends AppCompatActivity {

    //FirebaseDatabase dRef;
    ImageView imageView;
    TextView textView1;
    TextView getTextView2;
    Button b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion__activity3);

        //dRef = new FirebaseDatabase("https://foodappmad.firebaseio.com/PromotionTable");

        imageView = findViewById(R.id.imageViewadd);
        textView1 = findViewById(R.id.nameTxt);
        getTextView2 = findViewById(R.id.descTxt);

        b = findViewById(R.id.button2);

        //imageView.setImageResource(getIntent().getIntExtra("image", 00));
        //textView1.setText(getIntent().getStringExtra("name"));
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(),MyBag.class);
                startActivity(intent1);
            }
        });

    }
}
