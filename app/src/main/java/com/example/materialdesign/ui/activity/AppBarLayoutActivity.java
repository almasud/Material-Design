package com.example.materialdesign.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.materialdesign.R;
import com.example.materialdesign.databinding.ActivityAppBarLayoutBinding;

public class AppBarLayoutActivity extends AppCompatActivity {
    ActivityAppBarLayoutBinding mViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = ActivityAppBarLayoutBinding.inflate(getLayoutInflater());
        setContentView(mViewBinding.getRoot());

        // Set the toolbar
        setSupportActionBar(mViewBinding.toolbarAppBarLayout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setSubtitle(getResources().getString(R.string.app_bar_layout));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
