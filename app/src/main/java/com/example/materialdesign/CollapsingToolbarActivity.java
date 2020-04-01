package com.example.materialdesign;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.materialdesign.databinding.ActivityCollapsingToolbarBinding;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class CollapsingToolbarActivity extends AppCompatActivity {
    private ActivityCollapsingToolbarBinding mViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = ActivityCollapsingToolbarBinding.inflate(getLayoutInflater());
        setContentView(mViewBinding.getRoot());

        // Set toolbar & collapsing toolbar
        setSupportActionBar(mViewBinding.toolbarCollapsingToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        CollapsingToolbarLayout collapsingToolbar = mViewBinding.collapsingToolbar;
        collapsingToolbar.setTitle(getResources().getString(R.string.collapsing_toolbar));
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
