package com.songr.songr.Model;

public class Albums {

    private String title;
    private String artist;
    private String imageURL;
    private int songCount;
    private int lenght;


    public Albums(String title, String artist, String imageURL, int songCount, int lenght) {
        this.title = title;
        this.artist = artist;
        this.imageURL = imageURL;
        this.songCount = songCount;
        this.lenght = lenght;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public int getLenght() {
        return lenght;
    }

    public void setLenght(int lenght) {
        this.lenght = lenght;
    }
}
