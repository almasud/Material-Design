package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.Toast;

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
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setSubtitle(getResources().getString(R.string.floating_label_for_edit_text));

        mViewBinding.buttonSignUp.setOnClickListener(view -> {
            signUp();
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

    private void signUp() {
        // Validate the input data before proceed to sign up
        boolean isValid = true;

        if (mViewBinding.editTextFullName.getText().toString().isEmpty()) {
            isValid = false;
            mViewBinding.inputLayoutFullName.setError(getResources().getString(R.string.name_filed_required));
        } else {
            mViewBinding.inputLayoutFullName.setErrorEnabled(false);
        }

        if (mViewBinding.editTextEmail.getText().toString().isEmpty()) {
            isValid = false;
            mViewBinding.inputLayoutEmail.setError(getResources().getString(R.string.email_filed_required));
        } else {
            mViewBinding.inputLayoutEmail.setErrorEnabled(false);
        }

        if (mViewBinding.editTextPassword.getText().toString().isEmpty()) {
            isValid = false;
            mViewBinding.inputLayoutPassword.setError(getResources().getString(R.string.password_filed_required));
        } else if(mViewBinding.editTextPassword.getText().toString().trim().length() < 8) {
            isValid = false;
            mViewBinding.inputLayoutPassword.setError(getResources().getString(R.string.password_minimum_characters));
        } else {
            mViewBinding.inputLayoutPassword.setErrorEnabled(false);
        }

        if (isValid) {
            // Complete the sign up process after the validation of input data
            Toast.makeText(this, getResources().getString(R.string.validation_welcome_message), Toast.LENGTH_SHORT).show();
        }
    }
}
