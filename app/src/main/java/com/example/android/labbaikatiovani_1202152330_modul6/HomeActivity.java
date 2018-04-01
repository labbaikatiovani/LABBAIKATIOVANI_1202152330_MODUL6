package com.example.android.labbaikatiovani_1202152330_modul6;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.android.labbaikatiovani_1202152330_modul6.Fragment.PagerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {
    //deklarasi untuk tabel
    public static final String table_1 = "Post";
    public static final String table_2 = "Comment";
    public static final String table_3 = "User";

    //deklrasai variable
    TabLayout tab;

    //deklrasi instance
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //initialize firebase instance
        mAuth = FirebaseAuth.getInstance();

        //binding data
        tab = findViewById(R.id.tab);
        final ViewPager viewPager = findViewById(R.id.pager);

        //set text untuk tab
        tab.addTab(tab.newTab().setText("Posts"));
        tab.addTab(tab.newTab().setText("My Posts"));
        //set tab to fill entire layout
        tab.setTabGravity(tab.GRAVITY_FILL);

        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tab.getTabCount());
        //set viewpager adapter
        viewPager.setAdapter(adapter);
        //listener view pager saat berpindah
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab));

        //listener tab ketika dipilih
        tab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //set view pager sesuai get posisi tab
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
    //ketika menu dibuat maka get menu inflate
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    //ketika opsi menu dipilih
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //get item id
        int id = item.getItemId();

        if (id == R.id.logout){
            mAuth.signOut();
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        }
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        //mengambil current user aktif
        FirebaseUser currentUser = mAuth.getCurrentUser();
        //cek current user ada atau tidak
        if (currentUser == null){
            Intent i = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(i);
            finish();
        }
    }

    //onClick add post
    public void addPost(View view){
        Intent i = new Intent(HomeActivity.this, AddPostActivity.class);
        startActivity(i);
    }

    }
