package com.example.wip.screens.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SortedList;

import com.example.wip.R;
import com.example.wip.model.Thing;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ThingViewHolder> {

    private SortedList<Thing> sortedList;

    public Adapter(){
        sortedList = new SortedList<>(Thing.class, new SortedList.Callback<Thing>() {
            @Override
            public int compare(Thing o1, Thing o2) {
                return 0;
            }

            @Override
            public void onChanged(int position, int count) {

            }

            @Override
            public boolean areContentsTheSame(Thing oldItem, Thing newItem) {
                return false;
            }

            @Override
            public boolean areItemsTheSame(Thing item1, Thing item2) {
                return false;
            }

            @Override
            public void onInserted(int position, int count) {

            }

            @Override
            public void onRemoved(int position, int count) {

            }

            @Override
            public void onMoved(int fromPosition, int toPosition) {

            }
        });
    }

    @NonNull
    @Override
    public ThingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ThingViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_clothes_list, parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ThingViewHolder holder, int position) {
        holder.bind(sortedList.get(position));
    }

    @Override
    public int getItemCount() {
        return sortedList.size();
    }

    public void setItems(List<Thing> thing) {
        sortedList.replaceAll(thing);
    }

    static class ThingViewHolder extends RecyclerView.ViewHolder {

        TextView thingName;

        Thing thing;

        public ThingViewHolder(@NonNull View itemView) {
            super(itemView);

            thingName = itemView.findViewById(R.id.thing_name);
        }

        public void bind(Thing thing){
            this.thing = thing;

            thingName.setText(thing.name);
        }
    }
}
