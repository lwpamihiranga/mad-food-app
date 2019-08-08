package lk.my.sliit.it18106398.foodapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class ListCompanyOrder extends AppCompatActivity {

    Button b1, b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_company_order);

        b1 = findViewById(R.id.btnPending);
        b2 = findViewById(R.id.btnCompleted);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                changeFragment(view);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeFragment(view);
            }
        });
    }

    public void changeFragment(View view) {
        if(view == findViewById(R.id.btnPending)) {
            Toast.makeText(this, "clicked 1", Toast.LENGTH_SHORT).show();
            Fragment fragment = new PendingOrdersFragment();

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragmentDefault, fragment);
            fragmentTransaction.commit();
        }

        if(view == findViewById(R.id.btnCompleted)) {
            Fragment fragment = new CompletedOrdersFragement();
            Toast.makeText(this, "clicked 2", Toast.LENGTH_SHORT).show();
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.fragment, fragment);
            fragmentTransaction.commit();
        }
    }
}
