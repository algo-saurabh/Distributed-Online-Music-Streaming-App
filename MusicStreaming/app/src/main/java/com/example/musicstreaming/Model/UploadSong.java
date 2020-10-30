package com.example.musicstreaming.Model;

public class UploadSong {
    public String songsCategory, songTitle, artist, album_art, songDuration, songLink, mKey;

    public UploadSong(String songsCategory, String songTitle, String artist, String album_art, String songDuration, String songLink) {

        if (songTitle.trim().equals("")){
            songTitle = "No title";
        }

        this.songsCategory = songsCategory;
        this.songTitle = songTitle;
        this.artist = artist;
        this.album_art = album_art;
        this.songDuration = songDuration;
        this.songLink = songLink;

    }

    public UploadSong(){

    }


    public String getSongsCategory() {
        return songsCategory;
    }

    public void setSongsCategory(String songsCategory) {
        this.songsCategory = songsCategory;
    }

    public String getSongTitle() {
        return songTitle;
    }

    public void setSongTitle(String songTitle) {
        this.songTitle = songTitle;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum_art() {
        return album_art;
    }

    public void setAlbum_art(String album_art) {
        this.album_art = album_art;
    }

    public String getSongDuration() {
        return songDuration;
    }

    public void setSongDuration(String songDuration) {
        this.songDuration = songDuration;
    }

    public String getSongLink() {
        return songLink;
    }

    public void setSongLink(String songLink) {
        this.songLink = songLink;
    }

    public String getmKey() {
        return mKey;
    }

    public void setmKey(String mKey) {
        this.mKey = mKey;
    }
}
