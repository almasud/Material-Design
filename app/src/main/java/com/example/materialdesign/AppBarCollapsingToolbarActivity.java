package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;

import com.example.materialdesign.databinding.ActivityAppBarCollapsingToolbarBinding;

public class AppBarCollapsingToolbarActivity extends AppCompatActivity {
    ActivityAppBarCollapsingToolbarBinding mViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = ActivityAppBarCollapsingToolbarBinding.inflate(getLayoutInflater());
        setContentView(mViewBinding.getRoot());

        // Set the toolbar
        Toolbar toolbar = (Toolbar) mViewBinding.toolbarAppBarCollapsingToolbar.getRoot();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setSubtitle(getResources().getString(R.string.app_bar_layout_n_collapsing_toolbar_layout));

        // Set the button click event
        mViewBinding.buttonAppBarLayout.setOnClickListener(view -> startActivity(new Intent(this, AppBarLayoutActivity.class)));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
