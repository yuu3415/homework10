package com.example.homework10.Cntroller;

public class MusicResponse {
    private int id;
    private String title;
    private String singer;

    public MusicResponse(int id, String title, String singer) {
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

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }
}
