package com.example.materialdesign.ui.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.materialdesign.R;
import com.example.materialdesign.databinding.ActivityNavigationDrawerBinding;
import com.google.android.material.navigation.NavigationView;

public class NavigationDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ActivityNavigationDrawerBinding mViewBinding;
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = ActivityNavigationDrawerBinding.inflate(getLayoutInflater());
        setContentView(mViewBinding.getRoot());

        // Set the toolbar
        mToolbar = mViewBinding.toolbarNavigationDrawer;
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setSubtitle(getResources().getString(R.string.navigation_drawer));

        // Set the navigation drawer menu
        mDrawerLayout = mViewBinding.navigationDrawerLayout;
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close);
        mDrawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        // Set navigation item select listener
        NavigationView navigationView = mViewBinding.navigationView;
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Enable item checkable here or inside theme
//        item.setCheckable(true);
//        item.setChecked(true);  // This helps to know which menu item is clicked
        String itemName = (String) item.getTitle();
        Toast.makeText(this, itemName + " Clicked", Toast.LENGTH_SHORT).show();
        mDrawerLayout.closeDrawer(GravityCompat.START);

        switch (item.getItemId()) {
            case R.id.menuWifi:
                // Item specific code here...
                break;
            case R.id.menuWifiTethering:
                // Item specific code here...
                break;
        }

        return true;
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START))
            mDrawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();
    }
}
