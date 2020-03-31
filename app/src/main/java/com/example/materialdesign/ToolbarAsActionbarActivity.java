package com.example.materialdesign;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.materialdesign.databinding.ActivityToolbarBinding;

public class ToolbarAsActionbarActivity extends AppCompatActivity {
    private ActivityToolbarBinding mViewBinding;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = ActivityToolbarBinding.inflate(getLayoutInflater());
        setContentView(mViewBinding.getRoot());

        mToolbar = (Toolbar) mViewBinding.toolbar.getRoot();
        setSupportActionBar(mToolbar);
        getSupportActionBar().setSubtitle("Actionbar Toolbar");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        String msg = "";

        switch (item.getItemId()) {
            case R.id.save:
                msg = getString(R.string.save);
                break;
            case R.id.settings:
                msg = getString(R.string.settings);
                break;
            case R.id.email:
                msg = getString(R.string.email);
                break;
            case R.id.camera:
                msg = getString(R.string.camera);
                break;
            case R.id.webSearch:
                msg = getString(R.string.web_search);
                break;
            case R.id.help:
                msg = getString(R.string.help);
                break;
        }

        Toast.makeText(this, msg + " Selected", Toast.LENGTH_SHORT).show();
        return true;
    }
}
