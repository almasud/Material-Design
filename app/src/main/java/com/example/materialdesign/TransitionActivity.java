package com.example.materialdesign;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.Gravity;
import android.view.Window;
import android.view.animation.BounceInterpolator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

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
                new StringBuilder(getString(R.string.enter_and_exit_transition))
                        .append(getString(R.string.explode_transition_text))
                        .append(getString(R.string.slide_transition_text))
                        .append(getString(R.string.fade_transition_text))
                        .append(" N.B: ")
                        .append(getString(R.string.shared_element_transition_text)));

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

    @SuppressLint("RtlHardcoded")
    private void initTransition(Constant.TransitionType transitionType) {
        switch (transitionType) {
            case ExplodeJava:
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    Explode explode = new Explode();
                    explode.setDuration(getResources().getInteger(R.integer.animation_duration_long));
                    // Interpolator define the rate of changes of animation and the basic animation effects.
                    explode.setInterpolator(new FastOutSlowInInterpolator());
                    getWindow().setEnterTransition(explode);
                }
                break;
            case ExplodeXML:
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.explode);
                    getWindow().setEnterTransition(transition);
                }
                break;
            case SlideJava:
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    Slide slide = new Slide();
                    slide.setDuration(getResources().getInteger(R.integer.animation_duration_long));
                    slide.setSlideEdge(Gravity.LEFT);
                    getWindow().setEnterTransition(slide);
                }
                break;
            case SlideXML:
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.slide);
                    getWindow().setEnterTransition(transition);
                }
                break;
            case FadeJava:
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                    Fade fade = new Fade();
                    fade.setDuration(getResources().getInteger(R.integer.animation_duration_long));
                    getWindow().setEnterTransition(fade);
                }
                break;
            case FadeXML:
                if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Transition transition = TransitionInflater.from(this).inflateTransition(R.transition.fade);
                    getWindow().setEnterTransition(transition);
                }
                break;
        }
    }
}
