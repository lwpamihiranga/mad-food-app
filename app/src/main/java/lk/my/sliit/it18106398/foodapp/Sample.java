package lk.my.sliit.it18106398.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Sample extends AppCompatActivity {

    TextView des;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        des = (TextView) findViewById(R.id.des);

        Intent intent = getIntent();
        String d = intent.getStringExtra("des");
        des.setText(d);
    }
}
