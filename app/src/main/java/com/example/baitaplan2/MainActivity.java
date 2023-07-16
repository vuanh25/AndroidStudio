package com.example.baitaplan2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<SongModel> songList;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        songList = new ArrayList<>();
        songList.add(new SongModel("123456", "Bài hát 1", "Ca sĩ 1","No Lyric"));
        songList.add(new SongModel("654321", "Bài hát 2", "Ca sĩ 2","No Lyric"));
        songList.add(new SongModel("987654", "Bài hát 3", "Ca sĩ 3","No Lyric"));


        recyclerView = findViewById(R.id.recyclerView);
        adapter = new MyAdapter(songList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



        ItemTouchHelper.SimpleCallback itemTouchHelperCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();

                songList.remove(position);

                adapter.notifyItemRemoved(position);
                Toast.makeText(MainActivity.this, "Đã xóa bài hát", Toast.LENGTH_SHORT).show();
            }
        };

        new ItemTouchHelper(itemTouchHelperCallback).attachToRecyclerView(recyclerView);

        FloatingActionButton fabAddSong = findViewById(R.id.fab);
        fabAddSong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddSongDialog();
            }
        });
    }


    private void showAddSongDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.add_song, null);
        builder.setView(dialogView);

        EditText etSongCode = dialogView.findViewById(R.id.etSongCode);
        EditText etSongName = dialogView.findViewById(R.id.etSongName);
        EditText etArtistName = dialogView.findViewById(R.id.etArtistName);
        EditText eLyric = dialogView.findViewById(R.id.eLyricName);

        builder.setPositiveButton("Thêm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String songCode = etSongCode.getText().toString();
                String songName = etSongName.getText().toString();
                String artistName = etArtistName.getText().toString();
                String lyric = eLyric.getText().toString();

                if (!songCode.isEmpty() && !songName.isEmpty() && !artistName.isEmpty()) {
                    SongModel newSong = new SongModel(songCode, songName, artistName,lyric);
                    songList.add(newSong);
                    adapter.notifyItemInserted(songList.size() - 1);
                    Toast.makeText(MainActivity.this, "Đã thêm bài hát mới", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }
}