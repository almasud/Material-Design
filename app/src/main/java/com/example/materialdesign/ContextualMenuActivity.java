package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.materialdesign.databinding.ActivityToolbarBinding;

public class ContextualMenuActivity extends AppCompatActivity {
    private ActivityToolbarBinding mViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = ActivityToolbarBinding.inflate(getLayoutInflater());
        setContentView(mViewBinding.getRoot());
    }
}
