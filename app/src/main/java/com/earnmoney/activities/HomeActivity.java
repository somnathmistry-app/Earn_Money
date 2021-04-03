package com.earnmoney.activities;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.earnmoney.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.earnmoney.Fragments.CartFragment;
import com.earnmoney.Fragments.CategoryFragment;
import com.earnmoney.Fragments.HomeFragment;

public class HomeActivity extends AppCompatActivity implements HomeFragment.OnFragmentInteractionListener {

//    ImageView categorybtn;
    HomeFragment homeFragment;
    CategoryFragment categoryFragment;
    CartFragment cartFragment;
    FragmentManager fragmentManager;
    Button logoutBtn;

    DrawerLayout myDrawer;

    BottomNavigationView myHomeBottomNav;

    Toolbar myHomeToolBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ActionBarDrawerToggle toggle;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);
        myHomeToolBar = findViewById(R.id.toolbar);
        setSupportActionBar(myHomeToolBar);
        //categorybtn = findViewById(R.id.categorybtn);
        //logoutBtn = findViewById(R.id.logoutBtn);
        myHomeToolBar.setNavigationIcon(R.drawable.nav_icon_black);
        myHomeToolBar.setTitleTextColor(getResources().getColor(R.color.white));
        myHomeToolBar.setTitleTextAppearance(this, R.style.myFont);
        myHomeBottomNav = findViewById(R.id.homeBottomNav);
        homeFragment = new HomeFragment();
        cartFragment = new CartFragment();
        categoryFragment = new CategoryFragment();


        myDrawer = findViewById(R.id.drawerLayout);

        setFragment(homeFragment);


//        categorybtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                myDrawer.closeDrawer(GravityCompat.START);
//                setFragment(categoryFragment);
//
//            }
//        });
//
//        logoutBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//                //myDrawer.closeDrawer(GravityCompat.START);
//                Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
        // click listener for navigation icon of toolbar
        myHomeToolBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDrawer.openDrawer(GravityCompat.START);

            }
        });


        myHomeBottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {


                switch (menuItem.getItemId()) {

                    case R.id.home:
                        setFragment(homeFragment);
                        break;


                    case R.id.bfsi:
                        setFragment(categoryFragment);
                        break;


                    case R.id.apps:
                        setFragment(cartFragment);
                        break;

                }
                return true;
            }
        });
    }
    private void setFragment(Fragment fragment) {
        if (fragment != null) {
            fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.homeContainer, fragment);
            fragmentTransaction.addToBackStack("OP");
            fragmentTransaction.commit();
        }

    }
}
