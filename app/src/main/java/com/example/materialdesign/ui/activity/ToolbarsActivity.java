package com.example.materialdesign.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.materialdesign.databinding.ActivityToolbarsBinding;

public class ToolbarsActivity extends AppCompatActivity {
    private ActivityToolbarsBinding mViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = ActivityToolbarsBinding.inflate(getLayoutInflater());
        setContentView(mViewBinding.getRoot());

        mViewBinding.buttonStandaloneToolbar.setOnClickListener(view -> startActivity(new Intent(this, StandaloneToolbarActivity.class)));
        mViewBinding.buttonToolbarAsActionbar.setOnClickListener(view -> startActivity(new Intent(this, ToolbarAsActionbarActivity.class)));
        mViewBinding.buttonContextualMenu.setOnClickListener(view -> startActivity(new Intent(this, ContextualMenuActivity.class)));
    }
}
