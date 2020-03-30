package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.example.materialdesign.databinding.ActivityFloatingLabelEditTextBinding;

public class FloatingLabelEditTextActivity extends AppCompatActivity {
    private ActivityFloatingLabelEditTextBinding mViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = ActivityFloatingLabelEditTextBinding.inflate(getLayoutInflater());
        setContentView(mViewBinding.getRoot());

        // Set the toolbar
        Toolbar toolbar = (Toolbar) mViewBinding.floatingLabelEditTextActivityToolbar.getRoot();
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(getResources().getString(R.string.floating_label_for_edit_text));
    }
}
