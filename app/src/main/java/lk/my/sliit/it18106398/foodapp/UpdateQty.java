package lk.my.sliit.it18106398.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateQty extends AppCompatActivity {
    private static final String TAG = "UpdateQty";

    TextView editQty;
    Button update;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.update_quantity);
        Log.d(TAG,"onCreate:started.");

        Intent intent = getIntent();
        String y =  intent.getStringExtra("des");
        editQty = findViewById(R.id.food_des);
        editQty.setText(y);

        //Intent intent = getIntent();
        //updateItem = intent.getIntExtra("qty",0);
        getQtyIntent();

        editQty = findViewById(R.id.food_des);
        update = findViewById(R.id.button4);
    }
    private void getQtyIntent(){
        Log.d(TAG,"getIncomingIntent:check for incoming intent");
        if (getIntent().hasExtra("food_des")){
            String description = getIntent().getStringExtra("food_des");
            setValues(description);
        }
    }
    private void setValues(String des){
        TextView name = findViewById(R.id.food_des);
        name.setText(des);
    }
}
