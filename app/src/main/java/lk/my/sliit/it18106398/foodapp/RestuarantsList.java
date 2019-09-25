package lk.my.sliit.it18106398.foodapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class RestuarantsList extends AppCompatActivity {


    RecyclerView recyclerView;
    ArrayList<ModelRestaurant> restuarantsList;

    SearchView resSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restuarants_list);


        resSearch = findViewById(R.id.searchView);

        recyclerView = findViewById(R.id.restuarantRecycleView);

        restuarantsList = new ArrayList<>();

        restuarantsList.add(new ModelRestaurant(R.drawable.res1, "Olive Garden"));
        restuarantsList.add(new ModelRestaurant(R.drawable.res2, "Dilanka Foods"));
        restuarantsList.add(new ModelRestaurant(R.drawable.res3, "Monasha Hotel"));
        restuarantsList.add(new ModelRestaurant(R.drawable.res4, "Lounge 171"));
        restuarantsList.add(new ModelRestaurant(R.drawable.res5, "Lanka Food Corner"));
        restuarantsList.add(new ModelRestaurant(R.drawable.res6, "Matara Bath Kade"));
        restuarantsList.add(new ModelRestaurant(R.drawable.res7, "Hawai Restuarant"));
        restuarantsList.add(new ModelRestaurant(R.drawable.res8, "Palle Kade"));
        restuarantsList.add(new ModelRestaurant(R.drawable.res9, "Antige Kade"));

        final RestuarantsAdapter adapter = new RestuarantsAdapter(this, restuarantsList);

        resSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }


        });

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Intent intent = new Intent();

    }
}

