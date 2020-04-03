package com.example.materialdesign.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.materialdesign.R;
import com.example.materialdesign.databinding.ItemRecycleCardViewBinding;
import com.example.materialdesign.model.Person;

import java.util.List;

public class RecycleNCardViewAdapter extends RecyclerView.Adapter<RecycleNCardViewAdapter.PersonViewHolder> {
    private List<Person> mPersons;

    public RecycleNCardViewAdapter(List<Person> mPersons) {
        this.mPersons = mPersons;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemRecycleCardViewBinding viewBinding = ItemRecycleCardViewBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new PersonViewHolder(viewBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person person = mPersons.get(position);
        holder.setPerson(person);
        holder.setListeners();
    }

    @Override
    public int getItemCount() {
        return mPersons.size();
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ItemRecycleCardViewBinding viewBinding;
        private Person person;

        public PersonViewHolder(@NonNull ItemRecycleCardViewBinding itemViewBinding) {
            super(itemViewBinding.getRoot());
            viewBinding = itemViewBinding;
        }

        public void setPerson(Person person) {
            this.person = person;
            viewBinding.imageRecyclerCardView.setImageResource(person.getPhotoId());
            viewBinding.nameRecyclerCardView.setText(person.getName());
            viewBinding.phoneRecyclerCardView.setText(person.getPhone());
        }

        public void setListeners() {
            viewBinding.imageRecyclerCardView.setOnClickListener(PersonViewHolder.this);
            viewBinding.imageButtonCopyRecyclerCardView.setOnClickListener(PersonViewHolder.this);
            viewBinding.imageButtonDeleteRecyclerCardView.setOnClickListener(PersonViewHolder.this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.imageButtonCopyRecyclerCardView:
                    addItem(getAdapterPosition(), person);
                    break;
                case R.id.imageButtonDeleteRecyclerCardView:
                    removeItem(getAdapterPosition());
                    break;
            }
        }

        private void removeItem(int position) {
            mPersons.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, mPersons.size());
//            notifyDataSetChanged();
        }

        private void addItem(int position, Person person) {
            mPersons.add(position, person);
            notifyItemInserted(position);
            notifyItemRangeChanged(position, mPersons.size());
//            notifyDataSetChanged();
        }
    }

    public void updatePersons(List<Person> persons) {
        mPersons = persons;
        notifyDataSetChanged();
    }
}
