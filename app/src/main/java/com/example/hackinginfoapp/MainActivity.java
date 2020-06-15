package com.example.hackinginfoapp;

import androidx.annotation.NonNull;

import com.example.hackinginfoapp.fragments.CyberVulsFragment;
import com.example.hackinginfoapp.fragments.FamousHackersFragment;
import com.example.hackinginfoapp.fragments.FamousHacksFragment;
import com.example.hackinginfoapp.fragments.HomeFragment;
import com.example.hackinginfoapp.fragments.HowToProtectFragment;
import com.example.hackinginfoapp.fragments.TypesOfHackingFragment;
import com.example.hackinginfoapp.roomdatabase.Item;
import com.example.hackinginfoapp.roomdatabase.ItemAdapter;
import com.example.hackinginfoapp.roomdatabase.ItemViewModel;
import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    private ItemViewModel itemViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //creating our recyclerview & initialising it
        RecyclerView recyclerView = findViewById(R.id.main_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        //assigning our custom adapter
        final ItemAdapter adapter = new ItemAdapter();
        recyclerView.setAdapter(adapter);

        //
        itemViewModel = new ViewModelProvider(this,
                ViewModelProvider.AndroidViewModelFactory.getInstance(this.getApplication())).get(ItemViewModel.class);
        //getting the itemlist filled with the items we want (in this case, famous hackers)
        itemViewModel.getFamousHackersItems().observe(this, new Observer<List<Item>>() {

            //This class is called every time the data in our LiveData is changed
            @Override
            public void onChanged(List<Item> items) {
                adapter.setItems(items);
            }
        });

        //setting toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //setting slide-out navigation drawer
        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        //if statement stops home fragment from being selected when we rotate the screen or
        //do any runtime configuration change
        if (savedInstanceState == null) {
            //sets Home message fragment as default fragment when app is opened
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            //sets home as checked item in drawer
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        //method to open fragments when they are pressed in the drawer menu
        switch (menuItem.getItemId()) {
            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;
            case R.id.nav_typesOfHacking:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TypesOfHackingFragment()).commit();
                break;
            case R.id.nav_CyberVulnerabilities:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CyberVulsFragment()).commit();
                break;
            case R.id.nav_FamousCyberAttacks:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FamousHacksFragment()).commit();
                break;
            case R.id.nav_FamousHackers:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FamousHackersFragment()).commit();
                break;
            case R.id.nav_HowToDefend:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HowToProtectFragment()).commit();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        super.onBackPressed();
    }
}
