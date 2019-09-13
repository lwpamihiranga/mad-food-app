package lk.my.sliit.it18106398.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
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
    EditText txt0_form, txt1_form, txt2_form, txt3_form, txt4_form;

    Button btn, btnDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_promotions);

        txt0_form = (EditText) findViewById(R.id.editTxt1);
        txt1_form = (EditText) findViewById(R.id.editTxt1);
        txt2_form = (EditText) findViewById(R.id.editTxt2);
        txt3_form = (EditText) findViewById(R.id.editTxt3);
        txt4_form = (EditText) findViewById(R.id.editTxt4);

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
