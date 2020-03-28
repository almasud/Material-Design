package com.example.materialdesign;

import android.content.Intent;
import android.os.Bundle;
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

        Toolbar toolbar = (Toolbar) mViewBinding.animationActivityToolbar.getRoot();
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Material Animation");
    }

    public void toRippleEffects(View view) {
        startActivity(new Intent(this, RippleEffectActivity.class));
    }

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

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
