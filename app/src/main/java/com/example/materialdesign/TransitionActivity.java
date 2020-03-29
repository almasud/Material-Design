package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Window;

import com.example.materialdesign.databinding.ActivityTransitionBinding;

public class TransitionActivity extends AppCompatActivity {
    private ActivityTransitionBinding mViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // For AppCompact (If we didn't enable transition in our theme) getWindow() must
        // be called before calling setContentView()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().requestFeature(Window.FEATURE_CONTENT_TRANSITIONS);
        }
        mViewBinding = ActivityTransitionBinding.inflate(getLayoutInflater());
        setContentView(mViewBinding.getRoot());

        // Get animation type and title from intent
        Constant.TransitionType transitionType = (Constant.TransitionType) getIntent().getSerializableExtra(Constant.KEY_ANIMATION_TYPE);
        String toolbarTitle = getIntent().getExtras().getString(Constant.KEY_ANIMATION_TITLE);

        // Set the toolbar title and enable back arrow navigation
        Toolbar toolbar = (Toolbar) mViewBinding.transitionActivityToolbar.getRoot();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(toolbarTitle);

        // Set the description text
        mViewBinding.transitionActivityDescription.setText(
                new StringBuilder(getString(R.string.explode_transition_text))
                        .append(" N.B: ").append(getString(R.string.shared_element_transition_text)));

        //Set the back button click event
        mViewBinding.buttonTransitionActivityBack.setOnClickListener(view -> supportFinishAfterTransition());

        // Code for transition animation
        initTransition(transitionType);
    }

    @Override
    public boolean onSupportNavigateUp() {
        supportFinishAfterTransition();
        return true;
    }

    private void initTransition(Constant.TransitionType transitionType) {
        switch (transitionType) {
            case ExplodeJava:
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    Explode enterTransition = new Explode();
                    enterTransition.setDuration(getResources().getInteger(R.integer.animation_duration_long));
                    getWindow().setEnterTransition(enterTransition);
                }
                break;
            case ExplodeXML:
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    Transition enterTransition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
                    getWindow().setEnterTransition(enterTransition);
                }
                break;
        }
    }
}
