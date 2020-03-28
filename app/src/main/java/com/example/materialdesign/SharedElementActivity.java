package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.widget.Toast;

import com.example.materialdesign.databinding.ActivitySharedElementBinding;

public class SharedElementActivity extends AppCompatActivity {
    private ActivitySharedElementBinding mViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // For AppCompact (If we didn't enable transition in our theme) getWindow() must
        // be called before calling setContentView()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        } else {
            Toast.makeText(this, getString(R.string.activity_transition_supported_note), Toast.LENGTH_LONG).show();
        }
        mViewBinding = ActivitySharedElementBinding.inflate(getLayoutInflater());
        setContentView(mViewBinding.getRoot());

        // Toolbar as Actionbar
        Toolbar toolbar = findViewById(R.id.sharedElementActivityToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getResources().getString(R.string.shared_element_transition));

        mViewBinding.buttonSharedActivityBack.setOnClickListener(view -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                finishAfterTransition();
            } else {
                finish();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            finishAfterTransition();
        } else {
            finish();
        }
        return true;
    }
}
