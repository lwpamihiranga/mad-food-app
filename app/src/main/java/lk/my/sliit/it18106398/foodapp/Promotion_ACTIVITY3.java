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
    ImageButton imageView;
    EditText textView1;
    EditText getTextView2;
    Button b;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion__activity3);

        //dRef = new FirebaseDatabase("https://foodappmad.firebaseio.com/PromotionTable");

        imageView = findViewById(R.id.imageButtonview);
        textView1 = findViewById(R.id.editText5);
        getTextView2 = findViewById(R.id.editText4);

        b = findViewById(R.id.button2);

        //imageView.setImageResource(getIntent().getIntExtra("image", 00));
        //textView1.setText(getIntent().getStringExtra("name"));


    }
}
