package com.songr.songr.Model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Albums {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    private String title;
    private String artist;
    private String imageURL;
    private int songCount;
    private int length;

    @OneToMany(mappedBy = "albums")
    private List<Song> songs;

    public Albums() {

    }

    public Long getId() {
        return id;
    }

    public Albums(String title, String artist, String imageURL, int songCount, int length) {
        this.title = title;
        this.artist = artist;
        this.imageURL = imageURL;
        this.songCount = songCount;
        this.length = length;
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
    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
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

    public int getLength() {
        return length;
    }

    public void setLength(int lenght) {
        this.length = lenght;
    }
}
