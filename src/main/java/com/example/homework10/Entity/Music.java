package com.example.homework10.Entity;

public class Music {
    private int id;
    private String title;
    private String singer;

    public Music(int id, String title, String singer) {
        this.id = id;
        this.title = title;
        this.singer = singer;

    }

 
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSinger() {
        return singer;
    }
}
