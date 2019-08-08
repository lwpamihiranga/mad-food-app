package lk.my.sliit.it18106398.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Addfoods extends AppCompatActivity {


    Button add_button1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addfoods);

        Button add_button;

        add_button1= (Button) findViewById(R.id.add_button);

        add_button1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              Intent intent = new Intent(Addfoods.this,Promotion_ACTIVITY1.class);


           }
        });

    }
}
