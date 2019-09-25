package lk.my.sliit.it18106398.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;

public class Update_Promotions extends AppCompatActivity {

    EditText data1;
    EditText data2;
    EditText data3;
    EditText data4;
    Button update;
    DatabaseReference dbf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__promotions);

        data1 = findViewById(R.id.txtdata1);
        data2 = findViewById(R.id.txtdata2);
        data3 = findViewById(R.id.txtdata3);
        data4 = findViewById(R.id.txtdata4);

        update = findViewById(R.id.updateDataBtn);

        Intent intent = getIntent();
        String x = intent.getStringExtra("pName;");
        //String foodname = intent.getStringExtra("Pname");
        //String descri = intent.getStringExtra("desc");
        data1.setText(x);
        //data2.setText(descri);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
