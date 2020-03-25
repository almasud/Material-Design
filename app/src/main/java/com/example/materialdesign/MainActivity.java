package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.example.materialdesign.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mViewBinding.getRoot());

        // Check if we're running on android 5.0 (API 21) or higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            // Call material design APIs here
        } else {
            // Implement the feature without material design
        }

        mViewBinding.buttonColorPalette.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), ColorPaletteActivity.class)));
    }
}
