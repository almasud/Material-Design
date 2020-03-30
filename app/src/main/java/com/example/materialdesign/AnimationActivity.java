package com.example.materialdesign;

import android.content.Intent;
import android.os.Bundle;
import android.transition.Slide;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityOptionsCompat;
import androidx.core.util.Pair;

import com.example.materialdesign.databinding.ActivityAnimationBinding;

public class AnimationActivity extends AppCompatActivity {
    private ActivityAnimationBinding mViewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = ActivityAnimationBinding.inflate(getLayoutInflater());
        setContentView(mViewBinding.getRoot());

        // Set a toolbar for this activity
        Toolbar toolbar = (Toolbar) mViewBinding.animationActivityToolbar.getRoot();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Material Animation");

        // Set a transition animation for this activity
        setupWindowAnimation();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void setupWindowAnimation() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            Slide slide = new Slide();
            slide.setDuration(getResources().getInteger(R.integer.animation_duration_long));
            slide.setSlideEdge(Gravity.LEFT);
            // Set re-enter transition that is executed when returning back to this activity.
            getWindow().setReenterTransition(slide);
            // Set the exit transition that execute when the activity is exiting
            getWindow().setExitTransition(slide);
            // For overlap of re-entering this activity and exiting from other activity
            getWindow().setAllowReturnTransitionOverlap(false);  // Either specify here or in the theme
        }
    }

    // Ripple effect of Touch feedback animation
    public void toRippleEffects(View view) {
        startActivity(new Intent(this, RippleEffectActivity.class));
    }

    // Shared element transition of Activity transition
    public void sharedElementTransition(View view) {
        Pair[] pairs = new Pair[3];
        pairs[0] = new Pair<>(mViewBinding.imageSharedLogo, "sharedLogo");
        pairs[1] = new Pair<>(mViewBinding.textSharedElementTransition, "sharedElementTransition");
        pairs[2] = new Pair<>(mViewBinding.imageSharedProfile, "sharedProfilePhoto");

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, pairs);
            Intent intent = new Intent(this, SharedElementActivity.class);
            startActivity(intent, optionsCompat.toBundle());
        } else {
            Toast.makeText(this, getString(R.string.activity_transition_supported_note), Toast.LENGTH_LONG).show();
        }
    }

    // Enter & Exit transition using Explode transition of Activity transition
    public void explodeTransitionByCode(View view) {
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, TransitionActivity.class);
        intent.putExtra(Constant.KEY_ANIMATION_TYPE, Constant.TransitionType.ExplodeJava);
        intent.putExtra(Constant.KEY_ANIMATION_TITLE,
                (CharSequence) new StringBuilder(getResources().getString(R.string.explode_transition))
                        .append(" by ").append(getResources().getString(R.string.java_code)));
        startActivity(intent, optionsCompat.toBundle());
    }

    public void explodeTransitionByXML(View view) {
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, TransitionActivity.class);
        intent.putExtra(Constant.KEY_ANIMATION_TYPE, Constant.TransitionType.ExplodeXML);
        intent.putExtra(Constant.KEY_ANIMATION_TITLE,
                (CharSequence) new StringBuilder(getResources().getString(R.string.explode_transition))
                        .append(" by ").append(getResources().getString(R.string.xml)));
        startActivity(intent, optionsCompat.toBundle());
    }

    // Enter & Exit transition using Slide transition of Activity transition
    public void slideTransitionByCode(View view) {
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, TransitionActivity.class);
        intent.putExtra(Constant.KEY_ANIMATION_TYPE, Constant.TransitionType.SlideJava);
        intent.putExtra(Constant.KEY_ANIMATION_TITLE,
                (CharSequence) new StringBuilder(getResources().getString(R.string.slide_transition))
                        .append(" by ").append(getResources().getString(R.string.java_code)));
        startActivity(intent, optionsCompat.toBundle());
    }

    public void slideTransitionByXML(View view) {
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, TransitionActivity.class);
        intent.putExtra(Constant.KEY_ANIMATION_TYPE, Constant.TransitionType.SlideXML);
        intent.putExtra(Constant.KEY_ANIMATION_TITLE,
                (CharSequence) new StringBuilder(getResources().getString(R.string.slide_transition))
                        .append(" by ").append(getResources().getString(R.string.xml)));
        startActivity(intent, optionsCompat.toBundle());
    }

    // Enter & Exit transition using Fade transition of Activity transition
    public void fadeTransitionByCode(View view) {
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, TransitionActivity.class);
        intent.putExtra(Constant.KEY_ANIMATION_TYPE, Constant.TransitionType.FadeJava);
        intent.putExtra(Constant.KEY_ANIMATION_TITLE,
                (CharSequence) new StringBuilder(getResources().getString(R.string.fade_transition))
                        .append(" by ").append(getResources().getString(R.string.java_code)));
        startActivity(intent, optionsCompat.toBundle());
    }

    public void fadeTransitionByXML(View view) {
        ActivityOptionsCompat optionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this);
        Intent intent = new Intent(this, TransitionActivity.class);
        intent.putExtra(Constant.KEY_ANIMATION_TYPE, Constant.TransitionType.FadeXML);
        intent.putExtra(Constant.KEY_ANIMATION_TITLE,
                (CharSequence) new StringBuilder(getResources().getString(R.string.fade_transition))
                        .append(" by ").append(getResources().getString(R.string.xml)));
        startActivity(intent, optionsCompat.toBundle());
    }
}
