package com.example.materialdesign.ui.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialdesign.R;
import com.example.materialdesign.databinding.ActivityRecycleNCardViewBinding;
import com.example.materialdesign.model.Person;
import com.example.materialdesign.ui.adapter.RecycleNCardViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class RecycleNCardViewActivity extends AppCompatActivity {
    private ActivityRecycleNCardViewBinding mViewBinding;
    private RecycleNCardViewAdapter mViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = ActivityRecycleNCardViewBinding.inflate(getLayoutInflater());
        setContentView(mViewBinding.getRoot());

        // Set the toolbar
        setSupportActionBar((Toolbar) mViewBinding.toolbarRecyclerCardView.getRoot());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setSubtitle(getResources().getString(R.string.recycler_and_card_view));

        // Set the recycler view and adapter
        mViewAdapter = new RecycleNCardViewAdapter(new ArrayList<>());
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        mViewBinding.recyclerCardView.setLayoutManager(layoutManager);
        mViewBinding.recyclerCardView.setAdapter(mViewAdapter);
        // Set an animator to recycler view
        // setItemAnimator() is not working with notifyDataSetChanged().
        mViewBinding.recyclerCardView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Add a list of persons to update recycler view adapter
        List<Person> persons = new ArrayList<>();
        persons.add(new Person("Abdullah Almasud", "013XXXXXXXX", R.drawable.almasud));
        persons.add(new Person("Muhaiminul Mahin", "014XXXXXXXX", R.drawable.mahin));
        persons.add(new Person("Unknown Person", "015XXXXXXXX", R.drawable.ic_account_circle_gray_24dp));
        persons.add(new Person("Backup", "015XXXXXXXX", R.drawable.ic_backup_gray_24dp));
        persons.add(new Person("Help", "016XXXXXXXX", R.drawable.ic_help_gray_24dp));
        persons.add(new Person("Language", "017XXXXXXXX", R.drawable.ic_language_gray_24dp));
        persons.add(new Person("Vice Chat", "018XXXXXXXX", R.drawable.ic_voice_chat_gray_24dp));
        persons.add(new Person("Vice Mail", "019XXXXXXXX", R.drawable.ic_voicemail_gray_24dp));
        persons.add(new Person("VPN Lock", "018XXXXXXXX", R.drawable.ic_vpn_lock_gray_24dp));
        persons.add(new Person("Wifi Gray", "018XXXXXXXX", R.drawable.ic_wifi_gray_24dp));
        persons.add(new Person("Wifi Tethering", "019XXXXXXXX", R.drawable.ic_wifi_tethering_gray_24dp));

        // Update the recycler view adapter
        mViewAdapter.updatePersons(persons);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
