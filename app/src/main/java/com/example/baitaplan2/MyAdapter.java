package com.example.baitaplan2;
import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<SongModel> itemList;

    public MyAdapter(List<SongModel> itemList) {
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SongModel song = itemList.get(position);
        holder.songCodeTextView.setText(song.getSongCode());
        holder.songNameTextView.setText(song.getSongName());
        holder.artistNameTextView.setText(song.getArtistName());
        holder.lyricTextView.setText(song.getLyric());





    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView songCodeTextView;
        TextView songNameTextView;
        TextView artistNameTextView;
        TextView lyricTextView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            songCodeTextView = itemView.findViewById(R.id.songCodeTextView);
            songNameTextView = itemView.findViewById(R.id.songNameTextView);
            artistNameTextView = itemView.findViewById(R.id.artistNameTextView);
            lyricTextView = itemView.findViewById(R.id.lyricTextView);
        }
    }
}


