package lk.my.sliit.it18106398.foodapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Promotion_ACTIVITY3 extends AppCompatActivity {

    //FirebaseDatabase dRef;
    ImageView imageView;
    TextView textView1;
    TextView getTextView2;
    Button b;


    String key;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promotion__activity3);

        //dRef = new FirebaseDatabase("https://foodappmad.firebaseio.com/PromotionTable");

        imageView = findViewById(R.id.imageViewadd);
        textView1 = findViewById(R.id.nameTxt);
        getTextView2 = findViewById(R.id.descTxt);

        b = findViewById(R.id.button2);

        Intent intent = getIntent();
        String name = intent.getStringExtra("pName");
        String des = intent.getStringExtra("key");
        String d = intent.getStringExtra("textView1");
        String n = intent.getStringExtra("getTextView2");
        textView1.setText(name);
        getTextView2.setText(des);

        key = intent.getStringExtra("key");
        //imageView.setImageResource(getIntent().getIntExtra("image", 00));
        //textView1.setText(getIntent().getStringExtra("name"));
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(),MyBag.class);
                startActivity(intent1);
            }
        });

//        DatabaseReference db =FirebaseDatabase.getInstance().getReference().child("PromotionTable").child(key);
//
//        db.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                List promos = new ArrayList<>();
//                for(DataSnapshot dataSnapshot1: dataSnapshot.getChildren()) {
//                    Add_Promotions promo = dataSnapshot1.getValue(Add_Promotions.class);
//                    promos.add(promo);
//                }
//
//                for()
//                if(dataSnapshot.hasChildren()) {
//                    String des = dataSnapshot.child("description").getValue().toString();
//                    getTextView2.setText(des);
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

    }
}
