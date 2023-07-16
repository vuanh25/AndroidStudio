package com.example.baitaplan2;

public class SongModel {
    private String songCode;
    private String songName;
    private String artistName;

    private String lyric;

    public SongModel(String songCode, String songName, String artistName, String lyric) {
        this.songCode = songCode;
        this.songName = songName;
        this.artistName = artistName;
        this.lyric = lyric;
    }

    public String getLyric() {
        return lyric;
    }

    public void setLyric(String lyric) {
        this.lyric = lyric;
    }

    public String getSongCode() {
        return songCode;
    }

    public void setSongCode(String songCode) {
        this.songCode = songCode;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
