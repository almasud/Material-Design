package com.example.materialdesign;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.Window;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

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
        getSupportActionBar().setSubtitle(getResources().getString(R.string.shared_element_transition));
        // Set the description text
        mViewBinding.descriptionActivitySharedTransition.setText(
                new StringBuilder(getString(R.string.circular_reveal_animation_text))
                        .append(" N.B: ").append(getString(R.string.shared_element_transition_text)));

        // Circular reveal animation of Activity transition
        mViewBinding.sharedTransitionReveal.setOnClickListener(this::makeCircularRevealAnimation);

        mViewBinding.buttonSharedActivityBack.setOnClickListener(view -> supportFinishAfterTransition());
    }

    @Override
    public boolean onSupportNavigateUp() {
        supportFinishAfterTransition();
        return true;
    }

    private void makeCircularRevealAnimation(View view) {
        int centerX = (view.getLeft() + view.getRight()) / 2;
        int centerY = (view.getTop() + view.getBottom()) / 2;
        float radius = Math.max(mViewBinding.textDescriptionReveal.getWidth(),
                mViewBinding.textDescriptionReveal.getHeight()) * 2.0f;

        if (mViewBinding.textDescriptionReveal.getVisibility() == View.INVISIBLE) {
            mViewBinding.textDescriptionReveal.setVisibility(View.VISIBLE);
            // Set the description text
            mViewBinding.textDescriptionReveal.setText(
                    new StringBuilder(getString(R.string.circular_reveal_animation_text))
                            .append(" N.B: ").append(getString(R.string.shared_element_transition_text)));

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                // Change the action bar title to circular reveal animation and hide the back arrow navigation
                getSupportActionBar().setDisplayHomeAsUpEnabled(false);
                getSupportActionBar().setTitle(getResources().getString(R.string.circular_reveal_animation));

                // Create the circular reveal animation
                ViewAnimationUtils.createCircularReveal(mViewBinding.textDescriptionReveal,
                        centerX, centerY, 0, radius).start();
            } else {
                // Show the circular reveal text and supported toast message for not supported device
                mViewBinding.textDescriptionReveal.setVisibility(View.VISIBLE);
                Toast.makeText(this, getString(R.string.activity_transition_supported_note), Toast.LENGTH_LONG).show();
            }
        } else {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                Animator reveal = ViewAnimationUtils.createCircularReveal(mViewBinding.textDescriptionReveal,
                        centerX, centerY, radius, 0);
                reveal.addListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        // Change the action bar title to previous and enable back arrow navigation
                        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
                        getSupportActionBar().setTitle(getResources().getString(R.string.shared_element_transition));
                        // Hide the circular reveal animation text
                        mViewBinding.textDescriptionReveal.setVisibility(View.INVISIBLE);
                    }
                });
                reveal.start();
            } else {
                // Hide the circular reveal text and show the supported toast message for not supported device
                mViewBinding.textDescriptionReveal.setVisibility(View.INVISIBLE);
                Toast.makeText(this, getString(R.string.activity_transition_supported_note), Toast.LENGTH_LONG).show();
            }
        }
    }
}
