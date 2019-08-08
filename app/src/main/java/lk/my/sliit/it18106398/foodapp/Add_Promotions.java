package lk.my.sliit.it18106398.foodapp;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import java.util.Calendar;

public class Add_Promotions extends AppCompatActivity implements DatePickerDialog.OnDateSetListener{

    //String s1, s2;
    EditText txt1_form;

    Button btn, btnDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_promotions);

        txt1_form = (EditText) findViewById(R.id.editTxt1);

        btn = (Button) findViewById(R.id.add_button);

        btnDate = (Button) findViewById(R.id.tvDate);
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogFragment datePicker = new date_picker_fragment();
                datePicker.show(getSupportFragmentManager(),"Date Picker");
            }
        });
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR,year);
        cal.set(Calendar.MONTH,month);
        cal.set(Calendar.DAY_OF_MONTH,day);

        //String date = DateFormat.getDateInstant().format(cal.getTime());

        TextView txtView = (TextView) findViewById(R.id.tvDate);
        //txtView.setText(date);

    }

    @Override
    protected void onStart() {
        super.onStart();
    }


    @Override
    protected void onResume() {
        super.onResume();

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(Add_Promotions.this,Promotion_ACTIVITY1.class);


            }
        });
    }
}
