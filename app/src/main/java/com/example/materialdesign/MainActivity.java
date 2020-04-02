package com.example.materialdesign;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.materialdesign.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mViewBinding.getRoot());

        // Set the toolbar
        Toolbar toolbar = (Toolbar) mViewBinding.mainActivityToolbar.getRoot();
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.example_of_material_design));
        getSupportActionBar().setSubtitle(new StringBuilder("by ").append(getResources().getString(R.string.author_full_name)));

        // Check if we're running on android 5.0 (API 21) or higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Call material design APIs here
        } else {
            // Implement the feature without material design
        }

        mViewBinding.buttonColorPalette.setOnClickListener(view -> startActivity(new Intent(this, ColorPaletteActivity.class)));
        mViewBinding.buttonToolbar.setOnClickListener(view -> startActivity(new Intent(this, ToolbarsActivity.class)));
        mViewBinding.buttonBasicComponents.setOnClickListener(view -> startActivity(new Intent(this, BasicComponentActivity.class)));
        mViewBinding.buttonAnimations.setOnClickListener(view -> startActivity(new Intent(this, AnimationActivity.class)));
        mViewBinding.buttonFloatingLabel.setOnClickListener(view -> startActivity(new Intent(this, FloatingLabelEditTextActivity.class)));
        mViewBinding.buttonAppBarCollapsingToolbar.setOnClickListener(view -> startActivity(new Intent(this, AppBarCollapsingToolbarActivity.class)));
        mViewBinding.buttonNavigationDrawer.setOnClickListener(view -> startActivity(new Intent(this, NavigationDrawerActivity.class)));
    }
}
