package com.example.homework10.controller;

import com.example.homework10.entity.Music;

public class MusicResponse {
    private int id;
    private String title;
    private String singer;

    public MusicResponse(int id, String title, String singer) {
        this.id = id;
        this.title = title;
        this.singer = singer;
    }

    public MusicResponse(Music music) {
        this.id = music.getId();
        this.title = music.getTitle();
        this.singer = music.getSinger();
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
