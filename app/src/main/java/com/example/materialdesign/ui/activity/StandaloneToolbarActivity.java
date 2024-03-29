package com.example.materialdesign.ui.activity;

import android.os.Build;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.materialdesign.R;
import com.example.materialdesign.databinding.ActivityToolbarBinding;

public class StandaloneToolbarActivity extends AppCompatActivity {
    private ActivityToolbarBinding mViewBinding;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = ActivityToolbarBinding.inflate(getLayoutInflater());
        setContentView(mViewBinding.getRoot());

        mToolbar = (Toolbar) mViewBinding.toolbar.getRoot();
        // Set the standalone toolbar
        mToolbar.setTitle(getResources().getString(R.string.standalone_toolbar));
        mToolbar.setSubtitle(new StringBuilder("by ").append(getResources().getString(R.string.author_full_name)));
        // Compatibility by Java code
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mToolbar.setElevation(10f);
        }
        // Inflate menus in standalone toolbar
        mToolbar.inflateMenu(R.menu.menu_main);
        mToolbar.setOnMenuItemClickListener(item -> {
            Toast.makeText(this, item.getTitle() + " is selected", Toast.LENGTH_SHORT).show();
            switch (item.getItemId()) {
                case R.id.save:
                    // Perform save action
                    break;
                case R.id.email:
                    // Perform email action
                    break;
            }
            return true;
        });
    }
}
