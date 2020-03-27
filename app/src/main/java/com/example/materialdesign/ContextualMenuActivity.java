package com.example.materialdesign;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.widget.Toolbar;

import com.example.materialdesign.databinding.ActivityContextualMenuBinding;

public class ContextualMenuActivity extends AppCompatActivity {
    private ActivityContextualMenuBinding mViewBinding;
    private Toolbar mToolbar;
    private ActionMode actionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = ActivityContextualMenuBinding.inflate(getLayoutInflater());
        setContentView(mViewBinding.getRoot());

        mToolbar = (Toolbar) mViewBinding.toolbar.getRoot();
        mToolbar.setTitle("Standalone toolbar");
        mToolbar.setSubtitle("by Abdullah Almasud");
        mToolbar.inflateMenu(R.menu.menu_main);
        mToolbar.setOnMenuItemClickListener(item -> {
            Toast.makeText(this, item.getTitle() + " selected", Toast.LENGTH_SHORT).show();
            switch (item.getItemId()) {
                case R.id.save:
                    // Perform save action
                    break;
                case R.id.email:
                    // Perform email action
                    break;
            }
            return true;
        });

        mViewBinding.buttonContextualMenu.setOnClickListener(view -> {
            // Change the button background color and set the action mode
            mViewBinding.buttonContextualMenu.setBackgroundColor(getResources().getColor(R.color.gray_800));
            actionMode = this.startSupportActionMode(new ContextualCallback());
        });
    }

    private class ContextualCallback implements ActionMode.Callback {
        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            mode.getMenuInflater().inflate(R.menu.contextual_menu, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            mode.setTitle("My Action Mode");
            mode.setSubtitle("by Abdullah Almasud");
            return true;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            Toast.makeText(getApplicationContext(), item.getTitle() + " selected", Toast.LENGTH_SHORT).show();
            switch (item.getItemId()) {
                case R.id.delete:
                    // Perform delete action
                    break;
                case R.id.cut_content:
                    // Perform cut action
                    break;
            }
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {
            // After completing the action mode change the button background color to previous
            mViewBinding.buttonContextualMenu.setBackgroundColor(Color.parseColor("#f955f3"));
        }
    }
}
