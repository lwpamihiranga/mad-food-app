package lk.my.sliit.it18106398.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateQty extends AppCompatActivity {
    TextView editQty;
    Button update;
    int updateItem;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.update_quantity);

        Intent intent = getIntent();
        updateItem = intent.getIntExtra("qty",0);

        editQty = findViewById(R.id.textView4);
        update = findViewById(R.id.button4);
    }
}
