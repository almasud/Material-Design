package com.example.materialdesign.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.materialdesign.R;
import com.example.materialdesign.databinding.ActivityBasicComponentBinding;
import com.google.android.material.snackbar.Snackbar;

public class BasicComponentActivity extends AppCompatActivity {
    private ActivityBasicComponentBinding mViewBinding;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = ActivityBasicComponentBinding.inflate(getLayoutInflater());
        setContentView(mViewBinding.getRoot());

        mToolbar = (Toolbar) mViewBinding.basicComponentToolbar.getRoot();
        mToolbar.setTitle(getResources().getString(R.string.basic_components));
        mToolbar.setSubtitle(new StringBuilder("by ").append(getResources().getString(R.string.author_full_name)));

        mViewBinding.snackbar.setOnClickListener(view -> {
            Snackbar snackbar = Snackbar.make(mViewBinding.layoutBasicComponents, "Action performed successfully", Snackbar.LENGTH_LONG);
            snackbar.setBackgroundTint(getResources().getColor(R.color.gray_800));
            snackbar.setAction("UNDO", snackView -> Snackbar.make(mViewBinding.layoutBasicComponents, "Action recovered successfully", Snackbar.LENGTH_SHORT).show());
            snackbar.show();
        });

        mViewBinding.floatingActionButton.setOnClickListener(view -> {
            Snackbar.make(mViewBinding.layoutBasicComponents, "Floating action button is triggered", Snackbar.LENGTH_LONG).show();
        });
    }
}
