package lk.my.sliit.it18106398.foodapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Update_Promotions extends AppCompatActivity {

    TextView data1;
    TextView data2;
    TextView data3;
    TextView data4;
    Button update;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update__promotions);

        data1 = findViewById(R.id.txtdata1);
        data2 = findViewById(R.id.txtdata2);
        data3 = findViewById(R.id.txtdata3);
        data4 = findViewById(R.id.txtdata4);

        update = findViewById(R.id.updateDataBtn);

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
